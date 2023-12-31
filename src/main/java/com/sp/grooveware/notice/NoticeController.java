package com.sp.grooveware.notice;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.grooveware.common.FileManager;
import com.sp.grooveware.common.MyUtil;
import com.sp.grooveware.member.SessionInfo;

// 그룹웨어 
// gubun 이 null 이면 전체 공지 
@Controller("notice.noticeController")
@RequestMapping("/notice/{gubun}/*")
public class NoticeController {


	@Autowired
	private NoticeService service;

	@Autowired
	@Qualifier("myUtilGeneral")
	private MyUtil myUtil;
	
	@Autowired
	private FileManager fileManager;
	
	
	@RequestMapping(value = "list")
	public String list(
				@PathVariable String gubun,
				@RequestParam(value = "page", defaultValue = "1") int current_page,
	            @RequestParam(defaultValue = "all") String condition,
	            @RequestParam(defaultValue = "") String keyword,
	            HttpSession session,
	            HttpServletRequest req,
	            Model model) throws Exception {
	   
		SessionInfo info = (SessionInfo) session.getAttribute("member");
		
		int size = 10;
		int total_page = 0;
		int dataCount = 0;
		
		if (req.getMethod().equalsIgnoreCase("GET")) { // GET 방식인 경우
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
		
		// 전체 페이지 수
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gubun", gubun);
		map.put("dept_id", info.getDept_no());
		map.put("condition", condition);
		map.put("keyword", keyword);

		dataCount = service.dataCount(map);
		if (dataCount != 0) {
			total_page = dataCount / size + (dataCount % size > 0 ? 1 : 0);
		}
		
		// 다른 사람이 자료를 삭제하여 전체 페이지수가 변화 된 경우
		if (total_page < current_page) {
			current_page = total_page;
		}
		
		// 리스트에 출력할 데이터를 가져오기
		int offset = (current_page - 1) * size;
		if(offset < 0) offset = 0;

		map.put("offset", offset);
		map.put("size", size);
		
		// 글 리스트
		List<Notice> list = service.listNotice(map);
		
		// 페이징
		String cp = req.getContextPath();
		String query = "";
		String listUrl = cp + "/notice/" + gubun + "/list";
		String articleUrl = cp + "/notice/" + gubun + "/article?page=" + current_page;
		if (keyword.length() != 0) {
			query = "condition=" + condition + "&keyword=" + URLEncoder.encode(keyword, "utf-8");
		}

		if (query.length() != 0) {
			listUrl += "?" + query;
			articleUrl += "&" + query;
		}

		String paging = myUtil.paging(current_page, total_page, listUrl);
		
		model.addAttribute("gubun", gubun);
		model.addAttribute("dept_name", info.getDept_name());
		
		model.addAttribute("list", list);
		model.addAttribute("page", current_page);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("size", size);
		model.addAttribute("total_page", total_page);

		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);

		model.addAttribute("articleUrl", articleUrl);
		model.addAttribute("paging", paging);
		
	    return ".notice.list";
	 
	}

	
		@RequestMapping(value = "article", method = RequestMethod.GET)
		public String article(			
			@PathVariable String gubun, // url 경로에 gubun 변수넣음 
		    @RequestParam long noti_id,
		    @RequestParam String page,
		    @RequestParam(defaultValue = "all") String condition,
		    @RequestParam(defaultValue = "") String keyword,
		    Model model, HttpSession session) throws Exception {
	
		    SessionInfo info = (SessionInfo) session.getAttribute("member");
		    keyword = URLDecoder.decode(keyword, "utf-8");
	
		    String query = "page=" + page;
		    if (keyword.length() != 0) {
		        query += "&condition=" + condition +
		                "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		    }
	
		    Notice dto = service.readNotice(noti_id);
		    
		    service.updateHitCount(noti_id);
	
		    if (dto == null) {
		        return "redirect:/notice/" + gubun + "/list?" + query;
		    }
	
		    

		    model.addAttribute("dto",dto);
		    model.addAttribute("page", page);
			model.addAttribute("query", query);
			
			model.addAttribute("gubun", gubun);
			model.addAttribute("dept_name", info.getDept_name());
		   
		    return ".notice.article";
		}
	

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeForm(
			@PathVariable String gubun,
			Model model, HttpSession session) throws Exception {
		SessionInfo info = (SessionInfo) session.getAttribute("member");
		
		model.addAttribute("gubun", gubun);
		model.addAttribute("dept_name", info.getDept_name());
		model.addAttribute("mode", "write");
	    
	    return ".notice.write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeSubmit(
			@PathVariable String gubun,
			Notice dto, HttpSession session) throws Exception {
		
		SessionInfo info = (SessionInfo) session.getAttribute("member");
		
		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "notice";
		try {
			dto.setEmp_no(info.getEmp_no());
			if(gubun.equals("dept")) {
				dto.setDept_id(info.getDept_no());
			}
			
			service.insertNotice(dto, pathname);

		} catch (Exception e) {

		}

	    
	    return "redirect:/notice/"+gubun+"/list";
	}
	
	@GetMapping("update")
	public String updateForm(
			@PathVariable String gubun,
			@RequestParam long noti_id,
			@RequestParam String page,
			HttpSession session,
			Model model) throws Exception {
		
		SessionInfo info = (SessionInfo) session.getAttribute("member");
		
		Notice dto = service.readNotice(noti_id);
		if(dto == null) {
			 return "redirect:/notice/"+gubun+"/list" + page;
		}
		
		model.addAttribute("mode", "update");
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		model.addAttribute("gubun", gubun);
		model.addAttribute("dept_name", info.getDept_name());
		
		return ".notice.write";
	}
	
	
	
	
	@PostMapping("update")
	public String updateSubmit(
			@PathVariable String gubun,
			@RequestParam String page,
			Notice dto,
			HttpSession session) throws Exception {

		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "notice";

		try {
			service.updateNotice(dto, pathname);
		} catch (Exception e) {
		}

	    return "redirect:/notice/"+gubun+"/list";
	}
	
	

	@RequestMapping(value = "delete")
	public String delete(
			@PathVariable String gubun,
			@RequestParam long noti_id,
			@RequestParam String page,
			Model model,
			HttpServletResponse resp,
			@RequestParam(defaultValue = "all") String condition,
			@RequestParam(defaultValue = "") String keyword,
			HttpSession session) throws Exception {
		SessionInfo info = (SessionInfo) session.getAttribute("member");

		if (info.getDept_no() != 60) {
			
		        // DEPT_NO가 60이 아닌 경우 삭제 작업을 수행하지 않고,리스트 페이지로 이동
			  model.addAttribute("message", "관리자만 삭제 가능합니다.");
		       return "redirect:/notice/"+gubun+"/list";
		        
		}
		keyword = URLDecoder.decode(keyword, "utf-8");
		String query = "page=" + page;
		if (keyword.length() != 0) {
			query += "&condition=" + condition + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}

		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "notice";

		service.deleteNotice(noti_id, pathname, info.getEmp_no());

		return "redirect:/notice/"+gubun+"/list?" + query;
	}
 
	
	
	
	@GetMapping(value = "download")
	public void download(
			@PathVariable String gubun,
	        @RequestParam long noti_id,
	        HttpServletResponse resp,
	        HttpSession session) throws Exception {

	    String root = session.getServletContext().getRealPath("/");
	    String pathname = root + "uploads" + File.separator + "notice";

	    Notice dto = service.readNotice(noti_id);    

	    if (dto != null) {
	        String originalFilename = dto.getOriginal_filename();
	        
	        if (originalFilename != null) {
	            boolean b = fileManager.doFileDownload(
	            dto.getSave_filename(), dto.getOriginal_filename(), pathname, resp);
	    
	            if (b) {
	                return;
	            } 
	        } 
	    }
	    
	    resp.setContentType("text/html;charset=utf-8");
	    PrintWriter out = resp.getWriter();
	    out.print("<script>alert('파일 다운로드가 실패했습니다.');history.back();</script>");
	}
}
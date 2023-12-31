package com.sp.grooveware.goal;

import java.util.List;
import java.util.Map;

import com.sp.grooveware.task.Task;

public interface GoalService {
    public void insertGoal1(Goal dto, String pathname) throws Exception;
    public void insertGoal2(Goal dto, String pathname) throws Exception;
    public List<Goal> listGoal(Map<String, Object> map);	
    public Goal readGoal(long goal_no);
    public String readparentname(long num);
    public String readprojectname(long num);
    
    public int dataCount(long pj_no);
    public int readstatus(long pj_no);
    
    public void updateGoal(Goal dto, String pathname) throws Exception;
    public void insertGoalmember(Goal dto) throws Exception;
    
    
    public void deleteGoal(long pj_no, long goal_no, long emp_no, String pathname) throws Exception;
    
    public void deleteGoalmember(Map<String, Object> map) throws Exception;
    
    
    public List<Goal> listEmp(Map<String, Object> map);	// 모달에서 참여맴버
    
    public List<Goal> listDepth1(Map<String, Object> map);	// write에서 select박스
    public List<Goal> listDepth2(Map<String, Object> map);	// write에서 select박스

    public Goal selectParent(long goal_no);
    
    public Goal readPjname(long pj_no);
    public int readAcess(Map<String, Object> map);

    public List<Goal> readGoalmember(long goal_no);

    public List<Task> readTaskmember(long goal_no);
    public int taskCount(long goal_no);
    public int finishCount(long goal_no);
}

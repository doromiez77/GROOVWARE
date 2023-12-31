<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	
	 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/jquery/css/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/fontawesome/css/all.min.css" type="text/css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/insaInfo.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/paginate.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tabs.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css">
	
	 
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/js/jquery.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/util-jquery.js"></script>
	<!-- 
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu2.js"></script>
	 -->
</head>

<body style="background: #8ebeff14;">

	<div class="container body-container">
		
		<main class="main-body">
			<tiles:insertAttribute name="body"/>
		</main>
	
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/js/jquery.ui.datepicker-ko.js"></script>


</body>
</html>
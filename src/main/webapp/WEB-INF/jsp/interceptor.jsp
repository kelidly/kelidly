<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GB18030"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=basePath %>/common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/login/js/validateCode.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/login/js/login.js"></script>
<body>
<h1>拦截成功</h1>
	拦截成功!
	
</body>
</html>
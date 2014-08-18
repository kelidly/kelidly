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
<h1>Hello World!</h1>

<script language="javascript">
	//只能输入数字
	function onlyNum(ele) {
		ele.value=ele.value.replace(/[^\d]/g,'');
	}
</script>
     ${bean.id }<br>
     ${bean.picture }<br>
     ${bean.intro }<br>
     ${bean.name }<br>
<form action="/newrdt/user/loginUser" method="post">
	<input type="hidden" id= "type" name="type" value="web" />
	用 户 名：<input type="text" id= "userName" name="userName" /><br/>
	密  码：<input type="password" id= "pwd" name="pwd" /><br/>
	<input type="submit" value="提交" />
</form>
</body>
</html>
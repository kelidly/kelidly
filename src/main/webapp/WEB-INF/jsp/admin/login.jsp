<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理登录</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="<%=basePath %>/common/admin/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="<%=basePath %>/common/admin/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="<%=basePath %>/common/admin/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/jquery.wysiwyg.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>后台登录</h1>
    <!-- Logo (221px width) -->
    <a href="#"><img id="logo" src="<%=basePath %>/common/admin/images/logo.png" alt="网站管理员后台" /></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form action="<%=basePath %>/admin/login" >
   <input type="hidden" name=type id=type value="web"/>
   


<c:choose>
   <c:when test="${login_mark =='success'}">
    <div class="notification success png_bg">
        <div> 登陆成功</div>
      </div>
  </c:when>
    <c:when test="${login_mark =='error'}">
      <div class="notification error png_bg">
        <div> 输入用户名或密码有误</div>
      </div>
  </c:when>
  <c:otherwise>
   <div class="notification information png_bg">
        <div> 请输入登陆信息</div>
      </div>
  </c:otherwise>
</c:choose>

      <p>
        <label>用户名</label>
        <input class="text-input" type="text" name=adminName id=adminName/>
      </p>
      <div class="clear"></div>
      <p>
        <label>密&nbsp;&nbsp;码</label>
        <input class="text-input" type="password" name=pwd id=pwd />
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
        记住我？ </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="登录" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
</body>
</html>

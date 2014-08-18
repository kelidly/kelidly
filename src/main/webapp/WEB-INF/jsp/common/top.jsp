<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->

<link rel="stylesheet" href="<%=basePath %>/common/admin/css/reset.css" type="text/css" media="screen" />
<link rel="shortcut icon" href="http://localhost:8080/kelidly/favicon.ico" type="image/x-icon">
<link rel="icon" href="http://localhost:8080/kelidly/favicon.ico" type="image/x-icon">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="<%=basePath %>/common/admin/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="<%=basePath %>/common/admin/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
 <script type="text/javascript" src="<%=basePath %>/common/js/My97DatePicker/WdatePicker.js"></script> 
<!-- jQuery -->
 <script type="text/javascript" src="<%=basePath %>/common/front/js/jquery.min.js"></script> --%>
<!-- jQuery Configuration -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/admin/scripts/jquery.date.js"></script>
    
    <script type="text/javascript" src="<%=basePath %>/common/js/imgReview/jquery.imgreview.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/common/admin/scripts/common.js"></script>
</head>
<body>
<div id="body-wrapper">
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <h1 id="sidebar-title"><a href="#">后台管理</a></h1>
      <a href="http://www.ewceo.com"><img id="logo" src="<%=basePath %>/common/admin/images/logo.png" alt="后台管理" /></a>
      <div id="profile-links"> 你好, <a href="#">管理员</a>, 您有 <a href="#messages" rel="modal">3 条新消息</a><br />
        <br />
        <a href="#">网站首页</a> | <a href="<%=basePath %>/back/login">退出</a> </div>
      <ul id="main-nav">
        <li> <a href="#" class="nav-top-item no-submenu">
          统计信息 </a> </li>
        <li> <a href="#" class="nav-top-item current">
          新闻管理 </a>
          <ul>
            <li><a href="<%=basePath %>/back/news/pub">发布文章</a></li>
            <li><a class="current" href="<%=basePath %>/back/news/manage">文章管理</a></li>
            <li><a href="<%=basePath %>/back/news/toTypeView">类目管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          产品管理 </a>
          <ul>
            <li><a href="<%=basePath %>/back/product/pub">发布产品</a></li>
            <li><a href="<%=basePath %>/back/product/manage">产品管理</a></li>
            <li><a href="#">评论管理</a></li>
            <li><a href="<%=basePath %>/back/product/toTypeView">类目管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          产品范例 </a>
          <ul>
            <li><a href="<%=basePath %>/back/productDemo/pub">发布范例</a></li>
            <li><a href="<%=basePath %>/back/productDemo/manage">范例管理</a></li>
            <li><a href="<%=basePath %>/back/productDemo/toTypeView">类目管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          客户案例 </a>
          <ul>
            <li><a href="<%=basePath %>/back/case/pub">发布案例</a></li>
            <li><a href="<%=basePath %>/back/case/manage">案例管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          关于我们 </a>
          <ul>
            <li><a href="<%=basePath %>/back/about/updateView?aboutId=1">公司简介</a></li>
            <li><a href="<%=basePath %>/back/about/updateView?aboutId=2">资质证明</a></li>
            <li><a href="<%=basePath %>/back/about/updateView?aboutId=3">联系我们</a></li>
            <li><a href="<%=basePath %>/back/about/updateView?aboutId=4">合作推广</a></li>
            <li><a href="<%=basePath %>/back/words/manage">查看留言</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          友情链接 </a>
          <ul>
            <li><a href="<%=basePath %>/back/links/pub">添加链接</a></li>
            <li><a href="<%=basePath %>/back/links/manage">链接管理</a></li>
          </ul>
        </li>

        <li> <a href="#" class="nav-top-item"> 广告管理 </a>
          <ul>
            <li><a href="#">上传图片</a></li>
            <li><a href="#">图片管理</a></li>
            <li><a href="#">相册管理</a></li>
            <li><a href="#">图片管理设置</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 管理日志 </a>
          <ul>
            <li><a href="#">查看日志</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 设置 </a>
          <ul>
            <li><a href="#">一般管理</a></li>
            <li><a href="#">我的信息</a></li>
            <li><a href="#">用户权限</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <!-- End #sidebar -->
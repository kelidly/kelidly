<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base  href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻动态_</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="common/front/css/BigRed/inner.css" rel="stylesheet" type="text/css" />
<link href="common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="common/front/js/functions.js"></script>
<script type="text/javascript" src="common/front/images/iepng/iepngfix_tilebg.js"></script>
</head>

<body>
<div id="wrapper">

<!--head start-->
<jsp:include page="../../common/top_menu.jsp"></jsp:include>

</div>
<!--head end-->
<!--body start-->
<div id="body">
<!--focus start-->
<div id="InnerBanner">

</div>
<!--foncus end-->
<div class="HeightTab clearfix"></div>
<!--inner start -->
<div class="inner">
<!--left start-->
<div class="left">
<div class="Sbox">
<div class="topic">产品范例&nbsp;&nbsp;&nbsp;Product Demo</div>
<div class="blank">
<ul>
<c:forEach var="bean" items="${typeList}">
<li><A href='<%=basePath %>productDemo/index?typeId=${bean.id}&useId=${bean.useBean.id}'>${bean.type}</A></li> 
</c:forEach>
</ul>
</div>
</div>
<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">热门范例&nbsp;&nbsp;&nbsp;Hot</div>
<div class="list">
<dl>
  <c:forEach var="bean"  varStatus="status" items="${recentList}"  >

<dd><a href='<%=basePath %>productDemo/detail?id=${bean.id}&typeId=${bean.typeBean.id}&useId=${bean.typeBean.useBean.id}' target='_blank' title=''>${fn:substring(bean.name, 0, 15)}</a></dd>
</c:forEach>

</dl>
</div>

</div>
<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">联系我们&nbsp;&nbsp;&nbsp;Contact</div>
<div class="txt ColorLink">
<p>地址：</p>
<p>电话：</p>
<p>传真：</p>
<p>邮件：</p>
<p>网站：<a href='' target='_blank'></a> </p>
<p align='center'><a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> &nbsp;&nbsp;<a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> </p></div>
</div>

<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">搜索&nbsp;&nbsp;&nbsp;Search</div>
<div class="SearchBar">
<form method="get" action="/Search/index.asp">
				<input type="text" name="q" id="search-text" size="15" onBlur="if(this.value=='') this.value='请输入关键词';" 
onfocus="if(this.value=='请输入关键词') this.value='';" value="请输入关键词" /><input type="submit" id="search-submit" value="搜索" />
			</form>
</div>
</div>
</div>
<!--left end-->
<!--right start-->
<div class="right">
<div class="Position"><span>你的位置：<a href="/">首页</a> > <a href='<%=basePath %>news/index?typeId=${newsType.id}'>${newsType.type}</a></span></div>
<div class="HeightTab clearfix"></div>
<!--main start-->
<div class="main">
<h3>2D静态、360°、3D动态影像范例</h3>
<br>
<div class="content">
            <div class="MorePro">
              <div class="CaseBlock">
                <ul>
                  <ul>             
                  <c:forEach items="${useList}" var="usebean">
                  <div class='albumblock'>
                      <div class='inner'><a href='<%=basePath%>productDemo/show?useId=${usebean.id}' target='_blank'  title='${usebean.name}'>
                      <img src='<%=basePath%>${fn:replace(usebean.img,"use","186-use")}' />
                        <div class='albumtitle'>${usebean.name}</div>
                        </a></div>
                    </div>
                  </c:forEach>
                  </ul>
                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>

</div>
<!--main end-->
</div>
<!--right end-->
</div>
<!--inner end-->
</div>
<!--body end-->
<jsp:include page="../../common/bottom.jsp"></jsp:include>






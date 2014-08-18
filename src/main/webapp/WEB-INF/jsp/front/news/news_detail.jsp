<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三大运营商用户争夺战升级：管道是绕不过的坎-外贸演示</title>
<meta name="description" content="业内人士分析，高端品牌主要是受到苹果iPhone的挤压，市场关注度和份额都在不断下降。另一方面，与中国运营商的合作，利用运营商的渠道和补贴，既能扩大市场份额又能增加盈利。 

">
<meta name="keywords" content="运营商，用户">
<link href="<%=basePath%>/common/front/css/BigRed/inner.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/common/front/js/functions.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/images/iepng/iepngfix_tilebg.js"></script>
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
    <div id="InnerBanner"> </div>
    <!--foncus end-->
    <div class="HeightTab clearfix"></div>
    <!--inner start -->
    <div class="inner"> 
      <!--left start-->
      <div class="left">
        <div class="Sbox">
          <div class="topic">新闻动态&nbsp;&nbsp;&nbsp;News</div>
          <div class="blank">
            <ul>
<c:forEach var="bean" items="${typeList}">
<li><A href='<%=basePath %>/news/index?typeId=${bean.id}'>${bean.type}</A></li> 
</c:forEach>
            </ul>
          </div>
        </div>
        <div class="HeightTab clearfix"></div>
        <div class="Sbox">
          <div class="topic">最新资讯&nbsp;&nbsp;&nbsp;New</div>
          <div class="list">
            <dl>
<c:forEach var="bean"  varStatus="status" items="${recentList}"  >
<dd><a href='<%=basePath %>/news/detail?id=${bean.id}&typeId=${bean.typeId}' target='_blank' title=''>${fn:substring(bean.title, 0, 15)}</a></dd>
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
            <p align='center'><a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>/common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> &nbsp;&nbsp;<a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>/common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> </p>
          </div>
        </div>
        <div class="HeightTab clearfix"></div>
        <div class="Sbox">
          <div class="topic">搜索&nbsp;&nbsp;&nbsp;Search</div>
          <div class="SearchBar">
            <form method="get" action="/Search/index.asp">
              <input type="text" name="q" id="search-text" size="15" onBlur="if(this.value=='') this.value='请输入关键词';" 
onfocus="if(this.value=='请输入关键词') this.value='';" value="请输入关键词" />
              <input type="submit" id="search-submit" value="搜索" />
            </form>
          </div>
        </div>
      </div>
      <!--left end--> 
      <!--right start-->
      <div class="right">
        <div class="Position"><span>你的位置：<a href="/">首页</a> > <a href='<%=basePath %>/news/index?typeId=${newsBean.typeId}'>${newsBean.newsType.type}</a></span></div>
        <div class="HeightTab clearfix"></div>
        <!--main start-->
        <div class="main"> 
          
          <!--content start-->
          <div class="content">
            <div class="title">
              <h3>${newsBean.title}</h3>
            </div>
            <div class="infos"><fmt:formatDate value="${newsBean.pubTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击：${newsBean.hot}<script language="javascript" src="<%=basePath%>/common/front/inc/article_view.asp?id=957"></script></div>
            <div class="maincontent clearfix">
              <div id="MainContent" class="maincontent clearfix">
                ${newsBean.content}
                
              </div>
            </div>
          </div>
          <!--content end--> 
          
        </div>
        <!--main end--> 
      </div>
      <!--right end--> 
    </div>
    <!--inner end--> 
  </div>
  <!--body end-->
<jsp:include page="../../common/bottom.jsp"></jsp:include>
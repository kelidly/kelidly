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
	<title>新闻动态_</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="<%=basePath%>/common/front/css/BigRed/inner.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>/common/front/js/functions.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/images/iepng/iepngfix_tilebg.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/js/common.js"></script>

	<!-- jQuery imageSlide -->
	<link href="<%=basePath%>/common/front/imageSlide/css/list.css" rel="stylesheet" type="text/css">
	<script src="<%=basePath%>/common/front/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/imageSlide/js/list.js"></script>

	<!-- jQuery tabHost -->
	<script type="text/javascript" src="<%=basePath%>/common/front/tabHost/inc/jquery-latest.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/tabHost/inc/ui.core.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/tabHost/inc/ui.sortable.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/tabHost/inc/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=basePath%>/common/front/tabHost/inc/mbTabset.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/front/tabHost/css/mbTabset.css" title="style"  media="screen"/>
	<script type="text/javascript">
		$(function(){
			$("#tabset1").buildMbTabset({
				stop:function(){if ($("#array").is(":checked")) alert($.mbTabset.mbTabsetArray)},
				sortable:true
			});
			$("#tabset2").buildMbTabset({
				stop:function(){if ($("#array").is(":checked")) alert($.mbTabset.mbTabsetArray)},
				sortable:false,
				position:"left"
			});
			//$("#b").selectMbTab();
		});
    var ajaxUrl="<%=basePath%>/common/content_2.html";    
    var ajaxD="pippo=1&pluto=2";

	</script>
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
              <div class="topic">产品分类&nbsp;&nbsp;&nbsp;Product</div>
              <div class="blank">
            <ul>
                  <c:forEach var="bean" items="${typeList}">
                <li><A href='<%=basePath %>/product/typeShow?typeId=${bean.id}'>${bean.type}</A></li>
              </c:forEach>
                </ul>
          </div>
            </div>
        <div class="HeightTab clearfix"></div>
        <div class="Sbox">
              <div class="topic">热门产品&nbsp;&nbsp;&nbsp;Hot</div>
              <div class="list">
            <dl>
                  <c:forEach var="bean"  varStatus="status" items="${recentList}"  >
                <dd><a href='<%=basePath %>/product/detail?id=${bean.id}&typeId=${bean.typeBean.id}' target='_blank' title=''>${fn:substring(bean.name, 0, 15)}</a></dd>
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
        <div class="Position"><span>你的位置：<a href="/">首页</a> > <a href='<%=basePath %>/news/index?typeId=${newsType.id}'>${newsType.type}</a></span></div>
        <div class="HeightTab clearfix"></div>
        <!--main start-->
        <div class="main"> 
              
              <!--content start-->
              <div class="content">
            <div class="ProInfo">
                  
                  <div class="columnt">
                <div class="title"> 
                      <h3>产品简介</h3>
                    </div>
                <ul>
                     
                      <li><a onclick="showPopWin('/order/?id=915', 800, 500, null);" href='#'> <img src="<%=basePath%>/common/front/images/BigRed/order_img.gif" alt='在线订购'></a>&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="addFav()"> <img src="<%=basePath%>/common/front/images/BigRed/fav_img.gif" alt='加入收藏'></a></li>                  
                      <br />
                       <li>${bean.intro}</li>
                    </ul>
              </div>
              <div class="leftColumnt">
                <div class="scrolltab"> <span id="sLeftBtnA" class="sLeftBtnABan"></span> <span id="sRightBtnA" class="sRightBtnA"></span>
                      <ul class="ulBigPic">
<%--                     <li class="liSelected"> <span class="sPic"> <i class="iBigPic"><a href="http://www.jqdemo.com/" target="_blank" title="">
                    <img alt="大图1" width="560" height="220" src="<%=basePath%>/common/front/imageSlide/images/04.jpg" /></a></i> </span>
                    </li>
                    <li> <span class="sPic"> <i class="iBigPic"><a href="http://www.jqdemo.com/" target="_blank" title="">
                    <img alt="大图2" width="560" height="220" src="<%=basePath%>/common/front/imageSlide/images/05.jpg" /></a></i> </span>
                    </li> --%>
                    <c:forEach items="${bean.imagesSet}" var="bean" varStatus="status">
                    <c:if test="${status.index }==0">
                    <li class="liSelected"> <span class="sPic"> <i class="iBigPic"><a href="http://www.jqdemo.com/" target="_blank" title="">
                    <img alt="大图1" width="560" height="220" src="<%=basePath%>/common/front/imageSlide/images/${bean.image}" /></a></i> </span>
                    </li>
                    </c:if>
                    <li> <span class="sPic"> <i class="iBigPic"><a href="http://www.jqdemo.com/" target="_blank" title="">
                    <img alt="大图2" width="560" height="220" src="<%=basePath%>/common/front/imageSlide/images/${bean.image}" /></a></i> </span>
                    </li> 
                    
                    </c:forEach>
                  </ul>
                      <!--ulBigPic end-->
                      <div class="dSmallPicBox">
                    <div class="dSmallPic">
                          <ul class="ulSmallPic" style="width:2646px;left:0px" rel="stop">
                    <c:forEach items="${bean.imagesSet}" var="bean" varStatus="status">
                    <c:if test="${status.index }==0">
                        <li class="liSelected"> <span class="sPic"><img alt="小图1" src="<%=basePath%>/common/front/imageSlide/images/${bean.image}" width="100" height="70" /></span></li>
                    </c:if>
                        <li> <span class="sPic"><img alt="小图2" src="<%=basePath%>/common/front/imageSlide/images/${bean.image}" width="100" height="70" /></span></li>
                     </c:forEach>
                    
                      </ul>
                        </div>
                    <span id="sLeftBtnB" class="sLeftBtnBBan"></span> <span id="sRightBtnB" class="sRightBtnB"></span> </div>
                      <!--dSmallPicBox end--> 
                    </div>
              </div>
                  <div class="clearfix"></div>
                </div>
            <div class="maincontent clearfix">
                  <div class="IntroTitle">产品介绍</div>
                  <div class="ProInfo">
                <div class="image">
                      <iframe height=240 width=280 src="http://player.youku.com/embed/XNjk2MTE3Njky" frameborder=0 allowfullscreen></iframe>
                    </div>
                    <form action="" id="myform">
                <div class="column">
                      <div class="title">
                    <h3>在线留言</h3>
                  </div>
                      <div class="infos">
                    <p>姓名： 
                      
                          <input name='user_name' type='text' id='user_name' size='30' maxlength="30">
                        </p>
                    <p><span>电话：
                      <input name='tel' type='text' id='user_tel' size='30' maxlength="30">
                      </span>&nbsp;&nbsp;&nbsp;</p>
                    <p><span>邮箱：
                      <input name='email' type='text' id='user_email' size='30' maxlength="30">
                      </span>&nbsp;&nbsp;&nbsp;</p>
                    <p>留言内容：
                          <textarea name="content" id="user_content" cols="40" rows="4"  ></textarea>
                        </p>
                    <p><input type="button" value="提交" onclick="product_words(${bean.id});"/></p>
                    <p>&nbsp;</p>
                  </div>
                    </div>
                <div class="clearfix"></div>
              </div>
              </form>
                  <br />
                  <div class="wrapper">
                <div class="tabset" id="tabset1"><a id="a" class="tab {content:'cont_1'}">总览</a>
<!--                <a id="b" class="tab sel {content:'cont_2', ajaxContent:ajaxUrl,ajaxData:ajaxD}">特点 ajax</a>-->
                 <a id="b" class="tab {content:'cont_2'}">特点</a>
                <a id="c" class="tab {content:'cont_3'}">如何运作</a>
                <a id="d" class="tab {content:'cont_4'}" >配件</a>
                <a id="e" class="tab {content:'cont_5'}" >匹配</a>
                
                
                </div>
                <!--content of tabset "tabset1"-->
                
                <div id="cont_3">
                      <h3>33333</h3>
                      ${bean.detailBean.operate}
                    </div>
                       <div id="cont_2">
                      <h3>2222</h3>
                      ${bean.detailBean.feature}
                    </div>
                <div id="cont_4">
                      <h3>44444</h3>
                      <p>${bean.detailBean.parts}</p>
                    </div>
                <div id="cont_1">
                      <h3>1111</h3>
                       ${bean.detailBean.overview}
                      
                      <!--content of tabset "tabset2"--></div>
              </div>
                              <div id="cont_5">
                      <h3>55555</h3>
                       ${bean.detailBean.match}
                      
                      <!--content of tabset "tabset2"--></div>
              </div>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

  
  <!--head start-->
  <div id="head"> 
    
    <!--top start -->
    <div class="top">
      <!--<div class="TopInfo">
        <div class="link">选择语言：<a  href="javascript:zh_tran('s');" class="zh_click" id="zh_click_s">简体中文</a> | <a href="javascript:zh_tran('t');" class="zh_click" id="zh_click_t">繁體中文</a> | <a href="/English">English</a></div>
      </div>-->
      <div class="clearfix"></div>
      <div class="TopLogo">
      <br />
        <div class="logo"><img src="<%=basePath%>/common/front/images/up_images/logo.png" width="462px" height="62px" alt="演示"></div>
        <div class="tel">

          <p class="telW"> </p>
          <p class="telW"> 24小时客服热线</p>
          <p class="telN">4008 400 8270</p>
        </div>
      </div>
    </div>
    <!--top end--> 
    
    <!--nav start-->
    <div id="NavLink">
      <div class="NavBG"> 
        <!--Head Menu Start-->
			<ul id='sddm'>
				<li class='CurrentLi'><a href='<%=basePath%>/index'>网站首页</a>
				</li>
				<li><a href='<%=basePath%>/about/index'' onmouseover=mopen(
					'm2') onmouseout='mclosetime()'>关于公司</a>
					<div id='m2' onmouseover='mcancelclosetime()'
						onmouseout='mclosetime()'>
						<a href='<%=basePath%>/about/intro'>公司介绍</a> <a
							href='<%=basePath%>/about/group'>资质证明</a> <a
							href='<%=basePath%>/about/culture'>合作推广</a> <a
							href='<%=basePath%>/about/enviro'>公司环境</a> <a
							href='<%=basePath%>/about/business'>业务介绍</a>
					</div></li>
				<li><a href='<%=basePath%>/product/index' onmouseover=mopen(
					'm3') onmouseout='mclosetime()'>产品展示</a>
					<div id='m3' onmouseover='mcancelclosetime()'
						onmouseout='mclosetime()'>
						<a href='/Product/DigitalPlayer'>2D静态</a> <a
							href='/Product/NoteBook'>360°动画摄像</a> <a href='/Product/Mobile'>3D动画摄像</a>
					</div></li>
				<li><a href='<%=basePath%>/productDemo/index/'>产品范例</a>
				</li>
				<li><a href='<%=basePath%>/news/index' onmouseover=mopen(
					'm4') onmouseout='mclosetime()'>新闻资讯</a>
					<div id='m4' onmouseover='mcancelclosetime()'
						onmouseout='mclosetime()'>
						<a href='<%=basePath%>/news/index'>公司新闻</a> <a href='/news/IndustryNews'>行业新闻</a>
					</div></li>
				<li><a href='<%=basePath%>/support/index' onmouseover=mopen(
					'm5') onmouseout='mclosetime()'>技术支持</a>
					<div id='m5' onmouseover='mcancelclosetime()'
						onmouseout='mclosetime()'>
						<a href='/Support/Services'>售后服务</a> <a href='/Support/Download'>下载中心</a>
						<a href='/Support/FAQ'>常见问题</a>
					</div></li>

				<li><a href='<%=basePath%>/about/feedback/'>访客留言</a>
				</li>
				<li><a href='http://127.0.0.1:888/forum.php'>社区论坛</a>
				</li>
			</ul>
			<!--Head Menu End--> 
      </div>
      <div class="clearfix"></div>
    </div>
    <!--nav end--> 


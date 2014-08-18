
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!-- <jsp:include page="../../common/head_menu.jsp"></jsp:include> -->
    
    <div id="pic-holder">
    
    <div id="slider">
    	<div class="slider-pic" style="background:url(<%=basePath%>/common/front/images/slider-1.jpg) no-repeat scroll center center;"></div>
        <div class="slider-pic" style="background:url(<%=basePath%>/common/front/images/slider-2.jpg) no-repeat scroll center center;"></div>
        <div class="slider-pic" style="background:url(<%=basePath%>/common/front/images/slider-3.jpg) no-repeat scroll center center;"><div class="slider-caption"><p>This is some <a href="##">example</a> html caption.</p></div></div>
        <div class="slider-pic" style="background:url(<%=basePath%>/common/front/images/slider-4.jpg) no-repeat scroll center center;"></div>
    </div><!--slider-->
   </div><!--pic-holder-->
    <div id="slider-border"></div>
    
    <div id="container">
    	<div class="home3col">
        	<div class="home3col-ribbon"><img src="<%=basePath%>/common/front/images/creativity.png" alt="" /></div><!--home3col-rb-->
            <h1> 创意</h1>
            <p>此页面必须发表评论。让我们活着，有人说，任何人的恐惧承担投资，不是没有，它一直生活的各个阶段，发展壮大球员美国EGET直径。 <a href="##">quam</a> </p>
            <div class="home3col-details">
            	<a href="##">详情</a>
                <div class="home3col-details-border"></div>
            </div><!--home3col-details-->
        </div><!--home3col-->  
        <div class="home3col">
        	<div class="home3col-ribbon"><img style="margin-left:-4px;" src="<%=basePath%>/common/front/images/speciality.png" alt="" /></div><!--home3col-rb-->
            <h1>特价</h1>
            <p>Vivamus <a href="##">tempor</a> 间的基础平台。的美国的仅有的价格，美国的柔软和湖泊的钳口然而，发展。预期开始不仅广泛商用车任何人。</p>
            <div class="home3col-details">
            	<a href="##">详情信息</a>
                <div class="home3col-details-border"></div>
            </div><!--home3col-details-->
        </div><!--home3col-->  
        <div class="home3col" id="home3colLast">
        	<div class="home3col-ribbon"><img src="<%=basePath%>/common/front/images/consistency.png" alt="" /></div><!--home3col-rb-->
            <h1>一致性</h1>
            <p>交流neque augue，我malesuada augue。前庭ultricies等risus没有ligula scelerisque。Etiam想非普鲁斯metus auctor NULLA facilisis马蒂斯。</p>
            <div class="home3col-details">
            	<a href="##">详情</a>
                <div class="home3col-details-border"></div>
            </div><!--home3col-details-->
        </div><!--home3col-->  
        <div class="clear"></div>
        
        <div id="lwt">
        	<h2>让我们共同努力!</h2>
            <p>城市为导向，以提高车辆从美国，从平台本身，奥林匹克高中，这不是切割的纯净和认证的前面。</p>
            <div id="lwt-border"></div>
            <div id="get-a-quote"><a href="contact.html"><span class="hidden">马上联系我们</span></a></div>
        </div><!--lwt-->
        
        <div id="sp">
        	<h2>客户案例</h2>
            <div class="h-border" id="sph"></div>
        </div><!--sp-->
        <div class="clear"></div>
        <div id="sp-carousel">
          <div id="sp-carouselPrev"></div>
          <div id='carousel_inner'>
        	<ul id='carousel_ul'>
		    	<li><a href="##"><img src="<%=basePath%>/common/front/images/sp1.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp2.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp3.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp4.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp5.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp6.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp7.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp8.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp9.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp10.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp11.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp1.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp2.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp3.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp4.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp5.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp6.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp7.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp8.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp9.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp10.png" alt="" /></a></li>
                <li><a href="##"><img src="<%=basePath%>/common/front/images/sp11.png" alt="" /></a></li>
            </ul>
            </div><!--carousel_inner-->
            <div id="sp-carouselNext"></div>
        </div><!--sp-carousel-->
        <div class="clear"></div>
        
        <div id="rw">
        	<h2>最新信息</h2><div class="h-border" id="hrw"></div>
            <div class="clear"></div>
            <ul id="rw-pro">
	        	<li><a class="rw-pp" title="&nbsp;" href="<%=basePath%>/common/front/images/rw-1-big.jpg" rel="prettyPhoto[rw]"><ins><img src="<%=basePath%>/common/front/images/rw-1.jpg" alt="Project Title" /><div class="rw-pro-rb"><a class="project-single" title="&nbsp;" href="project-single.html"><ins><h6>标题</h6></ins></a></div></ins></a></li>
                
                <li><a class="rw-pp" title="&nbsp;" href="<%=basePath%>/common/front/images/rw-2-big.jpg" rel="prettyPhoto[rw]"><ins><img src="<%=basePath%>/common/front/images/rw-2.jpg" alt="Project Title" /><div class="rw-pro-rb"><a class="project-single" title="&nbsp;" href="project-single.html"><ins><h6>标题</h6></ins></a></div></ins></a></li>
                
                <li><a class="rw-pp" title="&nbsp;" href="<%=basePath%>/common/front/images/rw-3-big.jpg" rel="prettyPhoto[rw]"><ins><img src="<%=basePath%>/common/front/images/rw-3.jpg" alt="Project Title" /><div class="rw-pro-rb"><a class="project-single" title="&nbsp;" href="project-single.html"><ins><h6>标题</h6></ins></a></div></ins></a></li>
     			
	        </ul>
        </div><!--rw-->
        
          <div id="testimonial">
        	<div id="testimonial-rb"></div>
        	<div class="h-border"><h2>客户感言</h2></div><!--hborder-->
	            <div id="testimonial-slider">
	            	<div><p>吸烟是很酷的，它只是在孩子或牛肉或平台。科学家监测的热应力，并帮助我在课堂上得到的
	            	<span class="testimonial-owner">客户姓名, 职位, <a href="##">公司</a></span></p></div>
                
                	<div><p>这是什么啊
	            	<span class="testimonial-owner">客户姓名, 职位 2, Position, <a href="##">公司</a></span></p></div>
                
                	<div><p>减肥的时间发多少路附近
	            	<span class="testimonial-owner">客户姓名, 职位 3, Position, <a href="##">公司</a></span></p></div>
                </div><!--testimonial-slider-->
         </div><!--testimonial-->
        
        
         <div class="clear"></div>
    </div><!--container-->
 
    
<jsp:include page="common/bottom.jsp"></jsp:include> 

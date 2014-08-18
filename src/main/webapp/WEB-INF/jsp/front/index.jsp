<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>/common/front/">
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站演示 - 首页</title>
<meta name="keywords" content="网站演示" />
<meta name="description" content="网站演示" />
<link href="<%=basePath%>/common/front/css/BigRed/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/common/front/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/js/Functions.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/js/FocusSlide.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/images/iepng/iepngfix_tilebg.js"></script>

<style>
.dSmallPicBox{width:988px;height:95px;position:relative;}
.dSmallPic{width:952px;height:80px;position:absolute;left:15px;top:15px;overflow:hidden;}
.dSmallPic ul{position:absolute;}
.dSmallPic li{width:90px;height:139px;border:1px solid #fff;padding:3px 2px 0;float:left;display:inline;cursor:pointer;overflow:hidden;}
.dSmallPic .sPic{width:80px;height:50px;display:block;}
.dSmallPic .sPic img{border:1px solid #ddd;padding:2px;}
.dSmallPic .sTitle{width:80px;height:30px;line-height:30px;display:block;text-align:center;color:#333;overflow:hidden;}
.dSmallPic .liSelected{border-color:#e9c184;}
.dSmallPic .liSelected .sPic img{border-color:#fff;}
</style>
</head>

<body>
<div id="wrapper"> 
<jsp:include page="../common/top_menu.jsp"></jsp:include>
    <!--focus start-->
    <div id="FocusBG">
      <div id="Focus">
        <ul>
          <li><img src='<%=basePath%>/common/upload/advertise/adv2.jpg' width="980px" height="300px" /></li>
          <li><img src='<%=basePath%>/common/upload/advertise/adv3.jpg' width="980px" height="300px" /></li>
          <li><img src='<%=basePath%>/common/upload/advertise/adv1.jpg'  width="980px" height="300px" /></li>
 
        </ul>
      </div>
    </div>
    <!--foncus end-->
    <div class="HeightTab clearfix"></div>
  </div>
  <!--head end--> 
  <!--body start-->
  <div id="body"> 
    <!--MainBlock start-->
    <div class="MainBlock"> 
      <!--left start-->
      <div class="right">
        <div class="topic">
          <div class="TopicTitle"><a href="/About">关于公司</a></div>
          <div class="TopicMore"> <a  href='/About'><img src="<%=basePath%>/common/front/images/more.png"></a></div>
        </div>
        <div class='img'><a href='/About' target='_blank'><img src='<%=basePath%>/common/front/images/up_images/about.jpg' width='200' height='100' alt='关于公司'></a></div>
        <div class='txt ColorLink'>
          <p>${fn:substring(aboutBean.content, 0, 43)}
<a href='<%=basePath %>/about/intro' target='_blank'>详细>></a></p>
        </div>
        <div class=" clearfix"></div>
      </div>
      <!--left end-->
      <div class='WidthTab2'></div>
      
      <!--right start-->
      <div class="left">
        <div class="TabBlock">
          <div class="menu">
            <ul>
              <li class='Tabs1'><A onmousemove='easytabs(1, 1);' onfocus='easytabs(1, 1);'  title='新闻动态'  id='tablink1' href='/News'>新闻动态</A></li>
              <li class='Tabs2'><A onmousemove='easytabs(1, 2);' onfocus='easytabs(1, 2);'  title='技术支持'  id='tablink2' href='/Support'>技术支持</A></li>
              <li class='Tabs3'><A onmousemove='easytabs(1, 3);' onfocus='easytabs(1, 3);'  title='公告信息'  id='tablink3' href='/Information'>公告信息</A></li>
            </ul>
          </div>
          <DIV id='tabcontent1'>
            
          </div>
          <DIV id='tabcontent2'></div>
          <DIV id='tabcontent3'></div>
        </div>
      </div>
      <!--right end--> 
      
      <!--right2 start-->
      <div class="right2">
        <div class="topic">
          <div class="TopicTitle">视频展示</div>
          <div class="TopicMore"></div>
        </div>
        <div class='img'><script type="text/javascript">

var swf_width=235
var swf_height=180
var texts='video'
var files='/vcastr2/test.flv'
var config='0:自动播放|1:连续播放|100:默认音量|0:控制栏位置|2:控制栏显示|0x000033:主体颜色|60:主体透明度|0x66ff00:光晕颜色|0xffffff:图标颜色|0xffffff:文字颜色|:logo文字|:logo地址|:结束swf地址'

document.write('<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"'+ swf_width +'\" height=\"'+ swf_height +'\">');
document.write('<param name=\"movie\" value=\"/vcastr2/vcastr2.swf\"><param name=\"quality\" value=\"high\">');
document.write('<param name=\"menu\" value=\"false\"><param name=wmode value=\"opaque\">');
document.write('<param name=\"FlashVars\" value=\"vcastr_file='+files+'&vcastr_title='+texts+'&vcastr_config='+config+'\">');
document.write('<embed src=\"/vcastr2/vcastr2.swf\" wmode=\"opaque\" FlashVars=\"vcastr_file='+files+'&vcastr_title='+texts+'&vcastr_config='+config+'\" menu=\"false\" quality=\"high\" width=\"'+ swf_width +'\" height=\"'+ swf_height +'\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />'); document.write('<\/object>'); 

</script> 
        </div>
        <div class=" clearfix"></div>
      </div>
      <!--right2 end-->
      <div class="clearfix"></div>
    </div>
    <!--MainBlock end-->
    
    <div class="HeightTab clearfix"></div>
    <!--ProductShow start-->
    <DIV class="ProductShow">
      <div class="topic">
        <div class="TopicTitle"> 3D展示案例</div>
        <div class="TopicMore"> <a  href='/Product'><img src="<%=basePath%>/common/front/images/more.png"></a></div>
      </div>
      <DIV class="hjnavC">
        <DIV class="hjnavleft">
          <UL>
          
          <c:forEach items="${demoTypeList}" var="demoType" varStatus="status">
            <li 
            <c:if test="status==0">class='hover1'</c:if>
            >
            
            <A >${demoType.type }</A></li>
        
              </c:forEach>
          </UL>
        </DIV>
        <DIV class="hjnavcn">
        <c:forEach items="${demoTypeList}" var="demoType" >
        <DIV class='hjone'>       
       <c:forEach items="${demoList}" var="demo" >
        <c:if test="${demoType.id == demo.typeBean.id }">
            <div class='albumblock'>
              <div class='inner'>
              <a href='<%=basePath %>/productDemo/detail?id=${demo.id}&typeId=${demo.typeBean.id}&useId=${demo.typeBean.useBean.id}' target='_blank' title='${demo.name }'>
              <img src='<%=basePath%>/${demo.pic}' width='166' height='166'/>
                <div class='albumtitle'>${demo.name }</div>
                </a>
                </div>
            </div>
           </c:if>
          
       </c:forEach>
          </div>
      </c:forEach>

      </div>
      <div class="clearfix"></div>
    </DIV>
 
    <!--ProductShow end-->
    <div class="HeightTab clearfix"></div>
 
    
  </div>
  <DIV class="ProductShow">
      <div class="topic">
        <div class="TopicTitle"> 客户案例</div>
        <div class="TopicMore"> <a  href='/Product'><img src="<%=basePath%>/common/front/images/more.png"></a></div>
       
      </div>

      <div class="dSmallPicBox">
		<div class="dSmallPic">
			<ul class="ulSmallPic" style="width:2646px;left:0px" rel="stop">
				<li >
					<span class="sPic"><img  src="images/s01.jpg" width="80" height="50" /></span>
					<span class="sTitle">公司名1</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s02.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s03.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s04.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s05.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s06.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s07.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s08.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
								<li>
					<span class="sPic"><img  src="images/s07.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s08.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
								<li>
					<span class="sPic"><img  src="images/s07.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
				<li>
					<span class="sPic"><img  src="images/s08.jpg" width="80" height="50"  /></span>
					<span class="sTitle">公司名</span>
				</li>
			</ul>
		</div>
		<span id="sLeftBtnB" class="sLeftBtnBBan"></span>
		<span id="sRightBtnB" class="sRightBtnB"></span>
	</div>

    <SCRIPT type="text/javascript" src="<%=basePath%>/common/front/js/h.js"></SCRIPT> 
    <!--ProductShow end-->
    <div class="HeightTab clearfix"></div>
    <!--links start-->
			<div id="Links">
				<span>友情链接：</span>
				<c:forEach items="${linksList}" var="links">
				
				<a href='http://${links.url }' target='_blank' rel='nofollow'>${links.name }</a>
				</c:forEach>
					
			</div>
			<!--links end-->

		</div>
  <!--body end-->
<script type="text/javascript" src="<%=basePath%>/common/front/js/TabShow.js" ></script> 
  <jsp:include page="../common/bottom.jsp"></jsp:include>
  
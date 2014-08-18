<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!--body end接下来-->
<div class="HeightTab clearfix"></div>
  <!--footer start-->
  <div id="footer">
    <div class="inner">
      <div class='BottomNav'>
      <!-- <a href="/">网站首页</a> | <a href="/About">关于我们</a> | <a href="/Recruit">人才招聘</a> | <a href="/Sitemap">网站地图</a>  -->
      </div>
      <div class='HeightTab'></div>
      <p>Copyright 2014 <a href='http://' target='_blank'></a> 版权所有 All Rights Reserved </p>
      <p>公司地址: 联系电话： 电子邮件：</p>
      <p>Built By <a href="" target="_blank"></a> <a href="" target="_blank"></a> 技术支持 <a href="/rss" target="_blank"><img src="111<%=basePath%>/common/front/images/rss_icon.gif"></a> <a href="/rss/feed.xml" target="_blank"><img src="111<%=basePath%>/common/front/images/xml_icon.gif"></a></p>
    </div>
  </div>
  <!--footer end --> 
  
</div>
<script type="text/javascript">
window.onerror=function(){return true;}
</script>
</body>
</html>
<!--
Powered By HuiguerCMS ASP M2013C   
-->
  
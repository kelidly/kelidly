<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<jsp:include page="../../common/top.jsp"></jsp:include>
  <div id="main-content">
    <noscript>
    <div class="notification error png_bg">
      <div> 很遗憾！您的浏览器不支持JS脚本，无法正常浏览该网页。</div>
    </div>
    </noscript>
    <!-- Page Head -->
    <h2>欢迎进入 管理员后台</h2>
    <p id="page-intro">这是一个管理界面。</p>

    <div class="clear"></div>
    <div class="content-box">
      <div class="content-box-header">
        <h3>发布案例</h3>
        <ul class="content-box-tabs">
 <!--         <li><a href="<%=basePath %>/back/product/manage" >管理列表</a></li>
          <li><a href="#tab1" class="tab-content default-tab">发布文章</a></li>-->
        </ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        
  
         
        <div class="tab-content default-tab" id="tab1">
          <form action="<%=basePath%>/back/case/add" method="post" enctype="multipart/form-data">

            <fieldset>
            <p>
              <label>客户名称</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="name"  value=""/>
         </p>    
               <p>
              <label>客户网址</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="url"  value=""/>
              </p>
              
                             <p>
              <label>产品图片</label>
              
              <input type="file"  name="file" >
              <br />
              <img   src="<%=basePath %>/${bean.pic}"/>
   
              </p>
              <!--<span class="input-notification success png_bg">成功通过提示信息</span>
              <span class="input-notification error png_bg">错误提示信息</span>
              -->
              <br />
              <p>
                <input class="button" type="submit" value="添加" />
          </p>
            </fieldset>
            <div class="clear"></div>
          </form>
        </div>
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    <!-- End .content-box -->
    <div class="content-box column-left"><!-- End .content-box-header -->
 
      <!-- End .content-box-content -->
    </div>
    <!-- End .content-box -->
    
    <div class="clear"></div>

    <!-- End Notifications -->
    <div id="footer"> <small>
      &#169; Copyright 2014 Your Company | Powered by <a href="http://www.ewceo.com">ewCEO.com</a> | <a href="#">Top</a> </small> </div>
  </div>
</div>
</body>
</html>

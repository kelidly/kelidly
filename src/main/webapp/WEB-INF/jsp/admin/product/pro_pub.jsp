<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<jsp:include page="../../common/top.jsp"></jsp:include>
<%--  <script type="text/javascript" src="<%=basePath %>/common/js/imgReview/jquery-1.7.1.min.js"></script> --%>
 <script>
        $(function () {
            //图片预览调用
            $('#uploadReview1').uploadReview({
                width: 300,
                height: 300
            });

        });
    </script>


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
        <h3>发布产品</h3>
        <ul class="content-box-tabs">
 <!--         <li><a href="<%=basePath %>/back/product/manage" >管理列表</a></li>
          <li><a href="#tab1" class="tab-content default-tab">发布文章</a></li>-->
        </ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        
  
         
        <div class="tab-content default-tab" id="tab1">
          <form action="<%=basePath%>/back/product/add" method="post" enctype="multipart/form-data">
            <fieldset>
            <p>
              <label>产品名称</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="name" />
              <!--<span class="input-notification success png_bg">成功通过提示信息</span>
              <span class="input-notification error png_bg">错误提示信息</span>
              -->
              <br />

            </p>
            
             <p>
              <label>产品类型</label>
              <select name="typeId" class="small-input">
  <c:forEach var="typeBean" items="${typeList}">

               <option value="${typeBean.id }">${typeBean.type}</option>

              </c:forEach>

              </select>
            </p>
            
                         <p>
              <label>产品用途</label>

  <c:forEach var="useBean" items="${useList}">
              <input type="checkbox" name="useId" value="${useBean.id}"/>
             ${useBean.name }<br />

              </c:forEach>

              
            </p>
            <p>
              <label>产品型号</label>
              <input class="text-input medium-input datepicker" type="text"  name="model" />
              <!--<span class="input-notification success png_bg">成功通过提示信息</span>
              <span class="input-notification error png_bg">错误提示信息</span>
              -->
              <br />

            </p>
                        <p>
              <label>产品图片</label>
        <input id="uploadReview1" type="file" name="file" />
                  <div class="demo">
        
    </div>
              
             
             
              <br />

            </p>
            <p>
              <label>简介</label>
              <textarea class="text-input textarea wysiwyg" id="textarea" name="intro" cols="79" rows="12"></textarea>
            </p>
           
            <p>
              <input class="button"  type="submit" value="发布" />
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

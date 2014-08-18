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
        <h3>类别管理</h3>
        <ul class="content-box-tabs">
<!--          <li><a href="#tab1" class="default-tab">管理列表</a></li>
          <li><a href="<%=basePath %>/back/productDemo/pub">发布文章</a></li>-->
        </ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <div class="notification attention png_bg"> <a href="#" class="close"><img src="<%=basePath %>/common/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
            <div id="editNoteHint"> 这是需注意信息提示。</div>
          </div>
          <table>
            <thead >
              <tr>
                <th>
                 
                </th>
                <th>id</th>
                <th>类型</th>
                
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                <form method="post" name="add_form" action="<%=basePath%>/back/productDemo/addType">
                  <div class="bulk-actions align-left">
                    <input class="text-input medium-input datepicker" type="text" id="type" name="type" />
                     <input class="button" type="submit" value="添加类别" />  
                    <!--  <a class="button" onclick="addType();" >添加类别</a> -->
                    </div>
                    </form>


    <!--               <div class="pagination"> 
                  <a href="#" title="First Page">&laquo; 首页</a>
                  <a href="#" title="Previous Page">&laquo; 上一页</a> 
                  <a href="#" class="number" title="1">1</a> 
                  <a href="#" class="number" title="2">2</a> 
                  <a href="#" class="number current" title="3">3</a> 
                  <a href="#" class="number" title="4">4</a> 
                  <a href="#" title="Next Page">下一页 &raquo;</a>
                  <a href="#" title="Last Page">末页 &raquo;</a> 
                  </div> -->
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody id="thead_table">
            
              <c:forEach var="bean" items="${beanList}"  >
               <tr>
                <td>
                  
                </td>
                <td>${bean.id} </td>
                <td><input class="text-input medium-input datepicker" type="text" id="edit${bean.id}" name="type" value="${bean.type}"/></td>
                <td>
                  <!-- Icons -->
                                   <%--  <a href="<%=basePath%>/back/news/updateType?id=${bean.id}&type=${bean.type}" id="editButton" onclick="" title="修改"> --%>
                  <!-- href="#"一定要加# 表示当前，<a标签先执行onclick（）方法后，再次跳转到执行href链接上-->
                  <a href="#" id="editButton" onclick="editType('<%=basePath%>/back/productDemo/updateType',${bean.id});" title="修改">
                  <img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit" />
                  </a> 
                  <a href="<%=basePath%>/back/productDemo/delType?typeId=${bean.id}" title="删除">
                  <img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" />
                  </a>
 
                  </td>
              </tr>
              </c:forEach>
 
    
            </tbody>
          </table>
        </div>
        
        
        
        <!-- End #tab1 -->
   
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

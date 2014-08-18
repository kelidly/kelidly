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
        <h3>管理友情链接</h3>
        <ul class="content-box-tabs">
<!--          <li><a href="#tab1" class="default-tab">管理列表</a></li>
          <li><a href="<%=basePath %>/back/news/pub">发布文章</a></li>--></ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <div class="notification attention png_bg"> <a href="#" class="close"><img src="<%=basePath %>/common/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
            <div> 这是需注意信息提示。</div>
          </div>
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>序列</th>    
                <th>公司名</th>
                <th>网址</th>
                
                
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="bulk-actions align-left">
                    <select name="dropdown">       
                      <option value="option3">批量删除</option>
                    </select>
                      <script type="text/javascript">
	function submitform(obj){
		var checked = document.getElementsByName(obj); 
		var url = "<%=basePath%>/back/links/delMany";
	   var form = document.getElementById("checkbox_Form");
	   form.action=url;
	   form.method="post";
	   form.submit();
	}
</script>
                    <a class="button" onclick="submitform('checkId');" >确定操作</a> </div>

                    <!-- 分页导航 -->
    <!-- 注意这个表单必须做，action：必须指向控制器,id必须叫做pageForm_search -->
<form action="<%=basePath%>/back/links/pageQuery" id="pageForm_search" method="get">
	<!--<input name="currentPage" type="hidden" value="${currentPage}"/>-->
		<!-- 表单中必须存放当前的所有查询条件 -->

        
	</form>
    <div class="pagination"> 
			<jsp:include page="../../common/pagebar.jsp"></jsp:include>
             </div>
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
            <tbody>
            <form action=""  method="post" name="checkbox_Form" id="checkbox_Form" >
              <c:forEach var="bean"  varStatus="status" items="${pagemodel.result}"  >
               <tr>
                <td>
                    <input type="checkbox" name="checkId" id="checkId" value="${bean.id}"/>
	                     
                </td>
                <td>${status.index +1 } </td>
                <td>${bean.name }</td>
                <td>${bean.url }</td>

                <td>
                  <!-- Icons -->
                  <a href="<%=basePath%>/back/links/updateView?linksId=${bean.id}" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="<%=basePath%>/back/links/del?linksId=${bean.id}" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              </c:forEach>
             </form>     
        
    
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

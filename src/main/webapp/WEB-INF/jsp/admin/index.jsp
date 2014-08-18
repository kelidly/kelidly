<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<jsp:include page="../common/top.jsp"></jsp:include>
  <div id="main-content">
    <noscript>
    <div class="notification error png_bg">
      <div> 很遗憾！您的浏览器不支持JS脚本，无法正常浏览该网页。</div>
    </div>
    </noscript>
    <!-- Page Head -->
    <h2>欢迎进入 管理员后台</h2>
    <p id="page-intro">这是一个管理模板界面。</p>
    <ul class="shortcut-buttons-set">
      <li><a class="shortcut-button" href="#"><span> <img src="<%=basePath %>/common/admin/images/icons/pencil_48.png" alt="icon" /><br />
        发布文章 </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="<%=basePath %>/common/admin/images/icons/image_add_48.png" alt="icon" /><br />
        上传图片 </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="<%=basePath %>/common/admin/images/icons/clock_48.png" alt="icon" /><br />
        查看日志 </span></a></li>
      <li><a class="shortcut-button" href="#messages" rel="modal"><span> <img src="<%=basePath %>/common/admin/images/icons/comment_48.png" alt="icon" /><br />
        查看消息 </span></a></li>
    </ul>
    <div class="clear"></div>
    <div class="content-box">
      <div class="content-box-header">
        <h3>内容盒子</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">列表</a></li>
          <li><a href="#tab2">表单</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <div class="notification attention png_bg"> <a href="#" class="close"><img src="<%=basePath %>/common/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
            <div> 这是需注意信息提示容器。</div>
          </div>
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>栏目 1</th>
                <th>栏目 2</th>
                <th>栏目 3</th>
                <th>栏目 4</th>
                <th>栏目 5</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="bulk-actions align-left">
                    <select name="dropdown">
                      <option value="option1">请选择操作...</option>
                      <option value="option2">编辑</option>
                      <option value="option3">批量删除</option>
                    </select>
                    <a class="button" href="#">确定操作</a> </div>
                  <div class="pagination"> <a href="#" title="First Page">&laquo; 首页</a><a href="#" title="Previous Page">&laquo; 上一页</a> <a href="#" class="number" title="1">1</a> <a href="#" class="number" title="2">2</a> <a href="#" class="number current" title="3">3</a> <a href="#" class="number" title="4">4</a> <a href="#" title="Next Page">下一页 &raquo;</a><a href="#" title="Last Page">末页 &raquo;</a> </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>第一栏示范内容</td>
                <td><a href="#" title="title">示范分类</a></td>
                <td>第三栏示范内容</td>
                <td>第四栏示范内容</td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="编辑"><img src="<%=basePath %>/common/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="删除"><img src="<%=basePath %>/common/admin/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="设置"><img src="<%=basePath %>/common/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 --><!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    <!-- End .content-box --><!-- End .content-box -->
    <div class="clear"></div>
    <!-- End Notifications -->
    <div id="footer"> <small>
    &#169; Copyright 2014 Your Company | Powered by <a href="http://www.ewceo.com">ewCEO.com</a> | <a href="#">Top</a> </small> </div>
  </div>
</div>
</body>
</html>

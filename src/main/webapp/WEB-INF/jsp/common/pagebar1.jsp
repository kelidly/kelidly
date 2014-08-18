<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!-- 分页导航 -->

<div class='t_page ColorLink'>
				<form action="" name="pageForm" id="pageForm" onclick="buildform();">
					<!-- 需要添加新的隐藏域（其他查询条件） -->
					<input name="currentPage" type="hidden" value="${pagemodel.currentPage}"/>
					<input name="pageSize" type="hidden" value="${pagemodel.pageSize}"/>
				  <!-- 访问服务端的动作标记 -->
总数：${pagemodel.allCount}条&nbsp;&nbsp;当前页数：<span class='FontRed'>${pagemodel.currentPage}</span>/${pagemodel.allPage}

				<c:if test="${pagemodel.currentPage<=1 }">
				首页&nbsp;&nbsp;上页 
				</c:if>
				<c:if test="${pagemodel.currentPage>1 }">
				<a href="javascript:firstpage();">首页&nbsp;&nbsp;</a> <a href="javascript:prepage();">上页</a>
				</c:if>
				<c:if test="${pagemodel.currentPage>=pagemodel.allPage }">
				 下页&nbsp;&nbsp;尾页
				</c:if>
				<c:if test="${pagemodel.currentPage<pagemodel.allPage }">
				 <a href="javascript:nextpage();">下页</a>&nbsp;&nbsp;<a href="javascript:lastpage();">尾页</a>
				</c:if>
				<%-- &nbsp;&nbsp;每页显示${pagemodel.pageSize }条记录 --%>
				
				
				</form>
			</div>
			<script>
					function buildform(){
						pageForm.action=pageForm_search.action;
						pageForm.method=pageForm_search.method;
						var alle=document.getElementById("pageForm_search").childNodes;
						if(alle){
							for(var i=0;i<alle.length;i++){
								
								if(alle[i].type=="hidden"){
									var input = document.createElement("input");
									input.type="hidden";
									input.name=alle[i].name;
									input.value=alle[i].value;
									pageForm.appendChild(input);
								}
							}
							
						}
					}
					function firstpage(){buildform();pageForm.currentPage.value='1';pageForm.submit();}
					function prepage(){buildform();pageForm.currentPage.value=${pagemodel.currentPage-1};pageForm.submit();}
					function nextpage(){buildform();pageForm.currentPage.value=${pagemodel.currentPage+1};pageForm.submit();}
					function lastpage(){buildform();pageForm.currentPage.value=${pagemodel.allPage};pageForm.submit();}
				</script>
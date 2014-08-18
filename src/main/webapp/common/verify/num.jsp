<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
String num=request.getParameter("num");
String random=(String)session.getAttribute("random");

if(num!=null&&random!=null)
{
 if(!num.equals(random))
 {
 /*
  out.println("<script>alert('验证码错误！请重试。')</script>");
  out.println("<script>history.go(-1)</script>");
  //response.sendRedirect("img.jsp");
  */
  out.print("validate_failed:"+random);
 }
 else
  {
   //out.println("<center>验证成功！</center>");
  out.print("validate_successful:"+random);
  }
}
%>
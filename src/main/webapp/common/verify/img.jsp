<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%
//set Chinese Char
 //Cody byJarryLi@gmail.com;
//homepage:jiarry.126.com
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>

<%
String num=request.getParameter("num");
String random=(String)session.getAttribute("random");
String name=request.getParameter("name");
if(num!=null&&random!=null&&name!=null)
{
 if(num.equals(random))
 {  
  out.println("<font style=\"color:green;font-weight:bold\">恭喜您，验证码输入成功，这里是提交结果页面，可以写入数据库了！</font> <a href=\"img.jsp\">返回再测试</a><br>");
  out.println("您的名字是："+name);
  out.println("<br>");
  out.println("您输入的是："+num);
  out.println("验证码是："+random);
  out.println("</body>");
   return;//javascript:history.go(-1)
  }
}
%>
<script type="text/javascript">
var times=0;
function subform(){
 var gtext=this.req.responseText;
  var info=document.getElementById("info");
  if(gtext.indexOf("validate_successful")!=-1){
   //info.innerHTML="<font color=green>验证码通过</font>";
   document.forms["myform"].submit();
   //当得到的值表示合法，则验证码通过。
  }else{
      times++;
    if(times>=3){//如果连接3次输入错误，则重载图片，可以防止作弊和用户看不清图片;
     info.innerHTML="接连3次输入错误。更新验证码，请重新输入";
       document.forms["myform"].num.value="";
       show(document.getElementById('random'));
       times=0;
     }else{
     info.innerHTML="第"+times+"次验证码错误,请注意区分大小写 ";
   }
  document.forms["myform"].num.select();
  }
}
function validata(obj){
 var enter=true;
 var info=document.getElementById("info");
 var msg="";
 if(obj.name.value.match(/^\s*$/g)){//如果未输入名字，提示
  msg+="请输入您的姓名<br>";enter=false
 }
 if(obj.num.value.match(/^\s*$/g)){//如果未输入验证码，提示
  msg+="请输入验证码<br>";enter=false  
 }
 if(enter==false){
    info.innerHTML=msg;
    return false;
 }
 var url="<%=basePath%>common/verify/num.jsp?num="+obj.num.value;
 var newxmlhttp=new net.ContentLoader(url,subform,"","get",null,null);
  return false;
}
function show(o){
 //重载验证码
 var timenow = new Date().getTime();
 o.src="random.jsp?d="+timenow;
 /*
 //超时执行;
 setTimeout(function(){
  o.src="random.jsp?d="+timenow;
 }
  ,20);
  */
}
</script>
 <form action="img.jsp" name="myform" method="post" onsubmit="return validata(this);">
您的姓名：<input type="text" name="name" size=10> (为了更好地说明此例，特加姓名一项)<br>
验 证 码：<input type="text" name="num" size=10 maxlength="4"> <img src="random.jsp" id="random" align="" valign="absmiddle" hspace="5"> <a href="javascript:show(document.getElementById('random'))">验证码看不清</a><br>
<br> <input type="submit" value=" 提交 "><br>
 <div id=info style="color:red;padding:10px;font-size:12px;"></div>
</form>
</body>
</html>

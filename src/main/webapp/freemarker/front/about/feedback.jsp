<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司致力于某某行业的发展_外贸演示</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>/common/front/css/BigRed/inner.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/common/js/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/common/front/js/functions.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/images/iepng/iepngfix_tilebg.js"></script>
<!-- jquery表单验证 -->
<script type="text/javascript" src="<%=basePath%>/common/verify/net.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/verify/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/verify/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/verify/js/jquery.bgiframe.min.js"></script>
<link  href="<%=basePath%>/common/verify/css/validate.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wrapper"> 
<jsp:include page="../../common/top_menu.jsp"></jsp:include>
</div>
<!--head end-->
<!--body start-->

<div id="body">
<!--focus start-->
<div id="InnerBanner">

</div>
<!--focus start-->
<div id="InnerBanner">

</div>
<!--foncus end-->
<div class="HeightTab clearfix"></div>
<!--inner start -->
<div class="inner">
<!--left start-->
<div class="left">
<div class="Sbox">
<div class="topic">关于公司&nbsp;&nbsp;&nbsp;About</div>
<div class="blank"><ul>
<li><A href='<%=basePath%>/about/intro'>公司介绍</A></li> 
<li><A href='<%=basePath%>/about/proof'>资质证明</A></li> 
<li><A href='<%=basePath%>/about/contact'>联系我们</A></li> 
<li><A href='<%=basePath%>/about/cooperative'>合作推广</A></li> 
<li   class='current'><A href='<%=basePath%>/about/feedback'>访客留言</A></li> 
</ul></div>
</div>
<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">最新资讯&nbsp;&nbsp;&nbsp;New</div>
<div class="list">
<dl>
  <c:forEach var="bean"  varStatus="status" items="${recentList}"  >

<dd><a href='<%=basePath %>/news/detail?id=${bean.id}&typeId=${bean.typeId}' target='_blank' title=''>${fn:substring(bean.title, 0, 15)}</a></dd>
</c:forEach>

</dl>
</div>

</div>
<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">联系我们&nbsp;&nbsp;&nbsp;Contact</div>
<div class="txt ColorLink">
<p>地址：</p>
<p>电话：</p>
<p>传真：</p>
<p>邮件：</p>
<p>网站：<a href='' target='_blank'></a> </p>
<p align='center'><a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>/common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> &nbsp;&nbsp;<a href="http://wpa.qq.com/msgrd?v=3&uin=730046&site=qq&menu=yes"><img src="<%=basePath%>/common/front/images/qqimg/webqq.gif" alt='在线QQ交谈'/></a> </p></div>
</div>

<div class="HeightTab clearfix"></div>
<div class="Sbox">
<div class="topic">搜索&nbsp;&nbsp;&nbsp;Search</div>
<div class="SearchBar">
<form method="get" action="/Search/index.asp">
				<input type="text" name="q" id="search-text" size="15" onBlur="if(this.value=='') this.value='请输入关键词';" 
onfocus="if(this.value=='请输入关键词') this.value='';" value="请输入关键词" /><input type="submit" id="search-submit" value="搜索" />
			</form>
</div>
</div>
</div>
<!--left end-->
<!--right start-->
<div class="right">
<div class="Position"><span>你的位置：<a href="/">首页</a> > <a href='/About/'>关于公司</a> > <a href='#/'>访客留言</a></span></div>
<div class="HeightTab clearfix"></div>
<!--main start-->
<div class="main">
<div class="FeedBack">

<p align='center'> </p>
<div class="clearfix"></div>


<div class="IntroTitle clearfix">发表留言</div>
<div class="commentbox">
<form action="<%=basePath%>/about/feedback" name="myform" id="myform" method="post" onsubmit="return validata(this);" >
<!-- <form id="form1" name="form1" method="post" action="/inc/comment.asp?act=add&id="> -->
  <table id="commentform" width="600" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td>姓名</td>
      <td><input  name='name' type='text' id='name' size='30' maxlength="30"  reg="^.+$" tip="请输入">
      <span class="FontRed">*</span></td>
    </tr>
    <tr>
      <td>公司名称</td>
      <td><input name='company' type='text' id='company' size='30' maxlength="80"  ></td>
    </tr>
    <tr>
      <td>电子邮件</td>
      <td><input name='email' type='text' id='email' size='30' maxlength="80" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="请输入正确的邮箱格式">
      <span class="FontRed">*</span></td>
    </tr>
    <tr>
      <td>联系电话</td>
      <td><input name='telephone' type='text' id='tel' size='30' maxlength="30" reg="^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$" tip="请输入11位手机号">
      <span class="FontRed">*</span></td>
    </tr>	
    <tr>
      <td>留言内容</td>
      <td>
        <textarea name="content" id="content" cols="60" rows="7"  value="" reg="^.+$" tip="不能为空"></textarea>
            <span class="FontRed">*</span></td>    </tr>
    <tr>
    
      <td>验证码</td>
      <td><input name="num" id="num" maxLength=5 size=10 reg="^.+$" tip="请输入" > 
      <span class="FontRed">*</span>
      <img width="60" height="30" src="<%=basePath %>/common/verify/random.jsp" id="random" align="" valign="absmiddle" hspace="5"> 
      <a href="javascript:show(document.getElementById('random'))">验证码看不清</a><br>
      <div id=info style="color:red;padding:10px;font-size:12px;"></div>
      <!-- <img src="/inc/getcode.asp" width="55"  onclick="this.src=this.src+'?'" alt="图片看不清？点击重新得到验证码" style="cursor:hand;"> -->
      </td>
    </tr>	
    <tr>
      <td>&nbsp;</td>
      <td>
      <input  class="Cbutton" id="send" type="submit"  value="提交" >
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input class="Cbutton" type="reset" value="重置" id="res"/>
      </td>
    </tr>
  </table>
</form>
</div>
<script type="text/javascript">
var times=0;
function subform(){
 var gtext=this.req.responseText;
  var info=document.getElementById("info");
  if(gtext.indexOf("validate_successful")!=-1){
   info.innerHTML="<font color=green>验证码通过</font>";
   submit_company_words();
   /* document.forms["myform"].submit(); */
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

 if(obj.num.value.match(/^\s*$/g)){//如果未输入验证码，提示
  msg+="请输入验证码<br>";enter=false  
 }
 if(enter==false){
    info.innerHTML=msg;
    return false;
 }
 
 var url="<%=basePath%>/common/verify/num.jsp?num="+obj.num.value;
 var newxmlhttp=new net.ContentLoader(url,subform,"","get",null,null);
  return false;
}
function show(o){
 //重载验证码
 var timenow = new Date().getTime();
 o.src="<%=basePath%>/common/verify/random.jsp?d="+timenow;
 /*
 //超时执行;
 setTimeout(function(){
  o.src="random.jsp?d="+timenow;
 }
  ,20);
  */
}
</script>
</div>

</div>
<!--main end-->
</div>
<!--right end-->
</div>
<!--inner end-->
</div>
<!--body end-->

  <jsp:include page="../../common/bottom.jsp"></jsp:include>

  
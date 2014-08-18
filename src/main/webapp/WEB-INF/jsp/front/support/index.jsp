<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术支持_</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>/common/front/css/BigRed/inner.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/common/front/css/BigRed/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/common/front/js/functions.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/front/images/iepng/iepngfix_tilebg.js"></script>
</head>

<body>
<div id="wrapper">

<!--head start-->
<jsp:include page="../../common/top_menu.jsp"></jsp:include>

</div>
<!--head end-->
<!--body start-->
<div id="body">
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
<div class="topic">技术支持&nbsp;&nbsp;&nbsp;Support</div>
<div class="blank"><ul><li><A href='<%=basePath%>/support/service'>售后服务</A></li> <li><A href='<%=basePath%>/support/download'>下载中心</A></li> <li><A href='<%=basePath%>/support/FAQ'>常见问题</A></li> </ul></div>
</div>
<div class="HeightTab clearfix"></div>

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
<div class="Position"><span>你的位置：<a href="/">首页</a> > <a href='/Support/'>技术支持</a></span></div>
<div class="HeightTab clearfix"></div>
<!--main start-->
<div class="main">

<div class="ArticleList">
一、 本公司提供的售后服务方式
	  <!--<table  width="100%" border="0" cellspacing="0" cellpadding="0">
<ul><tr><td width='90%' class='fw_t'>·<a href='/html/5237645155.html' target='_blank'>中国电信下月联合经销商采购千万部智能手机</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/2579134949.html' target='_blank'>三大运营商用户争夺战升级：管道是绕不过的坎</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/603544817.html' target='_blank'>电商价格战煎熬上游供应商：订单爆棚员工抓狂</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/096314439.html' target='_blank'>网易确定加入千元智能机大战 配4.3寸屏双核CPU</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/0963144739.html' target='_blank'>网易确定加入千元智能机大战 配4.3寸屏双核CPU</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/87450477.html' target='_blank'>华为终端首款旗舰级轻薄双核智能</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/629534522.html' target='_blank'>搜索页面右侧增加了大篇幅的更明确的搜索结</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/079564438.html' target='_blank'>推进利用TSV(硅通孔)的三维层叠型新一代</a></td><td width='10%' class='fw_s'>[2012-5-23]</td></tr><tr><td width='90%' class='fw_t'>·<a href='/html/965373635.html' target='_blank'>日本推出的一款超薄防水手机套或许会改变我们</a></td><td width='10%' class='fw_s'>[2012-5-21]</td></tr></ul>
        <tr>
          <td colspan="3"   height="10"></td>
        </tr>
      </table>-->
<div class="clearfix"></div>
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






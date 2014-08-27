<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dituBaidu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>

		<body>
		
		
		
								<form action="" method="get">
									  <label >地点：</label>
									  <input id="where" name="where" type="text" >
									  <input type="button" value="地图上找" onClick="sear(document.getElementById('where').value);" />
									  <br />		
								<div id="container" style="height:300px; width:400px; top:px; left:px;" ></div>
								
								
								 <br />
									 	 经纬度：
									  <input id="lonlat" name="lonlat" type="text">
								</form>
								
									<script type="text/javascript">
										var map = new BMap.Map("container"); // 创建地图实例
										var point = new BMap.Point(116.404, 39.915); // 创建点坐标
										map.enableScrollWheelZoom();   //启动鼠标中键控制地图缩放  
										map.centerAndZoom(point, 15); // 初始化地图，设置中心点坐标和地图级别
										map.enableContinuousZoom();    // 开启连续缩放效果
										map.enableInertialDragging(); // 开启惯性拖拽效果
										map.addControl(new BMap.NavigationControl()); // 添加控件
										map.addControl(new BMap.ScaleControl());
										map.addControl(new BMap.OverviewMapControl());  
										map.addControl(new BMap.MapTypeControl());
										
										
										//获得经纬度
										var map = new BMap.Map("container");//在指定的容器内创建地图实例
										map.setDefaultCursor("crosshair");//设置地图默认的鼠标指针样式
										map.enableScrollWheelZoom();//启用滚轮放大缩小，默认禁用。
										map.centerAndZoom(new BMap.Point(116.124878, 24.309178), 13);
										map.addControl(new BMap.NavigationControl()); 
										map.addEventListener("click", function(e){//地图单击事件
										    document.getElementById("lonlat").value = e.point.lng + ", " + e.point.lat;
										    document.getElementById("fd_mapx").value = e.point.lng;
										    document.getElementById("fd_mapy").value = e.point.lat;
										});
										function iploac(result){//根据IP设置地图中心
										    var cityName = result.name;
										    map.setCenter(cityName);
										}
										var myCity = new BMap.LocalCity();
										myCity.get(iploac);
										function sear(result){//地图搜索
										    var local = new BMap.LocalSearch(map, {
										        renderOptions:{map: map}
										    });
										    local.search(result);
										}
										
										//产生地图标记
										  initMap(); //创建和初始化地图
										   map.addEventListener("click", function (e) {
										   point = new BMap.Point(e.point.lng, e.point.lat);
										   var marker = new BMap.Marker(point);
										   map.addOverlay(marker);   
										   document.getElementById("txbMarker").value = e.point.lng+ "," + e.point.lat;   });
														
										var marker； //声明一个空标记
									     //以下是点击事件			
									     map.addEventListener("click", function (e) {
									
									         checkMaker();
									
									         point = new BMap.Point(e.point.lng, e.point.lat);//捕捉点击的坐标值
									         marker = new BMap.Marker(point); //给标记赋新坐标值
									         map.addOverlay(marker); //添加新标记
									         });
									
									     function checkMaker() {
									
									     if (marker != null) 
									
									       map.removeOverlay(marker); //如果marker已经存在，删除标记
									     };
									</script>
						
						  
						 
				
		</body>
</html>

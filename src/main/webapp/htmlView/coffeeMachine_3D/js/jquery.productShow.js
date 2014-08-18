
(function($){
    /*
	默认配置:
	width:元素宽度
	height:元素高度
	threshold:鼠标移动距离的阈值，当鼠标移动距离大于此值，引发图片切换
	col：组图列数
	row:组图行数
	col_isloop:图片的横向切换是否支持循环切换
	row_isloop:图片的纵向切换是否支持循环切换
	*/
 	var gallerydefaults = {
		width: 399,
		height: 266,
		threshold: 6,
		col:5,
		row:2,
		col_isloop:true,
		row_isloop:true,
		bImgFileName:'img-b',
		sImgFileName:'img',
		imgExpandedName:'.jpg'
	}
	
			//放大参数
			var zoomParam={
			    origWidth:399,
	            origHeight:266,
				zoomStep:0,
				top:0,
				left:0,
				isSwitchBig:false,
				curImgPath:'img/1-1.jpg',
				size:'small',
				curId:'1-1'
				}
				//当前对象中的第一个ul
		    	//起始点的横纵坐标
			var startPoint={
				x:0,
				y:0
				}
			//终止点的横纵坐标
			var endPoint={
				x:0,
				y:0
				}

			var	swipestart = false, //标记移动是否开始
			    angle=0,   //标记鼠标移动角度
			    distance=0, //标记鼠标移动距离
			    phase='end', //标记鼠标状态
			    validState=null //标记鼠标监听有效性
			var i,j
			var $belt,setting,$imgs,firstImgId ,$curImg,curImgSrc
			var colArr = new Array()
            var isMouseDown = false
	
	$.fn.touchgallery = function(options){
		return this.each(function(){
			//根据用户的配置扩展默认配置
			 setting = $.extend({}, gallerydefaults, options)
             
	         j=Math.ceil(setting.col/2), //当前图片所处的列
			 i=Math.ceil(setting.row/2)  //当前图片所处的行
			 zoomParam.curId = i + "-" + j;
			 firstImgId = i + "-" + j;
			 zoomParam.curImgPath = setting.sImgFileName + "/" + zoomParam.curId + setting.imgExpandedName;
             //初始化列数组
			 for(var k=0;k<setting.col;k++){
			     colArr[k] = k+1;	 
			 }
			  
			zoomParam.origWidth = setting.width ;
			zoomParam.origHeight = setting.height;
			//当前对象赋值给slideshow
			var	$slideshow = $(this);
              $belt = $("#product").find('ul:eq(0)');
			//当前对象下的图片列表
			$imgs = $belt.find('img');

			//初始化当前第一张图片
			$curImg = $('#'+i+'-'+j);
		
			$imgs.hide();
			$curImg.show();
		     zoomParam.curImgPath = $curImg.attr("src");

		    
				
			//鼠标按下，标记移动开始,记录起始点,调用swipe()方法
			$belt.mousedown($.fn.touchgallery.mousedown);
			
			//鼠标抬起,移动结束，调用swipe()方法
			$(document.body).mouseup($.fn.touchgallery.mouseup);
				
			
			//图片切换方法，i为当前图片所在行，j为当前图片所在列
			$belt.moveit = $.fn.touchgallery.moveit;
			
		
			
		})
	}
	
	
	//绑定鼠标监听器
	 $.fn.touchgallery.bind=function(){
	    //鼠标按下，标记移动开始,记录起始点,调用swipe()方法
			$belt.mousedown($.fn.touchgallery.mousedown);
			
			//鼠标抬起,移动结束，调用swipe()方法
			$(document.body).mouseup($.fn.touchgallery.mouseup);
				
			
			//图片切换方法，i为当前图片所在行，j为当前图片所在列
			$belt.moveit = $.fn.touchgallery.moveit;
	 }
	 
	 	//解绑定鼠标监听器
	 $.fn.touchgallery.unbind=function(){
	    //鼠标按下，标记移动开始,记录起始点,调用swipe()方法
			$belt.unbind();
			$(document.body).unbind();
             
	 }
	 
	  $.fn.touchgallery.resetAll=function (){
	    $.fn.zoom.resetCurImg(firstImgId);
		  
	  }
	$.fn.touchgallery.init=function (){
			 i = 1;
			 j = 1;
			 zoomParam.curId = '1-1';
			 firstImgId = '1-1';
			 zoomParam.curImgPath = 'img/1-1.jpg';  
			 $belt.attr({id:"z:0;t:0;l:0;img:img/1-1.jpg;curId:1-1"});
	  }	
	      
	 
	 		//根据鼠标方向设置当前的图片
	$.fn.touchgallery.navigate = function (keyword,isAuto,callback){

				var imgname,pathname
			//找到未切换的当前图片，将其还原到原位置，并设置其大小为为默认大小（恢复缩放带来的变化）
			var data = $belt.attr("id");
			
			//找不到大图，就拼接小图
		   if(data == null ){
			zoomParam.isSwitchBig = false;
			}
		   
		   $curImg=$belt.find('#'+i+'-'+j);

		    //如果已经换了大图是找不到小图的，判断当前是否大图
			if(null != data){
			    //获取放大参数
				var arryObject = data.split(';');
				 zoomParam.left = arryObject[2].split(":")[1];
				 zoomParam.top = arryObject[1].split(":")[1];
				 zoomParam.zoomStep = arryObject[0].split(":")[1];
				 zoomParam.curImgPath = arryObject[3].split(":")[1];

				 zoomParam.curId = arryObject[4].split(":")[1];
			      zoomParam.isSwitchBig = true;
			 }
			 
		     curImgPath = $curImg.attr("src");
		   	//下一个是小图就更换大图
	

				//keyword代表鼠标移动的方向，根据鼠标移动方向计算行号和列号
				switch (keyword){
					//向右
					case 'forth':
						//判断横向是否支持循环切换
					    if(setting.col_isloop){	
							//支持循环：判断当前列数是否小于组图的总列数，如果是则当前列数+1，否则设置当前列数为第一列			 
					   	 	//j=(j<setting.col)?(j+1):1;
							//在自动播放的状态下,从底部
					       if(j<setting.col){
							    j = j+1;
							 }else{
						        j = 1;
							    if(setting.row_isloop &&  true == isAuto )
							
                                   i = (i >= setting.row) ? 1 : i+1;

						      
                              }
						}else{   //不支持循环：判断当前列数是否小于组图的总列数，如果是则当前列数+1，否则当前列数为最后一列
							j=(j<setting.col)?(j+1):setting.col;
						}
						

						break;
					//向左
					case 'back':
					    if(setting.col_isloop){	
							//j=(j>1)?(j-1):setting.col;
							 if(j>1){
							    j = j-1;
							 }else{
						        j = setting.col;
							  if(setting.row_isloop && isAuto) 
								i = (i <= 1) ? setting.row : i-1;
						      
						      }
							
						}else{
							j=(j>1)?(j-1):1;
						}
						break;
					//向上
					case 'up':
					
/*					else if(false == isAuto && i>=setting.row){ //手动切换
									    j = colArr[colArr.length - j]
										i = setting.row;
								   }else if(false == isAuto && i<setting.row){
								        
								   }*/
					    if(setting.row_isloop){
							//i=(i>1)?(i-1):setting.row;
						   if(false == isAuto){
							 if(i>1){
								i = i-1;
							 }else{
								i=1; 
								j = (setting.col/2 + j) <= setting.col ? (setting.col/2 + j):(j - setting.col/2) ;
								j = colArr[Math.ceil(j)-1];
							 }
						   }else if(null == isAuto){
							    i=(i>1)?(i-1):setting.row;
							}	 
						}
						else
						{
							i=(i>1)?(i-1):1;	
						}
						break;
					//向下
					case 'down':
					    if(setting.row_isloop){
							//i=(i<setting.row)?(i+1):1;
						   if(false == isAuto){
							 if(i<setting.row){
								i = i+1;
							 }else{
								i=setting.row; 
							    j = (setting.col/2 + j) <= setting.col ? (setting.col/2 + j):(j - setting.col/2) ;
								j = colArr[Math.ceil(j)-1];
							 }
						   }else if(null == isAuto){
							    i=(i<setting.row)?(i+1):1;
						    }	
						}
						else
						{
							i=(i<setting.row)?(i+1):setting.row;
						}
						break;
					//西北方向
					case 'northwest':
					     
					    if(setting.col_isloop){	
							j=(j>1)?(j-1):setting.col;
						}
						else
						{
							j=(j>1)?(j-1):1;
						}
						if(setting.row_isloop){
							i=(i>1)?(i-1):setting.row;
						}
						else
						{
							i=(i>1)?(i-1):1;	
						}
						break;
					//东北方向
					case 'northeast':
					    if(setting.row_isloop){
							i=(i>1)?(i-1):setting.row;
						}
						else
						{
							i=(i>1)?(i-1):1;	
						}
						 
						if(setting.col_isloop){				 
					   	 	j=(j<setting.col)?(j+1):1;
						}
						else
						{
							j=(j<setting.col)?(j+1):setting.col;
						}
						break;
					//西南方向
					case 'southwest':
						if(setting.col_isloop){	
							j=(j>1)?(j-1):setting.col;
						}
						else
						{
							j=(j>1)?(j-1):1;
						}
						if(setting.row_isloop){
							i=(i<setting.row)?(i+1):1;
						}
						else
						{
							i=(i<setting.row)?(i+1):setting.row;
						}
						break;
					//东南方向
					case 'southeast':
					
					    if(setting.col_isloop){				 
					   	 	j=(j<setting.col)?(j+1):1;
						}
						else
						{
							j=(j<setting.col)?(j+1):setting.col;
						}
						
						if(setting.row_isloop){
							i=(i<setting.row)?(i+1):1;
						}
						else
						{
							i=(i<setting.row)?(i+1):setting.row;
						}
						break;	
					default:
					break;
					
				}
			
			    //根据行号和列号计算索引值

				//利用索引值切换图片
				$belt.moveit( i,j);	
			}

          $.fn.touchgallery.mousedown=function(event){
			  
		 if( $("#magnifier").attr("curFocus") == 'on' || $("#playstart").attr("curFocus") == 'on'
		  || $("#turnleft").attr("curFocus") == 'on' || $("#turnright").attr("curFocus") == 'on' ) return;
			  
			    isMouseDown = true;
			  	validState = $belt.data("events")["mousemove"] ;
				 if (validState != null) return false;
				 
				event = event?event:(window.event?window.event:null);
				startPoint.x = event.x ? event.x : event.pageX;
				startPoint.y = event.y ? event.y : event.pageY;

				//startPoint.x=event.pageX;
			    //startPoint.y=event.pageY;
				phase='start';
				$.fn.touchgallery.swipe(event, phase);
				//判断$belt元素上是否绑定了mousemove事件

					//鼠标移动，标记移动中，调用swipe()方法
				  if(validState == null){
					$belt.bind("mousemove",function(event){
						if(isMouseDown == false) return ;
						if (validState == null){
							phase='move';
							$.fn.touchgallery.swipe(event, phase);
							return false; //阻止mousemove的默认事件
						}
					});
				  }
				return false;  //阻止mousedown的默认事件
			}
			
			$.fn.touchgallery.mouseup = function(event){	
			     isMouseDown = false;
				 $belt.unbind("mousemove"); 
				 $(document.body).unbind("mousemove");
				phase='end';
				$.fn.touchgallery.swipe(event, phase);
				return false;//阻止mouseup的默认事件
			 }
			 
			 		//传入的phase（鼠标状态）		
			$.fn.touchgallery.swipe = function(event, phase){
				 
				//submitEvent(event);
				//开始阶段，记录起始点
				if (phase == 'start'){
					swipestart = true;
					startPoint.x = event.x ? event.x : event.pageX;
					startPoint.y = event.y ? event.y : event.pageY;
					
					}
				//移动阶段，实时记录终点，
				else if (phase == "move" && swipestart){
					endPoint.x = event.x ? event.x : event.pageX;
					endPoint.y = event.y ? event.y : event.pageY;
					
					
					distance=calculateDistance(startPoint, endPoint);//记录起始点和终点间的距离
					angle=calculateAngle(startPoint, endPoint);//记录起始点和终点间的角度
					direction=calculateDirection(startPoint, endPoint );//记录起始点和终点间的方向
					
					if(direction == 'none') return;

					var threshold = (direction == 'up' || direction == 'down') ? setting.threshold * 2 : setting.threshold;
					
					var dist=distance%(threshold);
					
				   
					
					//鼠标移动距离达到阈值，则将当前的终点改为起点，并调用图片切换方法
					if( dist==0&&distance!=0){
						startPoint.x=endPoint.x;
			            startPoint.y=endPoint.y;
						if(direction=='left'){
							 	 $.fn.touchgallery.navigate('forth');
							}else if(direction=='right'){
							 	 $.fn.touchgallery.navigate('back');
							}
							else if(direction=='up'){
								$.fn.touchgallery.navigate('up');	
							}
							else if(direction=='down'){
								$.fn.touchgallery.navigate('down');	
							}
						}

				}
			    else if (phase == 'end'){
			    	
                    swipestart = false;
                   
                    return;
				}
	
	        //设置默认图片，进行navigate
			//var curslide =i+(j-1)*setting.col-1;
			$.fn.touchgallery.navigate('curslide');

				
			
			
			 //计算两点之间的距离 
			 function calculateDistance(startPoint, endPoint) {
								return Math.round(Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) +
								 Math.pow(endPoint.y - startPoint.y, 2)));
						}
				
			  //计算两点之间的角度（以起始点为原点）
			 function calculateAngle(startPoint, endPoint) {
								var x = startPoint.x - endPoint.x;
								var y = endPoint.y - startPoint.y;
								var r = Math.atan2(y, x); //radians
								var angle = Math.round(r * 180 / Math.PI); //degrees
		
								//ensure value is positive
								if (angle < 0) {
										angle = 360 - Math.abs(angle);
								}
		
								return angle;
						}
			
			//根据角度，计算方向		
			 function calculateDirection(startPoint, endPoint ) {
								var angle = calculateAngle(startPoint, endPoint);
		
								if ((angle <= 22.5) && (angle >=0)) {
										return 'left';
								} else if ((angle <=360 ) && (angle >= 337.5)) {
										return 'left';
								} else if ((angle >=157.5) && (angle <= 202.5)) {
										return 'right';
								} else if ((angle >= 67.5) && (angle <=112.5)) {
										return 'down';
								} else if ((angle >=247.5) && (angle <=292.5)){
										return 'up';
								} else if ((angle >292.5 ) && (angle < 337.5)) {
										return 'northwest';
								} else if ((angle >202.5 ) && (angle < 247.5)) {
										return 'northeast';
								} else if ((angle > 22.5)  && (angle <67.5)) {
										return 'southwest';
								} else if ((angle > 112.5) && (angle < 157.5)){
										return 'southeast';
								}else{
									   return 'none';
									}
				}	
											
		  }
		  
			 
		  $.fn.touchgallery.moveit = function(i,j){
				
			var t=0,
		    l=0,
		    top=0,
		    left=0,
			w=0,
			h=0,
			imgname,
			pathname
             
			 var nextImgSrc
			//将所有的img设置为不可见
			$imgs.hide(); 
			 
			     //已经计算出下一个图片的路径
			var $nextImg=$belt.find('#'+i+'-'+j);
           // curId = $nextImg.attr("id");
			//下一个图片是否存在
			if($nextImg.length > 0){
				nextImgSrc = $nextImg.attr("src");
				
			}
             if(nextImgSrc.match(setting.bImgFileName +"/")){
				   nextImgSrc=nextImgSrc.replace(setting.bImgFileName + "/",setting.sImgFileName + "/");
				  $nextImg.attr({src:nextImgSrc});
				 
                   zoomParam.zoomStep = 0;
				   	zoomParam.top = 0;
					zoomParam.left = 0;	 

				$(".toolbar").show();
			}
		 
				 zoomParam.curImgPath = nextImgSrc;
				zoomParam.curId = i+'-'+j;

				  //保存当前图片状态的参数  
	            var data = 'z:'+zoomParam.zoomStep+';t:'+zoomParam.top+';l:'
				 +zoomParam.left+';img:'+ zoomParam.curImgPath +';curId:'+zoomParam.curId;
		          $belt.attr({id:data}); 

				 //获取大图的放大参数

				 t = zoomParam.top;
				 l = zoomParam.left;
				 
				
			    var zoomCount =  parseInt(zoomParam.zoomStep);
		        $.fn.zoom.zoomIt(top,left,t,l,$nextImg,zoomParam,nextImgSrc);

			}
  }
) (jQuery)

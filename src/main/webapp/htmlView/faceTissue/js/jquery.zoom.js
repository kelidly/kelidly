
  (function($){
  
	var defaults={
	   origWidth:399,
	   origHeight:266,
	   zoomStep:0
	
		}
   var setting,pos,$belt
   
   
   
   
   $.fn.zoom=function(options){  
	 return this.each(function(){		
	   setting = $.extend({},defaults,options);
	   //var pos=$("#touchgallery1").offset();
	   $belt = $("#product").find('ul:eq(0)');
	    pos=$(this).parent().offset();   
	   $(this).bind("mousewheel.zoom",$.fn.zoom.zoomBind)
  
	  });     
	}
    
		 	
	  $.fn.zoom.resetCurImg=function (resetId){

           var data  = $belt.attr("id");
           var $curImg,curId,data;
			    //获取放大参数
		   var arryObject = data.split(';');
		   var zoomCount = arryObject[0].split(":")[1];
		   	var curSrc = arryObject[3].split(":")[1];
			curId = arryObject[4].split(":")[1];
            $curImg = $("#"+ curId );
			
			if(curSrc.match("img-b")) {
				curSrc = curSrc.replace("img-b/","img/");
				$curImg.attr({src:curSrc});
			}
			//重置当前图
		  if(zoomCount > 0){
			 	 //保存当前图片状态的参数  
		   var data = 'z:'+0+';t:'+0+';l:'+0+';img:'+ curSrc +';curId:'+curId;
		   $belt.attr({id:data}); 
		   setting.zoomStep = 0;
		   
		   $curImg.width(setting.origWidth); 	
		   $curImg.height(setting.origHeight);
           $curImg.css({"margin-top":0+'px'});
           $curImg.css({"margin-left":0+'px'}); 
		   $curImg.show();
		  }
		  			
			
		 //重置按钮设置
		 if(resetId){
			 if(resetId != curId)  $curImg.hide();

			 	 //保存当前图片状态的参数  
            $curImg = $("#"+ resetId );
		    data = 'z:'+0+';t:'+0+';l:'+0+';img:'+ $curImg.attr("src") +';curId:'+resetId;
			setting.zoomStep = 0;
		   $belt.attr({id:data}); 
		   $curImg.width(setting.origWidth); 	
		   $curImg.height(setting.origHeight);
           $curImg.css({"margin-top":0+'px'});
           $curImg.css({"margin-left":0+'px'}); 
		   $curImg.show();
		
		 }


		   
  

	  }
	  
 
	  
	  $.fn.zoom.zoomIt=function (top,left,t,l,node,setting,curImgSrc){
		  
		  var w,h
		  var zoomCount =  parseInt(setting.zoomStep);	
	      switch(zoomCount){
			case 0:
			w=setting.origWidth;
			h=setting.origHeight;
			top=0;
			left=0;
			break; 
			case 1:
			w=setting.origWidth*1.5;
			h=setting.origHeight*1.5;
			top=parseFloat(t)*(1.5-1);
			left=parseFloat(l)*(1.5-1);
			break;
			case 2:
			w=setting.origWidth*2;
			h=setting.origHeight*2;
			top=parseFloat(t)*1;
			left=parseFloat(l)*1;
			break; 
			case 3:
			w=setting.origWidth*3;
			h=setting.origHeight*3;
			top=parseFloat(t)*2
			left=parseFloat(l)*2
			break;
			case 4:
			w=setting.origWidth*4;
			h=setting.origHeight*4;
			top=parseFloat(t)*3;
			left=parseFloat(l)*3;
			break; 
			case 5:
			w=setting.origWidth*8;
			h=setting.origHeight*8;
			top=parseFloat(t)*7
			left=parseFloat(l)*7
			break;
			case 6:
			w=setting.origWidth*16;
			h=setting.origHeight*16;
			top=parseFloat(t)*15
			left=parseFloat(l)*15
			break;
			default:
			w=setting.origWidth;
			h=setting.origHeight;
			top='0px';
			left='0px';
			break
			}
	     //alert("width"+w+"height"+h);
  
          $(node).height(h); 	
		  $(node).width(w);

           $(node).css({"margin-top":-top+'px'});
           $(node).css({"margin-left":-left+'px'}); 
		   
/*		   var posAt = curImgSrc.indexOf("?t=");
		    if(posAt != -1){
			  curImgSrc = curImgSrc.substr(0,posAt);
		    }
			if(curImgSrc.match("img-b/")){
		     $(node).attr({src:curImgSrc +"?"+Date()});
			}*/
		     $(node).show();

	   }
	   
	    
	  $.fn.zoom.animatIt=function (mode){
		  var top,left,w,h
	
		  
		  //获取当前img参数
          var data = $belt.attr("id");
				 var arryObject = data.split(';');
				 var l = arryObject[2].split(":")[1];
				 var t = arryObject[1].split(":")[1];
				 setting.zoomStep = arryObject[0].split(":")[1];
				 var curImgPath = arryObject[3].split(":")[1];
                 var _curId = arryObject[4].split(":")[1];
                 var $thisImg = $("#"+_curId);

			var l = setting.origWidth/2;
			var t = setting.origHeight/2;
			
			          //计算缩放参数
		  var zoomCount =  parseInt(setting.zoomStep);	
			
			//计算放大倍数
			if(mode == 'zoomOut'){
				if(zoomCount == 0) return;
			  setting.zoomStep = zoomCount < 0 ? 0 : zoomCount - 1 ; 
			}else if(mode == 'zoomIn'){
				if(zoomCount == 6) return;
			  setting.zoomStep = zoomCount > 6 ? 6 : zoomCount + 1 ; 
			}

			

	      switch(setting.zoomStep){
			case 0:
			w=setting.origWidth;
			h=setting.origHeight;
			top=0;
			left=0;
			break; 
			case 1:
			w=setting.origWidth*1.5;
			h=setting.origHeight*1.5;
			top=parseFloat(t)*(1.5-1);
			left=parseFloat(l)*(1.5-1);
			break;
			case 2:
			w=setting.origWidth*2;
			h=setting.origHeight*2;
			top=parseFloat(t)*1;
			left=parseFloat(l)*1;
			break; 
			case 3:
			w=setting.origWidth*3;
			h=setting.origHeight*3;
			top=parseFloat(t)*2
			left=parseFloat(l)*2
			break;
			case 4:
			w=setting.origWidth*4;
			h=setting.origHeight*4;
			top=parseFloat(t)*3;
			left=parseFloat(l)*3;
			break; 
			case 5:
			w=setting.origWidth*8;
			h=setting.origHeight*8;
			top=parseFloat(t)*7
			left=parseFloat(l)*7
			break;
			case 6:
			w=setting.origWidth*16;
			h=setting.origHeight*16;
			top=parseFloat(t)*15
			left=parseFloat(l)*15
			break;
			default:
			w=setting.origWidth;
			h=setting.origHeight;
			top='0px';
			left='0px';
			break
			}
			 

			//动画缩放
		   $thisImg.animate({
			 height:h,
			 width:w,
			 marginLeft:-left+'px',
			 marginTop:-top+'px'
			 },'slow');
			 
			
			//换大图
			if(null == curImgPath.match("img-b/") && setting.zoomStep > 0){
			  	curImgPath = curImgPath.replace("img/","img-b/")
				$thisImg.attr({src:curImgPath});
			}
			
			//换小图
			if(null != curImgPath.match("img-b/") && setting.zoomStep <= 0){
			  	curImgPath = curImgPath.replace("img-b/","img/")
				$thisImg.attr({src:curImgPath});
			}
			 //保存当前img状态data
			 data = 'z:'+setting.zoomStep+';t:'+t+';l:'+l+';img:'+curImgPath +';curId:'+_curId;
			 $belt.attr({id:data}); 
	         
	   } 

    //放大镜
	$.fn.zoom.magnifier=function(state){

		  var $curContImg = $("#magnifier");
          var data = $belt.attr("id");
		   //关闭放大镜
		  if(state == 'off'){
			 $curContImg.attr({curFocus:'off'});
			var $curImg =  $("#"+data.split(';')[4].split(":")[1]);
			$curImg.imageLens.unbind();
			$belt.touchgallery.bind();
			$curImg.bind("mousewheel.zoom",$.fn.zoom.zoomBind); 
			
		    $("#glassOffSpan").hide();
		    $("#glassOnSpan").show();
			return; 
		  }else if(state == 'on'){
			 	 
			    //获取放大参数
				 var arryObject = data.split(';');
				 var zoomStep = arryObject[0].split(":")[1];
				 var curImgPath = arryObject[3].split(":")[1];
                 var _curId = arryObject[4].split(":")[1];
                 var $curImg = $("#"+_curId);
		
					  
				  //大图的话，就换小图，保存记录	 
				 if(curImgPath.match("img-b/") && zoomStep >0){
					curImgPath =  curImgPath.replace("img-b/","img/");
					 $curImg.attr({src:curImgPath});
					 data = data.replace("img-b/","img/");
					 $belt.attr({id:data});
					 //大图的话，就缩小图片
					 $curImg.height(setting.origHeight); 	
		             $curImg.width(setting.origWidth);
                     $curImg.css({"margin-top":0+'px',"margin-left":0+'px'});

				  }
		       
		         //关闭鼠标事件的监听
		   	     $belt.unbind();
		        // $curImg.unbind();
				
				 //开启放大镜控件
	             $curImg.imageLens({ lensSize: 200, imageSrc: $curImg.attr("bImg") }); // lens size + custom image
                 $curContImg.attr({curFocus:'on'});
			     
				 $("#glassOnSpan").hide();
				 $("#glassOffSpan").show();
		   }
	
	   }
	
	
	$.fn.zoom.zoomBind=function(e,delta)
	   {	
	   	   
	   if( $("#magnifier").attr("curFocus") == 'on' || $("#playstart").attr("curFocus") == 'on'
		 || $("#turnleft").attr("curFocus") == 'on' || $("#turnright").attr("curFocus") == 'on' ) return;
	   //从productShow传递放大倍数

			 var data = $belt.attr("id");
		    //如果已经换了大图是找不到小图的，判断当前是否大图
			if(null != data){
			    //获取放大参数
				var arryObject = data.split(';');
				 setting.zoomStep = parseInt(arryObject[0].split(":")[1]);
			 }
		  
		   if(delta>0){
			    if(setting.zoomStep<6){
			
				setting.zoomStep++;	
				$.fn.zoom.resizeImg(this,e);	
				}
		   		
		   }
		   else{
			    if(setting.zoomStep>0){
				setting.zoomStep--;	
				
				//缩小的
				
				$.fn.zoom.resizeImg(this,e);	
				}
		   		
		   }

		   return false;
	   }
	   
	   	

		   
	  $.fn.zoom.resizeImg=function(node,e){
		  
		  	//放大状态隐藏工具，缩略图状态显示工具
/*		   	if(setting.zoomStep > 0 && false == $(".toolbar").is(":hidden")){
				$(".toolbar").hide();
			}else if(setting.zoomStep <= 0 && true == $(".toolbar").is(":hidden")){
				$(".toolbar").show();
			}*/
        
		 //submitEvent(e);
        e=e?e:(window.event?window.event:null);
		 var  menu_x = e.x ? e.x : e.pageX;  
		  var  menu_y = e.y ? e.y : e.pageY; 
        // alert("menu_x="+menu_x+"menu_y"+menu_y);
		  /*计算鼠标所在位置离边框的上、左的距离*/
        var t= menu_y-pos.top,
		    l= menu_x-pos.left,
		    top=0,
		    left=0

	
		//增加代码
			 var curImgSrc = $(node).attr("src");
             var curId = $(node).attr("id");
			 //原来是小图的，放大倍数大于1的话，换大图
		if(curImgSrc.match("img/") ){
		   if(setting.zoomStep  > 0){
		    curImgSrc = curImgSrc.replace("img/","img-b/");
		   }
		    $(node).attr({src:curImgSrc});
		  
		  
		   var data = 'z:'+setting.zoomStep+';t:'+t+';l:'+l+';img:'+curImgSrc +';curId:'+curId;
		  
		   $belt.attr({id:data}); 
		 }else{
			//缩小为0时候且是大图的时候，换小图
			 if(setting.zoomStep  == 0 ){
				 curImgSrc = curImgSrc.replace("img-b/","img/");
		        $(node).attr({src:curImgSrc});
		        //还原原始尺寸
		       // t=0;l=0; 
			  }	 
	
			var data = 'z:'+setting.zoomStep+';t:'+t+';l:'+l+';img:'+curImgSrc +';curId:'+curId;
		    
			 $belt.attr({id:data}); 
		  }
		  //$(node).attr({src:curImgSrc});
		   $.fn.zoom.zoomIt(top,left,t,l,node,setting,curImgSrc);
	
		 }
   }
  )(jQuery)
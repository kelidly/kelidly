
 var col=24,row=1
 
jQuery(function(){ // 在dom加载完毕时执行,$(document).ready() 的简写
    
        
   
		//初始化jquery.prodouctShow.js插件
		$('#product').touchgallery({
			width: 399,
		    height: 266,  
			threshold: 4,
			col:col,
			row:row
			//col_isloop:true,
			//row_isloop:true
		});
		
		//初始化jquery.zoom.js插件
	   $("#product img").zoom({
		 origWidth:399,
	  	 origHeight:266,
		 zoomStep: 0
			});
		
	
 
        //初始化数据
		var j=Math.ceil(col/2); //当前图片所处的列
		var i=Math.ceil(row/2); //当前图片所处的行		
		var data  = 'z:'+0+';t:'+0+';l:'+0+';img:'+'img/'+i+'-'+j+".jpg" +';curId:'+i+'-'+j;
		    var $belt = $("#product").find('ul:eq(0)');
			 $belt.attr({id:data}); 
			$("#"+ i+'-'+j).height(266).width(399); 	
	})
	
	  function   submitEvent(evt)   {  
          evt=evt?evt:(window.event?window.event:null);
      }  
	  
	  //放大镜
	  function magnifierImg(state){
		  
        stopOtherOperation('magnifier');
        $.fn.zoom.magnifier(state);
	

	  }
	  var interval
	  //播放图片
	  function play(mode){
		  // var $belt = $("#product").find('ul:eq(0)');
		  //$belt.touchgallery.navigate('forth');
		  var curContPan = $("#play"+mode);
		   var curFocus = curContPan.attr("curFocus");
		  
		  if(mode == 'start'){
              stopOtherOperation('playstart');
			 $("#startSpan").css("display","none");
			 $("#pauseSpan").css("display","inline");
			 $.fn.zoom.resetCurImg();
            interval = setInterval("$.fn.touchgallery.navigate('forth',true)", 200);   //定时的设置  
             curContPan.attr({curFocus:'on'});
		  }else if(mode == 'pause'){
			  //if($("#playstart").attr("curFocus") == 'false')
            // stopOtherOperation();
			 $("#startSpan").css("display","inline");
			 $("#pauseSpan").css("display","none");;
			  clearTimeout(interval);  //关闭定时器 
			  $("#playstart").attr({curFocus:'off'}); 
		  }

	  }
	 //自动缩放图片
	  function zoomImg(mode){
         stopOtherOperation();
	     $.fn.zoom.animatIt(mode);
	  }
	  
	  var rotateTime
	   var timerCount=0
	   
	   //转动图片
	  function moveImg(mode,param){
		  if(mode == 'turnAround'){
			 timerCount++;
		    if(timerCount >= row * col || param == 'forceStop'){
			 timerCount = 0;
			  clearTimeout(rotateTime);  //关闭定时器 
			  $("#turnleft").attr({curFocus:'off'});
			  $("#turnright").attr({curFocus:'off'});
			 return;
		     }
		  }else if(mode == 'left' ){
			 if( $("#turnleft").attr("curFocus") == 'on' ) return;
                 stopOtherOperation('turnleft');
				 $.fn.zoom.resetCurImg();
				 //$.fn.touchgallery.init();
			   rotateTime = setInterval("$.fn.touchgallery.navigate('back',true,moveImg('turnAround'))", 200);   //定时的设置
			   $("#turnleft").attr({curFocus:'on'});
		  }else if(mode == 'right' ){
			  if($("#turnright").attr("curFocus") == 'on' ) return;
                  stopOtherOperation('turnright');
				 $.fn.zoom.resetCurImg();
				 //$.fn.touchgallery.init();
			   rotateTime = setInterval("$.fn.touchgallery.navigate('forth',true,moveImg('turnAround'))", 200);   //定时的设置
			   $("#turnright").attr({curFocus:'on'});
		  } else if(mode == 'reset'){
             
             stopOtherOperation();

		     $.fn.zoom.resetCurImg('1-1');
		  }
	  
	  
	  }
	  
	  function stopOtherOperation(button){
		  
			 if( $("#magnifier").attr("curFocus") == 'on' && button != 'magnifier'){
					//关闭放大镜
					magnifierImg('off');
					//return;
				}
             if( $("#playstart").attr("curFocus") == 'on' && button != 'playstart'){
				    //暂停
					play('pause'); 
				}
		      if( $("#turnleft").attr("curFocus") == 'on' && button != 'turnleft'){
				  moveImg('turnAround','forceStop')
				}
			  if( $("#turnright").attr("curFocus") == 'on' && button != 'turnright'){
				  moveImg('turnAround','forceStop')
				}
	  }
	  
	    //显示预加载遮罩层
	  	function showOverlay(){
			var _this = $("#product");
		var mark = $("<div />");
			mark.attr("id","overlay");
			mark.height($(_this).outerHeight() + $(".toolbar").outerHeight());
			mark.width($(_this).width());
			mark.css({display:'block', cursor:'wait', position:'absolute', background:'#000', filter:'alpha(opacity=5)' ,opacity:'0.5'});
			mark.css("top",$(_this).offset().top);
			mark.css("left",$(_this).offset().left);
			
		var loaddiv = $("<div />");
			loaddiv.html("<img alt='loading...' src='images/loading.gif'>");
			loaddiv.css({position:'absolute', 'text-align' :'center'});
			loaddiv.css("top", parseInt($(_this).height())/ 2);
			loaddiv.width($(_this).width());
			//mark.append(loaddiv);
			
		var par = $("#frame");
			par.append(loaddiv);
	}



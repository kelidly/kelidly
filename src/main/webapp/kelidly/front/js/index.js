
(function($){
	$.fn.extend({
		fadeSlide:function(options){
			var defaults = {
				slideTime:"2000"
				};
			var options = $.extend(defaults,options);
			this.each(function(){
				var o = options;
				var obj = $(this);
				var oLi = $(".fade-ul li",obj);
				var oDiv = $(".fade-content div",obj);
				var Timer;
				var index = 1;
				var leng = (oLi.length);
				$(oDiv[0]).css({"display":"block"})
				oLi.mouseover(function(){
					index = oLi.index(this);
					showImg(index);
					}).eq(0).mouseover();
				obj.hover(function(){
						clearInterval(Timer);
					},function(){
					Timer = setInterval(function(){
							showImg(index);
							index++;
							if(index==leng)
							{
								index=0;	
							}
						},o.slideTime)	
				}).trigger("mouseleave");
				function showImg(index){
					$(oDiv[index]).fadeIn("slow").show().siblings().fadeOut().hide();
					$(oLi).removeClass("hover").eq(index).addClass("hover");
				}	
			});
		}
	});
})(jQuery);	


$(function(){ 

	var page=1;
	var i=3;
	var $p_Div=$(".pic_content");
	var $picDiv=$(".pic_lists");
	var picNum=$picDiv.children("ul").children("li").length;
	var page_count=Math.ceil(picNum/5);
	var $pDiv_w=$p_Div.width()+12;

	$(".right_btn").click(function(){
		if(page_count>page){
			$picDiv.animate({left:'-'+page*$pDiv_w+"px"},"normal");
			page++;
			$(".left_btn").css({'background':'url(img/leftstart.jpg) no-repeat'});
			if(page>=page_count){
				$(this).css({'background':'url(img/rightstop.jpg) no-repeat'});
			}else{
				$(this).css({'background':'url(img/rightstart.jpg) no-repeat'});
			}
		} 
		$(this).siblings(".highlight_tip").find("span").eq((page-1)).addClass("current").siblings().removeClass("current"); 	
	});
	
	$(".left_btn").click(function(){
		if(page>1){
			$picDiv.animate({left:"+="+$pDiv_w+'px'},"normal");
			page--;
			$(".right_btn").css({'background':'url(img/rightstart.jpg) no-repeat'});
			if(page<=1){
				$(this).css({'background':'url(img/leftstop.jpg) no-repeat'});	 
			}else{
				$(this).css({'background':'url(img/leftstart.jpg) no-repeat'});
			}
		}
		$(this).siblings(".highlight_tip").find("span").eq((page-1)).addClass("current").siblings().removeClass("current"); 	
	});
	
	$(".pic_lists>ul>li").hover(function(){
		$(this).children("p").show();
	},function(){
		$(this).children("p").hide();
	});
	
})

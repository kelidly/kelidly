$(function(){		
		function showScroll(){
			$(window).scroll( function() { 
				var scrollValue=$(window).scrollTop();
				scrollValue > 300 ? $('div[class=scroll-top]').fadeIn():$('div[class=scroll-top]').fadeOut();
			} );	
			$('#scroll-top').click(function(){
				$("html,body").animate({scrollTop:0},1000);	
			});	
		}
		showScroll();
})
$(function(){
		function weixinshow(){
			$('.WX-ico').mouseover(function(){
			$('.wx-img').removeClass('hide')							  							
			})	
		    $('.WX-ico').mouseout(function(){
			$('.wx-img').addClass('hide')							  							
			})	
		}
		weixinshow();
})
$(function(){ 
		var H=$(window).width()/2-80
		if(H)
		{
			$(".ss-left").css("width",H)	
			$(".ss-right").css("width",H)	
		} 
	}) 

$(window).resize(function(){
	var resolutionList="320,400,640,800,1024,1280,1400,1440,1600,1680,1920,2048,2560,3200,3840,";
	var resolutionListt="1280,";
	var nowwidth=window.screen.width;
	var H=$(window).width()/2-80
	if(resolutionList.indexOf(nowwidth + ",")==-1 ){
		if(H)
		{
			$(".ss-left").css("width",H)	
			$(".ss-right").css("width",H)	
		}
	}
	else{
			if(H)
			{
				$(".ss-left").css("width",H)	
				$(".ss-right").css("width",H)	
			}
		}
});

$(document).ready(function() {	
	$("#menu1 a").each(function() { //For each list item...
		var linkText = $(this).find("div").html(); //Find the text inside of the a tag
	}); 	
	$("#menu1 a").hover(function() {	//On hover...
		$(this).find("p").stop().animate({ 
			marginTop: "-20" //Find the span tag and move it up 40 pixels
		}, 200);
	} , function() { //On hover out...
		$(this).find("p").stop().animate({
			marginTop: "0" //Move the span back to its original state (0px)
		}, 200);
	});	
});



	$(function(){
		$(".M-menu2").click(function(){
			$(".M-top").addClass("M-top-show");
			$(".M-top").animate({top:'0px'},"slow");
			$("#topcontrol").animate({right:'-122px'},"slow");
		})
	})


	$(".M-design").hover(function() {	//On hover...

		$(this).find(".M-design-title").stop().animate({ 

			marginTop: "-43" //Find the span tag and move it up 40 pixels

		}, 200);

	} , function() { //On hover out...

		$(this).find(".M-design-title").stop().animate({

			marginTop: "0" //Move the span back to its original state (0px)

		}, 200);

	});

	$(".Brand").hover(function() {	//On hover...

		$(this).find(".M-design-title").stop().animate({ 

			marginTop: "-43" //Find the span tag and move it up 40 pixels

		}, 200);

	} , function() { //On hover out...

		$(this).find(".M-design-title").stop().animate({

			marginTop: "0" //Move the span back to its original state (0px)

		}, 200);

	});

	$(".move").hover(function() {	//On hover...

		$(this).find(".M-design-title").stop().animate({ 

			marginTop: "-43" //Find the span tag and move it up 40 pixels

		}, 200);

	} , function() { //On hover out...

		$(this).find(".M-design-title").stop().animate({

			marginTop: "0" //Move the span back to its original state (0px)

		}, 200);

	});

	$(".ui").hover(function() {	//On hover...

		$(this).find(".M-design-title").stop().animate({ 

			marginTop: "-43" //Find the span tag and move it up 40 pixels

		}, 200);

	} , function() { //On hover out...

		$(this).find(".M-design-title").stop().animate({

			marginTop: "0" //Move the span back to its original state (0px)

		}, 200);

	});	



// 加入收藏夹
function addfav(){
    if (document.all){
        try{
            window.external.addFavorite(WWW_URL,WWW_SITENAME);
        }catch(e){
            alert( "加入收藏失败，请使用Ctrl+D进行添加" );
        }

    }else if (window.sidebar){
        window.sidebar.addPanel(WWW_SITENAME, WWW_URL, "");
    }else{
        alert( "加入收藏失败，请使用Ctrl+D进行添加" );
    }
}

// JavaScript Document
function trim (str, charlist) {
    var whitespace, l = 0,
        i = 0;
    str += '';

    if (!charlist) {
        // default list
        whitespace = " \n\r\t\f\x0b\xa0\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u200b\u2028\u2029\u3000";
    } else {
        // preg_quote custom list
        charlist += '';
        whitespace = charlist.replace(/([\[\]\(\)\.\?\/\*\{\}\+\$\^\:])/g, '$1');
    }

    l = str.length;
    for (i = 0; i < l; i++) {
        if (whitespace.indexOf(str.charAt(i)) === -1) {
            str = str.substring(i);
            break;
        }
    }

    l = str.length;
    for (i = l - 1; i >= 0; i--) {
        if (whitespace.indexOf(str.charAt(i)) === -1) {
            str = str.substring(0, i + 1);
            break;
        }
    }

    return whitespace.indexOf(str.charAt(0)) === -1 ? str : '';
}

//图片轮换
(function(){
	$.fn.picshow = function(o){
		var o = $.extend({
			 pause:4000,
			 fspd:500,
			 auto:true
		}, o||{});
		return this.each(function(){
			var $cont = $(".ps-cont > a", this), $title = $(".ps-title > h3", this), $nav = $(".ps-nav > a", this), $pre = $(".ps-nav > .pre", this),$next = $(".ps-nav > .next", this),
			len = $cont.length;

			var interval = null, index = 0, isOver = true;
			if(o.auto){$cont.hover(function(){clearInterval(interval);}, auto);}
			if(o.auto){
				$nav.each(function(i){
					$(this).hover(function(){
						clearInterval(interval);
						roll(i);
					}, auto);
				});
			}else{
				$nav.each(function(i){
					$(this).hover(function(){roll(i);});
				});
			}

			function auto(){
				clearInterval(interval);
				interval = setInterval(function(){ roll(index==(len-1) ? 0 : index+1);}, o.pause);
			}
			function roll(i){
				if(isOver){
					isOver = false;
					$cont.hide();
					$cont.eq(i).fadeIn(o.fspd, function(){ isOver = true; });
					$nav.removeClass("hover");
					$nav.eq(i).addClass("hover");
					$title.hide();
					$title.eq(i).show();
					index = i;
				}
			}
			//init
			$cont.eq(index).show();
			$nav.eq(index).addClass("hover");
			if(o.auto){auto();}
		});
	}
})(jQuery);

//图片间隔性滚动
(function(){
	$.fn.rollpic = function(o){
		var o = $.extend({
			pause:5000,
			nspd:1000,
			uspd:300,
			vnum:5,
			snum:1,
			start:0,
			isH:true,
			auto:true
		}, o||{});

		return this.each(function(){
			var $cont = $(".sp-cont", this),
			$prev = $(".next", this), $next = $(".prev", this),
			$a = $cont.children("a"), len = $a.length, v=o.vnum;
			if(len<v){return false;}
			$cont.prepend($a.slice(len-v-1+1).clone(true)).append($a.slice(0,v).clone(true));
			o.start += v;
			var curr = o.start;

			var interval = null, a_dir = o.isH ? "marginLeft":"marginTop", c_dir = "left",
			aSize = o.isH ? $a.outerWidth(true) : $a.outerHeight(true), contDS = o.isH ? "width" : "height",
			itemLength = $cont.children("a").size();
			$cont.css(contDS, itemLength*aSize).css(a_dir, -(curr*aSize));

			var isOver = true;

			if(o.auto){
				$cont.hover(function(){
					clearInterval(interval);
				}, function(){
					if(c_dir == "left"){
						interval = setInterval(function(){ roll(curr+o.snum)}, o.pause);
					}else if(c_dir == "right"){
						interval = setInterval(function(){ roll(curr-o.snum)}, o.pause);
					}
				});
			}
			if($prev){
				$prev.click(function(){
					if(o.auto){clearInterval(interval)};
					if(isOver==true){roll(curr-o.snum, o.uspd);c_dir = "right";};
					if(o.auto){interval = setInterval(function(){ roll(curr-o.snum)}, o.pause)};
				});
			}
			if($next){
				$next.click(function(){
					if(o.auto){clearInterval(interval)};
					if(isOver==true){roll(curr+o.snum, o.uspd); c_dir = "left";};
					if(o.auto){interval = setInterval(function(){ roll(curr+o.snum)}, o.pause)};
				});
			}
			if(o.auto){ interval = setInterval(function(){ roll(curr+o.snum)}, o.pause);}
			function roll(to, spd){
				if(isOver){
					var spd = spd || o.nspd
					isOver = false;
					if(to<=o.start-v-1){
							$cont.css(a_dir, -((v+(len-v)+curr)*aSize)+"px");
							curr = (v+(len-v)+curr)-o.snum;
					}else if(to>=itemLength-v+1) {
							$cont.css(a_dir, -( (v-(itemLength-v-curr)) * aSize ) + "px" );
							curr = (v-(itemLength-v-curr))+o.snum;
					}else curr = to;

					$cont.animate(
							a_dir == "marginLeft" ? {"marginLeft": -(curr*aSize) } : {"marginTop": -(curr*aSize) } , spd, function(){isOver = true;}
					);
				}
				return false;
			};

		});
	}
})(jQuery);

/**
 * 增加字体变化效果
 */

  function doZoom(size) {
 	  $('.Zoom').css({fontSize:size+'px'});
 	  if(size==18)
 	  {
 			$(".ft-18").addClass("hover").siblings().removeClass("hover");
 	  }else
 	 {
 			$(".ft-14").addClass("hover").siblings().removeClass("hover");
 	 }

  }

function changeFontSize(t){ //改变字号
    var tosmall = ($(t).attr('id')=='font-normal')?true:false;
    if(tosmall && $(t).hasClass('on')) return;
    $('.tools .on').removeClass('on');
    $(t).addClass('on');
    $.cookie(COOKIE_PRE+'font',tosmall?'fs-small':'fs-big',{domain:COOKIE_DOMAIN,path:COOKIE_PATH,expires:300});
    $('#maincontent').removeClass(tosmall?'fs-big':'fs-small').addClass(tosmall?'fs-small':'fs-big');
}

function holdPic(){//控制内容区域的的图片大小并为过大的图片添加查看原图
    var options = {
        imageLoading:IMG_URL+'js/lib/lightBox/lightbox-ico-loading.gif',
        imageBtnPrev:IMG_URL+'js/lib/lightBox/lightbox-btn-prev.gif',
        imageBtnNext:IMG_URL+'js/lib/lightBox/lightbox-btn-next.gif',
        imageBtnClose:IMG_URL+'js/lib/lightBox/lightbox-btn-close.gif',
        imageBlank:IMG_URL+'js/lib/lightBox/lightbox-blank.gif'
    };
    $('#maincontent').find('img').each(function(){
        var img = this;
        if (img.width>580) {
            img.style.width = '580px';
            $(img).removeAttr('height');
            var aTag = document.createElement('a');
            aTag.href = img.src;
            $(aTag).addClass('bPic')
                .insertAfter(img).append(img)
                .lightBox(options);
        }
    });
}


//加载完毕后执行，客服服务
$(document).ready(function() {
    $(function() {
        $(window).scroll(function() {
            if ($(window).scrollTop()) {
                $("#f_right").css({
                    "top": ($(window).scrollTop() + 250) + "px"
                });
            }
        });
        $("#picShow").picshow();
        $(".tabs").tabs({meth:"click"});
        $("#pcont").pcont({
            snum:4
        });
        //默认的情况自动变化
        if($.cookie(COOKIE_PRE+'font') && $.cookie(COOKIE_PRE+'font')=='fs-big'){
            $('#font-normal').removeClass('on');
            $('#font-big').addClass('on');
            $('#maincontent').addClass('fs-big');
        }
        //图片过大处理
        holdPic();
    });
});

(function(){
	$.fn.tabs = function(o){
		var o = $.extend({meth:"hover"}, o||{})
		return this.each(function(){
			var $menu = $(this).find(".tab-menu").children("li").find("a"), $cont = $(this).find(".tab-cont").children(".cont");
			$menu.each(function(i){
				if(o.meth == "click"){
					$(this).click(function(){ toggle(i) });
				}else if(o.meth == "hover"){
					$(this).hover(function(){ toggle(i) });
				}
			});
			function toggle(i){
				$menu.removeClass("hover");
				$menu.eq(i).addClass("hover");
				$cont.removeClass("hover");
				$cont.eq(i).addClass("hover");
			}
		});
	}
})(jQuery);


//图片翻页
(function(){
	$.fn.fanpic = function(o){
		var o = $.extend({
			vnum:5,
			snum:3,
			awidth:201
		}, o||{});

		return this.each(function(){
			var $cont = $(".pic-list", this);
			var NUM_LI =o.snum;
			var $flash1_li = $cont.children("li");
			var $flash1_ul = $cont;
			var $flash1_next = $(".r_next", this);
			var $flash1_prev = $(".r_prev", this);
			var flash1_li_num = $flash1_li.length;
			var flash1_li_width =o.awidth;//$flash1_li.outerWidth()+5;
			var flash1_ul_width = flash1_li_num * flash1_li_width;
			var mar_left = flash1_li_width * NUM_LI;
			var ul_margin_left = parseFloat($flash1_ul.css("margin-left"));
			var flash1_page1 = Math.ceil(flash1_ul_width/mar_left);
			var flash1_page = flash1_page1;
			$flash1_ul.width(flash1_ul_width);
			$flash1_next.click(function(){
				if(flash1_page > 1){
					flash1_page -= 1;
					$flash1_ul.animate({marginLeft:ul_margin_left -= mar_left});
					$flash1_prev.animate({"opacity":1}).css({"cursor":"pointer"});
					if(flash1_page == 1){
						$flash1_next.animate({"opacity":0.2}).css({"cursor":"default"});
					};
				}else{
					return false;
				};
			});
			$flash1_prev.click(function(){
				if(flash1_page < flash1_page1){
					flash1_page += 1;
					$flash1_ul.animate({marginLeft:ul_margin_left += mar_left});
					$flash1_next.animate({"opacity":1}).css({"cursor":"pointer"});
					if(flash1_page == flash1_page1){
						$flash1_prev.animate({"opacity":0.2}).css({"cursor":"default"});
					};
				}else{
					return false;
				};
			});
		});
	}
})(jQuery);

//相册控件
(function(){
	$.fn.pcont = function(o){
		var o = $.extend({
			snum:5,
			pause:5000,
			spd:500,
			fspd:500,
			method: "fade",
			auto:false
		}, o);

		return this.each(function(){
			var $sprev = $(".sprev", this), $snext = $(".snext", this), $bprev = $(".bprev", this), $bnext = $(".bnext", this),
			$nav = $(".pc-nav .nav-wrap", this),
			$cont = $(".pc-cont ul>li", this), $info = $(".pc-info ul>li", this),
            $close = $('.close'),
			$nava = $nav.children("a"), len = $nava.length, aSize = $nava.outerWidth(true), navbS = o.snum*aSize;
			$contHeight = $(".pc-cont ul", this).height();
			$nav.css("width", len*aSize+10), $(".pc-nav .nav-box", this).css("width", navbS);
			$contWrap = $(".pc-cont ul", this);

			var index = 0, interval = null, cml;
			if(len*aSize > navbS){
				$sprev.click(function(){

					if(o.auto) clearInterval(interval);
					cml = Math.abs(parseFloat($nav.css("marginLeft")));
					if(cml < aSize){
						$nav.animate({"marginLeft": 0}, o.spd);
					}else if(cml > 0){
						$nav.animate({"marginLeft": "+="+aSize}, o.spd);
					}
					if(o.auto){ auto();}
				});
				$snext.click(function(){
					if(o.auto) clearInterval(interval);
					cml = Math.abs(parseFloat($nav.css("marginLeft")));
					if((len*aSize-cml-navbS) < aSize){
						$nav.animate({"marginLeft": "-"+(len*aSize-navbS)}, o.spd);
					}else if(cml <= ((len-o.snum)*aSize)){
						$nav.animate({"marginLeft": "-="+aSize}, o.spd);
					}
					if(o.auto){ auto();}
				});
			}
            $close.click(function(){
                if($('#end')){
                    $('#end').fadeOut(o.spd);
                }
                $cont.css({'opacity':1});
            });
			$bprev.click(function(){
				if(o.auto) clearInterval(interval);
				if(index>0){
                    roll(index-1);
                }
				if(o.auto){ auto();}
                pre_next_title(index);
				return false;
			});
			$bnext.click(function(){
				if(o.auto) clearInterval(interval);
				if(index<(len-1)){roll(index+1);}
				if(o.auto){ auto();}
                pre_next_title(index);
				return false;
			});
			$nava.each(function(i){
				$(this).click(function(){
					if(o.auto) clearInterval(interval);
					roll(i);
					if(o.auto){ auto();}
					return false;
				});
			});
            function pre_next_title(i){
//                $cont.css({'opacity':1});
                $('#end').hide();
                if(index<=0){
                    $bprev.attr('title','已经到达第一张');
                }else{
                    $bprev.attr('title','上一张');
                }
                if(index>=(len-1)){
                    $bnext.attr('title','已经到达最后一张');
                    if($('#end')){
                        var _offset = $contWrap.offset();
                        var _top = _offset.top+($cont.height()/2)-$('#end').height()/2;
                        var _left = _offset.left+($cont.width()/2)-$('#end').width()/2;
                        $('#end').attr('style', "left:"+_left+"px; top:"+_top+"px;");
                        $('#end').show(o.spd);
//                        $cont.css({'opacity':0.5});
                    }
                }else{
                    $bnext.attr('title','下一张');
                }
            }
			function auto(){
				interval = setInterval(function(){ roll(index==(len-1) ? 0 : (index+1))}, o.pause);
			}
			function roll(i){
				cml = Math.abs(parseFloat($nav.css("marginLeft")));
				if((i+1)*aSize <= cml){
					$nav.animate({"marginLeft": "-"+(i*aSize)}, o.spd);
				}else if((i+1)*aSize > (cml+navbS)){
					$nav.animate({"marginLeft": "-"+((i+1)*aSize-navbS)}, o.spd);
				}
				$nava.removeClass("hover");
				$nava.eq(i).addClass("hover");
				if(o.method == "fade") {
					$cont.hide();
                    if($cont.eq(i).children("a").children("img").attr('data-src')){
                        $cont.eq(i).children("a").children("img").attr('src',$cont.eq(i).children("a").children("img").attr('data-src'));
                        $cont.eq(i).children("a").children("img").attr('data-src','');
                    }
					$cont.eq(i).fadeIn(o.fspd);
				} else if(o.method == "slide") {
					$contWrap.animate({
						"margin-top": i * -$cont.height()
					});
				}

				$info.hide();
				$info.eq(i).show();
				index = i;
			}
			/*init*/
			if(o.auto){ auto(); }
			$nava.eq(index).addClass("hover");
			$info.eq(index).show();
		});
	};
})(jQuery);

$(function(){
  // 文档就绪
  //客户服务页面，论坛置顶、精华切换
	$(".year a").hover(function(){
		$(this).addClass("hover").siblings().removeClass("hover");
		var a_index = $(".year a").index($(this));
		$(".year_pic .picon").eq(a_index).show().siblings().hide();
	});

	$(".pic-list li a").hover(function(){
		$(this).addClass("hover").find(".bg").show();
	},function(){
		$(this).removeClass("hover").find(".bg").hide();

	})

//主导航2级导航
	$(".top_nav .main a").mouseenter(function() {
	    $(".top_nav .main a").removeClass("s_hover n_hover");
	    $(this).addClass("s_hover").parent().siblings().children().addClass('n_hover');
	    var a_index = $(".top_nav .main a").index($(this));
	    if (a_index === 0) {
	    	$(".sub_nav").slideUp('fast');
	    } else {
	        $(".sub_nav").slideDown('fast');
	        $(".sub_nav .sub").eq(a_index - 1).show().siblings().hide();
	    }
	});
    $(".top_nav,.sub_nav .sub").mouseleave(function() {
	    $(".top_nav .main a").removeClass("s_hover n_hover");
	    $(".sub_nav").slideUp('fast');
	});

//会员中心侧导航
	$(".side-menu li").hover(function(){
		$(this).addClass("on").siblings().removeClass("on");
	},function(){
		$(this).removeClass("on");
	})
});

function divselect(divselectid,inputselectid) {
	var inputselect = $(inputselectid);
	var ul = $(divselectid+" ul");
	$(divselectid+" cite").click(function(){
		if(ul.css("display")=="none"){
			ul.slideDown("fast");
		}else{
			ul.slideUp("fast");
		}
		 event.stopPropagation();
	});
	$(divselectid+" li a").click(function(){
		var txt = $(this).text();
		$(divselectid+" cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		$(divselectid+" ul").hide();

	});
	$(divselectid+" li a:eq(0)").click();

	/*$(document).click(function(event) {
		ul.slideUp("fast");
	});*/
};



//jquery 页面加载结束
//方法: pageMethod
function pageMethod()
{
    var obj=this;
    obj.resetTotal();
    obj.reloadpage("1",obj.list_class);
    obj.page(); //生成页码
    ready2go.call(obj);
}
//方法:ready2go
function ready2go()
{
    var obj=this;
    $("#"+obj.page_obj_id+" a").live("click",function()
    { //点击页码的时候跳到相应页
        obj.target_p=parseInt($(this).attr("p"));
        if($(this).attr("c")){
            obj.list_class = $(this).attr("c");
        }
        if($("#"+obj.list_obj_id+"_top").html()){
            $("html,body").animate({scrollTop: $("#"+obj.list_obj_id+"_top").offset().top},300);
        }else{
            $("html,body").animate({scrollTop: $('.location').offset().top},300);
        }
        if(!$(this).attr("q")){
            gotopage.call(obj,obj.target_p);
        }
    })

}
// 方法: showClass
function showClass(list,x,pDiv,pSize,pagenav){
    var pObj=new jsPage(list,x,pDiv,pSize,pagenav);
    pageMethod.call(pObj);
    $(".year").removeClass('thisyear');
    $('#'+x).addClass('thisyear');
}
// 方法: jsPage
function jsPage(list_id,list_class,page_obj_id,pagesize,pagenav)
{
    // list_id 结果集UL的id
    // list_class 要显示的类别
    // page_id 存放页码的id
// pagesize 每页显示多少条
    this.list_obj_id=list_id;
    this.list_Obj=$("#"+list_id);
    this.li=$("#"+list_id+" li");
    this.li.hide();
    this.page_obj_id=page_obj_id;
    this.page_obj=$("#"+page_obj_id); //存放页码的div
    this.list_class=list_class; // 类别
    this.pagenav=pagenav;
    if(list_class=="all")
    {
        this.results=this.li.length; // 总记录数等于所有记录
    }
    else
    {
        this.results=$("#"+list_id+" li."+list_class).length; // 总记录数等于指定类别的li数
    }

    this.totalpage; // 总页数
    this.pagesize=pagesize; //每页记录数
    this.cpage=1; //当前页,默认显示第一页
    this.count;
    this.target_p;
    this.curcount;
    this.outstr= ""; // 输出页码html
}//jsPage结束
//方法: gotopage
function gotopage(target){
    this.cpage = target;        //把页面计数定位到第几页
    this.page();
    this.reloadpage(target,this.list_class);
}
//给对象jsPage 增加函数 reloadpage
jsPage.prototype.reloadpage=function(p,resultType)
{
    this.li.hide();
    var __i = 1;

    for(var i=this.pagesize*p-this.pagesize;i<this.pagesize*p;i++)
    {
        if(resultType=="all")
        {
            $("#"+this.list_obj_id+" li .number").eq(i).attr('class','').addClass('number').addClass('num'+__i);
            __i++;
            if(__i>this.pagesize){
                __i =1;
            }
            this.li.eq(i).show();
        }else
        {
            $("#"+this.list_obj_id+" li."+resultType+" .number").eq(i).attr('class','').addClass('number').addClass('num'+__i);
            __i++;
            if(__i>this.pagesize){
                __i =1;
            }
            $("#"+this.list_obj_id+" li."+resultType).eq(i).show();
        }
    }
    if(!this.totalpage){
        if(!$('#isempty').html()){
            $("#"+this.list_obj_id).append("<p id='isempty'>没有找到相应的内容</p>");
        }else{
            $('#isempty').fadeIn();
        }
    }else{
        $('#isempty').hide();
    }
}
//给对象jsPage 增加函数 resetTotal
jsPage.prototype.resetTotal=function()
{
    if(this.results==0){
        this.totalpage=0;
        this.cpage=0;
    }else if(this.results<=this.pagesize)
    {
        this.totalpage=1;
    }
    else if(parseInt(this.results/this.pagesize)==1)
    {
        this.totalpage=2;
    }
    else if(parseInt(this.results/this.pagesize)>1 && this.results%this.pagesize==0){
        this.totalpage=this.results/this.pagesize;
    }
    else
    {
        this.totalpage=parseInt(this.results/this.pagesize)+1;
    }
}//resetTotal()
//jsPage 对象增加函数 page
jsPage.prototype.page=function()
{
    if(this.totalpage<=10)
    {        //总页数小于十页   页码以十页为单位
        for (this.count=1;this.count<=this.totalpage;this.count++)
        {
            if(this.count!=this.cpage)
            {
                this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+this.count+"' >"+this.count+"</a>";
            }else
            {
                this.outstr = this.outstr + "<a class='hover'>"+this.count+"</a>";
            }
        }
    }
    if(this.totalpage>10)
    {        //总页数大于十页
        if(parseInt((this.cpage-1)/10) == 0)
        {
            for (this.count=1;this.count<=10;this.count++)
            {
                if(this.count!=this.cpage)
                {
                    this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+this.count+"' c='"+this.list_class+"' >"+this.count+"</a>";
                }
                else
                {
                    this.outstr = this.outstr + "<a class='hover'>"+this.count+"</a>";
                }
            }
            this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+this.count+"' c='"+this.list_class+"' >»</a>";
        }
        else if(parseInt((this.cpage-1)/10) == parseInt(this.totalpage/10))
        {
            this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+(parseInt((this.cpage-1)/10)*10)+"' c='"+this.list_class+"' >«<\/a>";
            for (this.count=parseInt(this.totalpage/10)*10+1;this.count<=this.totalpage;this.count++)
            {
                if(this.count!=this.cpage)
                {
                    this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+this.count+"' c='"+this.list_class+"' >"+this.count+"</a>";
                }
                else
                {
                    this.outstr = this.outstr + "<a class='hover'>"+this.count+"</a>";
                }
            }
        }
        else
        {
            var lastP;
            this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+(parseInt((this.cpage-1)/10)*10)+"' c='"+this.list_class+"' >«<\/a>";
            for (this.count=parseInt((this.cpage-1)/10)*10+1;this.count<=parseInt((this.cpage-1)/10)*10+10;this.count++)
            {
                if(this.count!=this.cpage)
                {
                    this.outstr = this.outstr + "<a href='javascript:void(0)' p='"+this.count+"' c='"+this.list_class+"' >"+this.count+"</a>";
                }
                else
                {
                    this.outstr = this.outstr + "<a class='hover'>"+this.count+"</a>";
                }
                if(this.count==this.totalpage)
                {
                    lastP="";
                }
                else
                {
                    lastP="<a href='javascript:void(0)' p='"+(this.count+1)+"' c='"+this.list_class+"' >»</a>";
                }
            }
            this.outstr = this.outstr + lastP;
        }
    }
    if(!this.pagenav){
        if(this.cpage>1){
            var _prev_p = "<a class='prev' href='javascript:void(0)' p='"+(this.cpage-1)+"' c='"+this.list_class+"' >《</a>";
        }else{
            var _prev_p = "<a class='prev' href='javascript:void(0)' p='1' c='"+this.list_class+"' q='first' >《</a>";
        }
        if(this.cpage<this.totalpage){
            var _next_p = "<a class='next' href='javascript:void(0)' p='"+(this.cpage+1)+"' c='"+this.list_class+"' >》</a>";
        }else{
            var _next_p = "<a class='next' href='javascript:void(0)' p='"+(this.totalpage)+"' c='"+this.list_class+"' q='last' >》</a>";
        }
        document.getElementById(this.page_obj_id).innerHTML = "<div>"+_prev_p+"<span id='info'>共"+this.totalpage+"页 第"+this.cpage+"页<\/span>" + this.outstr + _next_p+"<\/div>";
    }else{
        if(this.totalpage){
            this.outstr = "<span id='info'>共"+this.totalpage+"页 第"+this.cpage+"页<\/span>";
        }else{
            this.outstr = "<span id='info'></span>";
        }
        if(this.cpage>1){
            this.outstr += "<a class='prev' href='javascript:void(0)' p='"+(this.cpage-1)+"' c='"+this.list_class+"' >《</a>";
        }else{
            this.outstr += "<a class='prev prev_nomore' href='javascript:void(0)' p='1' c='"+this.list_class+"' q='first' >《</a>";
        }
        if(this.cpage<this.totalpage){
            this.outstr += "<a class='next' href='javascript:void(0)' p='"+(this.cpage+1)+"' c='"+this.list_class+"' >》</a>";
        }else{
            this.outstr += "<a class='next next_nomore' href='javascript:void(0)' p='"+(this.totalpage)+"' c='"+this.list_class+"' q='last' >》</a>";
        }
        document.getElementById(this.page_obj_id).innerHTML = this.outstr;
    }
    this.outstr = "";
}


function showdsz(){
    if($('.dsz_list').css('display')=='none'){
        $('.pbd').removeClass('pbd-dszdh2');
        $('.dsz_art').hide();
        $('.dsz_list').fadeIn();
        if(typeof(contentid)!='undefined'){
            $('#speech_'+contentid).removeClass('now').addClass('now');
            $('#speech_'+contentid).attr('target','_self');
            $('#speech_'+contentid).unbind('click').removeAttr('onclick')
            $('#speech_'+contentid).click(function(){
                return showdsz();
            });
        }
    }else{
        if($('.dsz_art').html()){
            $('.pbd').addClass('pbd-dszdh2');
            $('.dsz_list').hide();
            $('.dsz_art').fadeIn();
        }
    }
    return false;
}

    (function($){
        $.fn.extend({
            tabChange:function(options){
                var defaults = {
                    isClick:false,
                    isHover:true,
					childLi:".tab-ul ",//tab选项卡
					childContent:".tab-contentbox",//tab内容
					hoverClassName:"hover"//选中当前选项卡的样式
                };
                var options = $.extend(defaults,options);
                this.each(function(){
                    var o = options;
                    var obj = $(this);
                    var oLi = $(o.childLi,obj);
                    var oDiv = $(o.childContent,obj);
                    var Timer;
                    var oLiClick = function(){
                        oLi.eq(0).addClass(o.hoverClassName);
                        oDiv.eq(0).show();
                        oLi.click(function(){
                            var index = oLi.index(this);
                            $(oLi[index]).addClass(o.hoverClassName).siblings().removeClass(o.hoverClassName);
                            oDiv.fadeOut().hide();
                            $(oDiv[index]).fadeIn().show();
                            
                        })
                    };
                    var oLiHover = function(){
                        oLi.eq(0).addClass(o.hoverClassName);
                        oDiv.eq(0).show();
                        oLi.mouseenter(function(){
                                var index = oLi.index(this);
                                $(oLi[index]).addClass(o.hoverClassName).siblings().removeClass(o.hoverClassName);
                                oDiv.hide();
                                $(oDiv[index]).show();
                        });
                    };

                    if(o.isClick==true)
                    {
                        oLiClick();
                    }
                    else if(o.isHover==true)
                    {
                        oLiHover();
                    }

                })
            }
        });
    })(jQuery);

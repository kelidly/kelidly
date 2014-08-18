/*  
    http://www.dailycoding.com/ 
*/
(function ($) {
	
	var $targetDiv,$imageTag,$this
	
    $.fn.imageLens = function (options) {

        var defaults = {
            lensSize: 100,
            borderSize: 3,
            borderColor: "#888"
        };
        var options = $.extend(defaults, options);
        var lensStyle = "background-position: 0px 0px;width: " + String(options.lensSize) + "px;height: " + String(options.lensSize)
            + "px;float: left;display: none;cursor:Move;border-radius: " + String(options.lensSize / 2 + options.borderSize)
            + "px;border: " + String(options.borderSize) + "px solid " + options.borderColor 
			+ ";margin-top:" +String(-12)+"px"
		    + ";margin-left:" +String(-12)+ "px"

            + ";background-repeat: no-repeat;position: absolute;";

        return this.each(function () {
            obj = $(this);
			$this = $(this);

            var offset = $(this).offset();

            // Creating lens
			//var target = $(this).parent().attr("style","lenStyle");
            var target = $("<div style='" + lensStyle + "' class='" + options.lensCss + "'></div>").appendTo($(".glass"));
            $targetDiv = target;
			//target.addClass("#product");
		    var targetSize = target.size();

            // Calculating actual size of image
            var imageSrc = options.imageSrc ? options.imageSrc : $(this).attr("src");
            var imageTag = "<img style='display:none;' src='" + imageSrc + "' />";
            $imageTag = $(imageTag);
            var widthRatio = 0;
            var heightRatio = 0;

            $(imageTag).load(function () {
                widthRatio = $(this).width() / obj.width();
                heightRatio = $(this).height() / obj.height();
            }).appendTo($(".glass"));

            target.css({ backgroundImage: "url('" + imageSrc + "')" });

            target.mousemove(setPosition);
            $(this).mousemove(setPosition);

            function setPosition(e) {
                
                var leftPos = parseInt(e.pageX - offset.left);
                var topPos = parseInt(e.pageY - offset.top);

                if (leftPos  < 0 || topPos  < 0 || 
				leftPos > obj.width() || topPos > obj.height()) {
                    target.hide();
                }
                else {
                    target.show();

                    leftPos = String(((e.pageX - offset.left) * widthRatio - target.width() / 2) * (-1));
                    topPos = String(((e.pageY - offset.top) * heightRatio - target.height() / 2) * (-1));
                    target.css({ backgroundPosition: leftPos + 'px ' + topPos + 'px' });

                    leftPos = String(e.pageX - target.width() / 2);
                    topPos = String(e.pageY - target.height() / 2);
                    target.css({ left: leftPos + 'px', top: topPos + 'px' });
                }
            }
        });
    };
	
	$.fn.imageLens.unbind = function () {
		  $this.unbind("mousemove");
		  $(".glass").find("img").remove();
		  $targetDiv.unbind("mousemove");
		   $targetDiv.remove();
	}
	
	
})(jQuery);
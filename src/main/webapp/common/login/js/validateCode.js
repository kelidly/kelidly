/*--------------------------------------------------|
| ValidateCode 1.00 | company PCS                   |
|---------------------------------------------------|
| Copyright (c) 2009 chenbin                        |
|                                                   |
| This script can be used freely as long as all     |
| copyright messages are intact.                    |
|                                                   |
| Updated: 17.03.2009                               |
|--------------------------------------------------*/

function ValidateCode(url,width,height,num,name) {
	this.url = url;
 	this.width = width;
 	this.height = height;
 	this.num = num;
 	this.name = name;
}

ValidateCode.prototype.setUrl = function(url) {
 	this.url = url;
}

ValidateCode.prototype.setWidth = function(width) {
 	this.width = width;
}

ValidateCode.prototype.setHeight = function(height) {
 	this.height = height;
}

ValidateCode.prototype.setNum = function(num) {
 	this.num = num;
}

ValidateCode.prototype.setName = function(name) {
 	this.name = name;
}

ValidateCode.prototype.applyTo = function(imgId) {
	var img=document.getElementById(imgId);
 	if (img) {
 		var params = "";
 		params = Math.random();
 		if (this.width) {
 			params += '&width='+this.width;
 		}
 		if (this.height) {
 			params += '&height='+this.height;
 		}
 		if (this.num) {
 			params += '&num='+this.num;
 		}
 		if (this.name) {
 			params += '&name='+this.name;
 		}
 		img.src = this.url + '?' + params;
 	}
}
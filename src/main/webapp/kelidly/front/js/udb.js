var udb = {
	login:function(){
        if(self!=top){
            top.location.href=self.location.href;
        }
        UDB.sdk.QLogin.ajaxOpenWithSaveToken('/auth/udb', '/auth/udb?xparam=1',
            '/auth/udb?cancel=1');
	},
	logout:function(returnUrl){
		var backUrl = location.href;
		if(returnUrl){
			backUrl = returnUrl;
		}
		location.href = "http://"+window.location.host+"/udb/logout?backUrl="+encodeURIComponent(backUrl);
	},
	reg:function(){
		location.href = "https://udb.yy.com/register.do?appid=5036&url="+encodeURIComponent(location.href);
	},
	loginForYasi:function(path){
        var url = "http://"+window.location.host + path;
        UDB.sdk.QLogin.ajaxOpenWithSaveToken('/auth/udb?redirect=' + encodeURIComponent(url), '/auth/udb',
            '/auth/udb?cancel=1');
	},
	regForYasi:function(courseId,adv){
		var advParam = '';
		if(adv != ''){
			advParam = "&adv=" + adv;
		}
		
		var url = "http://"+window.location.host+ "/buyOfficialCourse/order?id=" + courseId;
		location.href = "https://udb.yy.com/register.do?appid=5036&url=" + encodeURIComponent(url) + advParam;
	},
	regForYasiVideo:function(path){
		var url = "http://"+window.location.host+ path;
		location.href = "https://udb.yy.com/register.do?appid=5036&url=" + encodeURIComponent(url);
	},
	loginForMustLogin:function(path){
		if(self!=top){
            top.location.href=self.location.href;
        }
		var url = "http://"+window.location.host + path;
        UDB.sdk.QLogin.ajaxOpenWithSaveToken('/auth/udb?redirect=' + encodeURIComponent(url), '/auth/udb',
            '/udb/cancel4mustlogin');
	}
};

function crossLogin(json){
	if(json != ''){
		var data = eval("(" + json + ")");
		$(".unlogin").hide()
		$(".logined").show();
		$(".userinfo").html(data.passport);
		$(".userinfo").attr("href","/myinfo?uid="+$.trim(data.uid));
		
		// 往JS的全局变量中写 isLogined 让JS 感知登录
		try{
			isLogined = true;
		}catch(e){}
		// 往JS的全局变量中写 isTeacher 让JS 感知讲师身份
		try{
			isTeacher = data.authType == 1 || data.authType == 3;
		}catch(e){}
	}
}
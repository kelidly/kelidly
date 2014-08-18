$(document).ready(function(){
	$("#userName").focus();
	drawValidateCode();
});



function checkLogin(){
	var vcode = $('#VALIDATE_CODE').val();
	if(vcode.length == 0){
		alert("请填写验证码");
		return false;
	}
	var account = $('#userName').val();
	if(account.length == 0){
		alert("用户名不能为空");
		return false;
	}
	var pwd = $('#pwd').val();
	if(pwd.length == 0){
		alert("密码不能为空");
		return false;
	}
	return true;
}

function resetText(){
	$('#ACCOUNT').val('');
	$('#PASSWORD').val('');
	$('#VALIDATE_CODE').val('');
}

function drawValidateCode() {
	var vc = new ValidateCode('/rdt/common/login/js/validateCode.jsp',58,18,4);
	vc.applyTo('validateCode');
}
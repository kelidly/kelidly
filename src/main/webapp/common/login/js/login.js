$(document).ready(function(){
	$("#userName").focus();
	drawValidateCode();
});



function checkLogin(){
	var vcode = $('#VALIDATE_CODE').val();
	if(vcode.length == 0){
		alert("����д��֤��");
		return false;
	}
	var account = $('#userName').val();
	if(account.length == 0){
		alert("�û�������Ϊ��");
		return false;
	}
	var pwd = $('#pwd').val();
	if(pwd.length == 0){
		alert("���벻��Ϊ��");
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
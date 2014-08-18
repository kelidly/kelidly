/*var location = (window.location+'').split('/'); 
var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
var url = basePath + '/js/xxx.js';
var web_domain = 'http://127.0.0.1:8081/Test2';*/
// close layer when click-out
document.onclick = mclose; 



//验证留言表单
function comment_check() {
if ( document.form1.name.value == '' ) {
window.alert('请输入姓名^_^');
document.form1.name.focus();
return false;}

if ( document.form1.email.value.length> 0 &&!document.form1.email.value.indexOf('@')==-1|document.form1.email.value.indexOf('.')==-1 ) {
window.alert('请设置正确的Email地址，如:webmaster@Junww.com');
document.form1.email.focus();
return false;}

if(document.form1.qq.value.search(/^([0-9]*)([.]?)([0-9]*)$/)   ==   -1)   
      {   
  window.alert("QQ只能是数字^_^");   
document.form1.qq.focus();
return false;}

if ( document.form1.content.value == '' ) {
window.alert('请输入内容^_^');
document.form1.content.focus();
return false;}

if ( document.form1.verycode.value == '' ) {
window.alert('请输入验证码^_^');
document.form1.verycode.focus();
return false;}

return true;}


//提示框
function note_info(info, evt) {
    var iHeight = parseInt(document.documentElement.scrollHeight);
    var _event = evt ? evt : evt.event;
    var divx;
    var divy;
    var scrollHeight = document.documentElement.scrollTop - parseInt('60');
    document.getElementById('op_result').style.top = _event.clientY + scrollHeight + 'px';
    document.getElementById('op_result').style.left = _event.clientX + 'px';
    $("#op_result").attr("class", "box_cue_yellow");
    $("#op_result").html(info);
    $("#op_result").animate({opacity: 'show'}, 'slow');
    setTimeout("$('#op_result').animate({opacity:'hide'},'slow');", 3000);
}

//产品留言
function product_words(p_id) {
	var user_name = $("#user_name").val();
	var user_email = $("#user_email").val();
	var user_content = $("#user_content").val();
	var user_tel = $("#user_tel").val();
	if (user_name == '' || user_email == '' ||
		user_tel =='' || user_content=='') {
		alert("请填写完整的信息");
	}else {
		var location = (window.location+'').split('/'); 
		var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
		var path = basePath + '/product/words';
		$("#myform")[0].reset();
		$.post(path+'',{productId: p_id,guest: user_name,tel: user_tel,email: user_email,content: user_content},
				function(msg){
			if (msg == 'success') {
				alert("提交成功！");
			}else {
				alert("提交失败!");
			}
		});
	}

}
//显示更多评论
function more_gift_comment(gift_id) {
    var page_num = $("#page_num").val();
    var new_page_num = parseInt(page_num) + 1;
    $("#page_num").val(new_page_num);
    $.post(web_domain + '/servlet/AjaxServlet', {ajcode: 1006, gift_id: gift_id, page_num: page_num}, function(msg) {
        if (msg == 'no_record') {
            $("#more_comment").html("<img src='images/icon-comment.png' />没有更多了:)");
        } else {
            $("#comment_list").append(msg);
        }
    });
}
//评论
function comment(product_id) {
    var comment_content = $("#comment_content").val();
    var user_name = $("#user_name").val();
    if (user_name == '' || comment_content == '') {
        alert("请填写完整的回复信息！");
    } else {
        $("#comment_content").val('');
        $.post('servlet/AjaxServlet', {ajcode: 1001, product_id: product_id, user_name: user_name, comment_content: comment_content},
			   function(msg) {
            $("#comment_list").append(msg);
        });
        $("#is_open").val('0');
        show_comment();
    }

}

//公司留言
function submit_company_words() {
	var user_name = $("#name").val();
	var user_company = $("#company").val();
	var user_email = $("#email").val();
	var user_content = $("#content").val();
	var user_tel = $("#tel").val();
	if (user_name == '' || user_email == '' ||
		user_tel =='' || user_content=='') {
		alert("请填写完整的信息");
	}else {
		
		var location = (window.location+'').split('/'); 
		var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
		var path = basePath + '/about/words';
		$("#myform")[0].reset();
		$.post(path+'',{guest: user_name,company: user_company,tel: user_tel,email: user_email,content: user_content},
				function(msg){
			if (msg == 'success') {
				alert("提交成功！");
				
			}else {
				alert("提交失败!");
			}
		});
	}

}
//显示更多评论
function more_comment(product_id) {
    var page_num = $("#page_num").val();
    var new_page_num = parseInt(page_num) + 1;
    $("#page_num").val(new_page_num);
    $.post(web_domain + '/servlet/AjaxServlet', {ajcode: 1002, product_id: product_id, page_num: page_num}, function(msg) {
        if (msg == 'no_record') {
            $("#more_comment").html("<img src='images/icon-comment.png' />没有更多了:)");
        } else {
            $("#comment_list").append(msg);
        }
    });
}
//使用问答优惠券
function change_used(answer_id, fromuser) {
    $("#used_name").html("已使用");
    $.post(web_domain + '/info/ajax.php', {ajcode: 1003, answer_id: answer_id, fromuser: fromuser}, function(msg) {
        if (msg == 'success') {
            $("#used_name").html("已使用");
        }
    });
}
//使用抽奖优惠券
function change_used_cj(record_id, fromuser) {
    $("#used_name").html("已使用");
    $.post(web_domain + '/info/ajax.php', {ajcode: 1004, record_id: record_id, fromuser: fromuser}, function(msg) {
        if (msg == 'success') {
            $("#used_name").html("已使用");
        }
    });
}
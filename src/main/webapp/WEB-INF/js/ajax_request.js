var web_domain = 'http://127.0.0.1:8081/Test2';
function resizeImg(which, w) {

    var block = document.getElementById(which);
    var imgs = block.getElementsByTagName("img");
    for (var i = 0; i < imgs.length; i++) {
        var ow = imgs[i].width;
        var oh = imgs[i].height;
        var hw = oh / ow;
        if (ow > w) {
            imgs[i].width = w;
            imgs[i].height = w * hw;
        }
    }
}

//批量删除列表
function comment_gift(gift_id) {
    var comment_content = $("#comment_content").val();
    var user_name = $("#user_name").val();
    if (user_name == '' || comment_content == '') {
        alert("请填写完整的回复信息！");
    } else {
        $("#comment_content").val('');
        $.post( '/servlet/AjaxServlet', {ajcode: 1005, gift_id: gift_id, user_name: user_name, comment_content: comment_content},
        		function(msg) {
            $("#comment_list").append(msg);
        });
        $("#is_open").val('0');
        show_comment();
    }

}
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
//显示评论框
function show_comment() {
    var is_open = $("#is_open").val();
    if (is_open == '1') {
        var display_value = "block";
        $("#is_open").val('0');
    } else {
        var display_value = "none";
        $("#is_open").val('1');
    }
    $("#comment_div").css("display", display_value);

}
//评论
function comment_gift(gift_id) {
    var comment_content = $("#comment_content").val();
    var user_name = $("#user_name").val();
    if (user_name == '' || comment_content == '') {
        alert("请填写完整的回复信息！");
    } else {
        $("#comment_content").val('');
        $.post( '/servlet/AjaxServlet', {ajcode: 1005, gift_id: gift_id, user_name: user_name, comment_content: comment_content},
        		function(msg) {
            $("#comment_list").append(msg);
        });
        $("#is_open").val('0');
        show_comment();
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
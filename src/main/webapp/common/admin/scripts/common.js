/*var location = (window.location+'').split('/'); 
var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
var url = basePath + '/js/xxx.js';
var web_domain = 'http://127.0.0.1:8081/Test2';*/

//类型修改
function editType(url,type_id) {
	var id = 'edit' + type_id;
    var editObj = $("#"+id);
    var editVar = editObj.val();

	var str = "";
	$.ajax({
		type : "POST",
		url : url,
//		预期服务器返回的数据类型
		dataType : "text",
		//默认值: "application/x-www-form-urlencoded"。发送信息至服务器时内容编码类型
		contentType : "application/x-www-form-urlencoded;utf-8",
		//contentType : "application/json;utf-8",
		async:false, 
		
		data : {
			type:editVar,
			id:type_id
			},
		//data : "id="+type_id+"&type="+editVar,
	
		success : function(data){
			
			//str = data;
			if(data == 'success'){
				alert("修改成功！");
				$("#editNoteHint").html("修改成功");
			}else{
				alert("修改失败！");
				$('#editNoteHint').html("目前暂无数据，请等待更新。。。");
			}
			return
			
		}
	});
	

	function error(XMLHttpRequest, textStatus, errorThrown)
    {
          // 通常情况下textStatus和errorThown只有其中一个有值 
         alert("返回错误！");
    }


}

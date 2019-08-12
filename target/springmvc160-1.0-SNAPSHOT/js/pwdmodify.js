var oldpassword = null;
var newpassword = null;
var rNewPassword = null;
var saveBtn = null;

$(function(){
	oldpassword = $("#oldpassword");
	newpassword = $("#newpassword");
    rNewPassword = $("#reNewPassword");
	saveBtn = $("#save");
	
	oldpassword.next().html("*");
	newpassword.next().html("*");
    rNewPassword.next().html("*");
	
	oldpassword.on("blur",function(){
		var oldPwd =oldpassword.val().trim();
		if(oldPwd==null || oldPwd==""){
            validateTip(oldpassword.next(), {"color": "red"}, imgNo + " 原密码不能为空", false);
        }else {
            $.ajax({
                type: "POST",
                url: "/user/updatePwd.do",
                data: {oldPassword: oldPwd},
                success: function (data) {
                    if (data == "true") {//旧密码正确
                        validateTip(oldpassword.next(), {"color": "green"}, imgYes, true);
                    } else if (data == "false") {//旧密码输入不正确
                        validateTip(oldpassword.next(), {"color": "red"}, imgNo + " 原密码输入不正确", false);
                    }
                },
                error: function (data) {
                    //请求出错
                    validateTip(oldpassword.next(), {"color": "red"}, imgNo + " 请求错误", false);
                }
            });
        }
		
	}).on("focus",function(){
		validateTip(oldpassword.next(),{"color":"#666666"},"* 请输入原密码",false);
	});
	
	newpassword.on("focus",function(){
		validateTip(newpassword.next(),{"color":"#666666"},"* 密码长度必须是大于6小于20",false);
	}).on("blur",function(){
		if(newpassword.val() != null && newpassword.val().length > 6
				&& newpassword.val().length < 20 ){
			validateTip(newpassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(newpassword.next(),{"color":"red"},imgNo + " 密码输入不符合规范，请重新输入",false);
		}
	});


    rNewPassword.on("focus",function(){

		validateTip(rNewPassword.next(),{"color":"#666666"},"* 请输入与上面一致的密码",false);
	}).on("blur",function(){

		if(rNewPassword.val() != null && rNewPassword.val().length > 6
				&& rNewPassword.val().length < 20 && newpassword.val() == rNewPassword.val()){
			validateTip(rNewPassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(rNewPassword.next(),{"color":"red"},imgNo + " 两次密码输入不一致，请重新输入",false);
		}
	});
	
	
	saveBtn.on("click",function(){
		oldpassword.blur();
		newpassword.blur();
        rNewPassword.blur();
		if(oldpassword.attr("validateStatus") == "true" 
			&& newpassword.attr("validateStatus") == "true"
			&& rNewPassword.attr("validateStatus") == "true"){
			if(confirm("确定要修改密码？")){
				$("#userForm").submit();
			}
		}
		
	});
});
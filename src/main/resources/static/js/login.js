var loginFormValidate = $("#loginForm").validate({
	rules : {
		email : {
			required : true,
			email : true
		},
		password : {
			required : true
		}
	},
	messages : {
		email : {
			required : "이메일을 입력하세요.",
			email : "이메일 형식에 어긋납니다."
		},
		password : {
			required : "비밀번호를 입력하세요"
		}
	}
});

var registrationFormValidate = $("#registrationForm").validate({
	rules : {
		email : {
			required : true,
			email : true
		},
		password : {
			required : true
		},
		re_password : {
			required : true,
			equalTo : "#password"
		},
		company : {
			required : true
		}
	},
	messages : {
		email : {
			required : "이메일을 입력하세요.",
			email : "이메일 형식에 어긋납니다."
		},
		password : {
			required : "비밀번호를 입력하세요"
		},
		re_password : {
			required : "비밀번호를 한번 더 입력 하세요",
			equalTo : "비밀번호가 일치하지 않습니다."
		},
		company : {
			required : "고객사명을 입력하세요"
		}
	}
});

$("#registration_form").submit(function(event) {
	event.preventDefault();
	
	if(registrationFormValidate.form() == true) {
		$.post(getContextPath() + "/registration", $("#registrationForm").serialize())
		.done(function(data) {
			alert(data.msg);
			
			if (data.result == "ok") {
				$(location).attr("href", getContextPath() + "/");
			}
		}).fail(function() {
			alert("알 수 없는 오류!");
		}, "json");
	}
});

$("#logout").click(function(event) {
	event.preventDefault();
	
	if(confirm("로그아웃 하시겠습니까?")) {
		var fr = document.logoutForm;
		fr.submit();
	}
});
var project_registration_form_validate = $("#project_registration_form").validate({
	rules : {
		admin_email : {
			required : true,
			email : true
		},
		project_id : {
			required : true
		}
	},
	messages : {
		admin_email : {
			required : "빌링 계정 메일 주소를 입력하세요.",
			email : "이메일 형식에 어긋납니다."
		},
		project_id : {
			required : "프로젝트 아이디를 입력하세요"
		}
	}
});

$("#project_registration_form").submit(function(event) {
	event.preventDefault();

	if(project_registration_form_validate.form() == true) {
		$.post(getContextPath() + "/project_registration", $("#project_registration_form").serialize())
		.done(function(data) {
			alert(data.msg);
			
			if (data.result == "ok") {
				location.reload();
			}
		}).fail(function() {
			alert("알 수 없는 오류!");
		}, "json");
	}
});
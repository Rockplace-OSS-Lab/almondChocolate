$('#management_modal').on('show.bs.modal', function(event) {
	var target = $(event.relatedTarget);
	var user_seq = target.data('seq');
	var status = target.data('status');

	var modal = $(this);
	
	modal.find('#user_seq').val(user_seq);
	modal.find('#status').val(status).prop('selected', true);
});

$('#update_account_submit').click(function() {
	$.post(getContextPath() + "/management/update_account", $("#update_account_form").serialize())
	.done(function(data) {
		alert(data.msg);
		
		location.reload();
	}).fail(function() {
		alert("알 수 없는 오류!");
	}, "json");
});

// 빌링 어카운트 관리 모달
$('#billing_account_modal').on('show.bs.modal', function(event) {
	var target = $(event.relatedTarget);
	
	var billing_account_seq = target.data('billingaccountseq');
	var billing_account = target.data('billingaccount');
	var admin_email = target.data('adminemail');

	var modal = $(this);
	
	modal.find('#billing_account_seq').val(billing_account_seq);
	modal.find('#billing_account').val(billing_account);
	modal.find('#admin_email').val(admin_email);

});

$('#billing_account_submit').click(function() {
	if($('#billing_account_seq').val().length > 0) {
		$.post(getContextPath() + "/management/update_billing_account", $("#billing_account_form").serialize())
		.done(function(data) {
			alert(data.msg);
			
			location.reload();
		}).fail(function() {
			alert("알 수 없는 오류!");
		}, "json");
	} else {
		$.post(getContextPath() + "/management/add_billing_account", $("#billing_account_form").serialize())
		.done(function(data) {
			alert(data.msg);
			
			location.reload();
		}).fail(function() {
			alert("알 수 없는 오류!");
		}, "json");
	}
});
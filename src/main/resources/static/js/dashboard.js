$('#dashboard_search_btn').click(function() {
	$.post(getContextPath() + "/dashboard/invoice", $("#dashboard_search_form").serialize())
	.done(function(data) {
		$('#invoice_rows').html(data);
	}).fail(function() {
		alert("서버에 연결할 수 없습니다!");
	});
});

$( ".searchDate" ).datepicker({
	dateFormat: 'yy-mm-dd'
});
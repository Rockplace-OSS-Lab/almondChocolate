$('#dashboardSearchBtn').click(function() {
	event.preventDefault();

	var fr = document.dashboardSearchForm;
	fr.action="/dashboards";
	fr.method="POST";
	fr.submit();

	/*
	 * $.post(getContextPath() + "/dashboards",
	 * $("#dashboardSearchForm").serialize()) .done(function(data) {
	 * $('#invoice_rows').html(data); }).fail(function() { alert("서버에 연결할 수
	 * 없습니다!"); });
	 */
});

$(".searchDate").datepicker({
	dateFormat : 'yy-mm-dd'
});

function goPage(currentPage) {

	var fr = document.dashboardSearchForm;
	fr.currentPage.value = currentPage;
	fr.action="/dashboards";
	fr.method="POST";
	fr.submit();

}
/**
 * 구글 차트 관련
 */

if($("#dashboard_chart_area").length > 0) {
	google.charts.load('current', {'packages':['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawDashboardChart);
	
	function drawDashboardChart() {
		// column chart로 월별 사용요금 표시
		$.post(getContextPath() + "/dashboard/chartData", "type=bar&" + $("#dashboard_search_form").serialize())
		.done(function(json) {
			var data = new google.visualization.DataTable(json);
			var chart = new google.charts.Bar(document.getElementById('bar_chart'));
			
			var options = {
					};
			
		    chart.draw(data, options);
		}).fail(function() {
			alert("월별 사용요금을 표시할 수 없습니다!");
		}, "json");
		
		$.post(getContextPath() + "/dashboard/chartData", "type=donut&" + $("#dashboard_search_form").serialize())
		.done(function(json) {
			var data = new google.visualization.DataTable(json);
			var chart = new google.visualization.PieChart(document.getElementById('donut_chart'));
						
			var options = {
					pieHole: 0.4
					};
			
		    chart.draw(data, options);
		}).fail(function() {
			alert("리소스별 사용요금을 표시할 수 없습니다!");
		}, "json");

	}
}
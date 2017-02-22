/**
 * 구글 차트 관련
 */

if($("#dashboardChartArea").length > 0) {
	google.charts.load('current', {'packages':['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawDashboardChart);
	
	function drawDashboardChart() {
		// column chart로 월별 사용요금 표시
		$.post("/dashboards/chartData", "type=bar&" + $("#dashboardSearchForm").serialize())
		.done(function(json) {
			var data = new google.visualization.DataTable(json);
			var chart = new google.charts.Bar(document.getElementById('barChart'));
			
			var options = {
					};
			
		    chart.draw(data, options);
		}).fail(function() {
			alert("월별 사용요금을 표시할 수 없습니다!");
		}, "json");
		
		$.post("/dashboards/chartData", "type=donut&" + $("#dashboardSearchForm").serialize())
		.done(function(json) {
			var data = new google.visualization.DataTable(json);
			var chart = new google.visualization.PieChart(document.getElementById('donutChart'));
						
			var options = {
					pieHole: 0.4
					};
			
		    chart.draw(data, options);
		}).fail(function() {
			alert("리소스별 사용요금을 표시할 수 없습니다!");
		}, "json");

	}
}
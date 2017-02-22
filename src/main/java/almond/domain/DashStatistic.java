package almond.domain;

public class DashStatistic {

	private String month;
	private String total_cost;

	public DashStatistic() {

	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}

	@Override
	public String toString() {
		return "DashStatistic [month=" + month + ", total_cost=" + total_cost + "]";
	}

}

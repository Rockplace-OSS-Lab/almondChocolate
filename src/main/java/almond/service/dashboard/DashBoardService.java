package almond.service.dashboard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import almond.domain.DashBoard;
import almond.domain.Project;
import almond.domain.SearchDashboard;
import almond.repository.DashBoardRepository;
import almond.util.JsonHelper;

@Service
public class DashBoardService {
	
	@Autowired
	DashBoardRepository dashBoardRepository;
	
	/*public List<DashBoard> getDashboard(String accountId){
		return dashBoardRepository.findByAccountId(accountId);
	}*/
	
	public Page<DashBoard> getDashboard(SearchDashboard searchDashboard){
		int currentPage = searchDashboard.getCurrentPage()-1;
		String projectId = searchDashboard.getProjectId();
		String searchKeyword = "%"+searchDashboard.getSearchKeyword()+"%";
		String startDate = searchDashboard.getStartDate() == null ? "" : searchDashboard.getStartDate().toString();
		String endDate = searchDashboard.getEndDate() == null ? "" : searchDashboard.getEndDate().toString();
		
		PageRequest pageRequest = new PageRequest(currentPage, 10);
		Page<DashBoard> dashBoardList = null;
		
		if(projectId != null && !projectId.isEmpty()){
			if(searchDashboard.getSearchKeyword() != null && !searchDashboard.getSearchKeyword().isEmpty()){
				if(searchDashboard.getSearchType()!=null && searchDashboard.getSearchType().equals("measurement1") ){
					dashBoardList = dashBoardRepository.findByProjectIdAndMeasurement1LikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							projectId, searchKeyword, 
							startDate, endDate, pageRequest);
				}else if(searchDashboard.getSearchType()!=null && searchDashboard.getSearchType().equals("description")){
					dashBoardList = dashBoardRepository.findByProjectIdAndDescriptionLikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							projectId, searchKeyword, 
							startDate, endDate, pageRequest);
				}else{
					dashBoardList = dashBoardRepository.findByProjectIdAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							projectId, startDate, endDate, pageRequest);
				}
			}else{
				dashBoardList = dashBoardRepository.findByProjectId(projectId, pageRequest);
			}
			
		} else {
			if(searchDashboard.getSearchKeyword() != null && !searchDashboard.getSearchKeyword().isEmpty()){
				if(searchDashboard.getSearchType()!=null && searchDashboard.getSearchType().equals("measurement1") ){
					dashBoardList = dashBoardRepository.findByProjectIdInAndMeasurement1LikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							getProjectList(searchDashboard), searchKeyword, 
							startDate, endDate, pageRequest);
				}else if(searchDashboard.getSearchType()!=null && searchDashboard.getSearchType().equals("description")){
					dashBoardList = dashBoardRepository.findByProjectIdInAndDescriptionLikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							getProjectList(searchDashboard), searchKeyword, 
							startDate, endDate, pageRequest);
				}else{
					dashBoardList = dashBoardRepository.findByProjectIdInAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
							getProjectList(searchDashboard), startDate, endDate, pageRequest);
				}
			}else{
				dashBoardList = dashBoardRepository.findByProjectIdIn(getProjectList(searchDashboard), pageRequest);
			}
		}
		searchDashboard.settingPage(dashBoardList);
		
		return dashBoardList;
	}
	
	public List<String> getProjectList(SearchDashboard searchDashboard){
		List<String> projectList = new ArrayList<String>();
		for(Project project : searchDashboard.getProjectList()){
			projectList.add(project.getProjectId());
		}
		return projectList;
	}
	
	public String getChartData(Map<String, Object> params) {
		Calendar cal = Calendar.getInstance();
		TimeZone timeZone = cal.getTimeZone();
		
		params.put("tz", timeZone.getID());
		
		if(params.get("type").equals("bar")) {
			return getMonthlyCost();
		} else if(params.get("type").equals("donut")) {
			return getCostPerResource(params);
		}
		
		return "";
	}
	
	// 구글 차트용 월별 사용 요금
	public String getMonthlyCost() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> cols_array = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> cols = new HashMap<String, Object>();
		cols.put("id", "");
		cols.put("label", "Month");
		cols.put("pattern", "");
		cols.put("type", "string");
		cols_array.add(cols);
		
		Map<String, Object> cols2 = new HashMap<String, Object>();
		cols2.put("id", "");
		cols2.put("label", "Price");
		cols2.put("pattern", "");
		cols2.put("type", "number");
		cols_array.add(cols2);
		
		result.put("cols", cols_array);
		
		List<Map<String, Object>> rows_array = new ArrayList<Map<String,Object>>();
		
		List<Object[]> dashStringData = dashBoardRepository.getDashStatistic("00C7AF-773114-6DB700");
		
		for(Object[] statistic : dashStringData){
			List<Map<String, Object>> c_array = new ArrayList<Map<String,Object>>();
			Map<String, Object> c = new HashMap<String, Object>();
			
			Map<String, Object> month = new HashMap<String, Object>();
			
			month.put("v", statistic[0]);
			month.put("f", null);
			
			c_array.add(month);
			
			Map<String, Object> total_cost = new HashMap<String, Object>();
			
			total_cost.put("v", statistic[1]);
			total_cost.put("f", null);
			
			c_array.add(total_cost);
						
			c.put("c", c_array);
			
			rows_array.add(c);
		
		}
		result.put("rows", rows_array);
		
		return JsonHelper.convertMapToJson(result);
	}
	
	// 구글 차트용 월별 사용 요금
	private String getCostPerResource(Map<String, Object> params) {
		Calendar cal = Calendar.getInstance();
		TimeZone timeZone = cal.getTimeZone();
		
		params.put("tz", timeZone.getID());
		
		String year_month = String.valueOf(cal.get(Calendar.YEAR)) + "-" + String.format("%02d", cal.get(Calendar.MONTH) + 1);
		
		params.put("start_date", year_month + "-01");
		params.put("end_date", year_month + "-" + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Map<String, Object>> cols_array = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> cols = new HashMap<String, Object>();
		cols.put("id", "");
		cols.put("label", "Resource");
		cols.put("pattern", "");
		cols.put("type", "string");
		cols_array.add(cols);
		
		Map<String, Object> cols2 = new HashMap<String, Object>();
		cols2.put("id", "");
		cols2.put("label", "Price");
		cols2.put("pattern", "");
		cols2.put("type", "number");
		cols_array.add(cols2);
		
		result.put("cols", cols_array);
		
		List<Map<String, Object>> rows_array = new ArrayList<Map<String,Object>>();
		
		List<Object[]> dashStringData = dashBoardRepository.getResourceStatistic("00C7AF-773114-6DB700");
		
		for(Object[] statistics : dashStringData) {
			List<Map<String, Object>> c_array = new ArrayList<Map<String,Object>>();
			Map<String, Object> c = new HashMap<String, Object>();
			
			Map<String, Object> resource = new HashMap<String, Object>();
			
			resource.put("v", statistics[0]);
			resource.put("f", null);
			
			c_array.add(resource);
			
			Map<String, Object> total_cost = new HashMap<String, Object>();
			
			total_cost.put("v", statistics[1]);
			total_cost.put("f", null);
			
			c_array.add(total_cost);
						
			c.put("c", c_array);
			
			rows_array.add(c);
		}
		
		result.put("rows", rows_array);
		
		return JsonHelper.convertMapToJson(result);
	}
}

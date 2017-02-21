package almond.controller.dashboard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import almond.domain.DashBoard;
import almond.domain.Project;
import almond.domain.SearchDashboard;
import almond.domain.User;
import almond.service.dashboard.DashBoardService;
import almond.service.project.ProjectService;

@Controller
@RequestMapping("/dashboards")
public class DashBoardController {

	@Autowired
	DashBoardService dashBoardService;

	@Autowired
	ProjectService projectService;

	@GetMapping("")
	public String dashboard(Model model, SearchDashboard searchDashboard) {
		return processDashBoard(model, searchDashboard);
	}

	@PostMapping("")
	public String searchDashBoard(Model model, SearchDashboard searchDashboard) {
		return processDashBoard(model, searchDashboard);
	}
	
	private String processDashBoard(Model model, SearchDashboard searchDashboard){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Project> projectList = projectService.getProjects(user.getUserSeq());

		String projectId = searchDashboard.getProjectId();
		searchDashboard.setProjectList(projectList);

		if (projectList != null && projectList.size() > 0) {
			model.addAttribute("projectList", projectList);
		}

		if (projectId != null) {
			model.addAttribute("projectId", projectId);
		}

		if (projectId != null || (projectList != null && projectList.size() > 0)) {
			Page<DashBoard> dashBoardList = dashBoardService.getDashboard(searchDashboard);
			model.addAttribute("invoiceDetail", dashBoardList);
		}
		
		return "dashboard";
	}

	@PostMapping("/chartData")
	@ResponseBody
	public String getChartData(@RequestParam Map<String, Object> params) {
		return dashBoardService.getChartData(params);
	}
}

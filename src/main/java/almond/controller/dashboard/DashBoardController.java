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
    // TODO 특별한 이유가 없다면 접근제어자를 private으로 한다.
	@Autowired
	DashBoardService dashBoardService;

	@Autowired
	ProjectService projectService;

	// TODO Get과 Post가 같은 일을 하고 있는데 굳이 두 가지를 제공하는 이유가 있는가?
	@GetMapping("")
	public String dashboard(Model model, SearchDashboard searchDashboard) {
		return processDashBoard(model, searchDashboard);
	}

	@PostMapping("")
	public String searchDashBoard(Model model, SearchDashboard searchDashboard) {
		return processDashBoard(model, searchDashboard);
	}
	
	private String processDashBoard(Model model, SearchDashboard searchDashboard){
	    // TODO @Principal 애노테이션 활용해 구현
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// TODO 이후 모든 로직을 dashBoardService와 SearchDashboard 로직을 구현하도록 리팩토링한다.
		List<Project> projectList = projectService.getProjects(user.getUserSeq());

		String projectId = searchDashboard.getProjectId();
		searchDashboard.setProjectList(projectList);

		// TODO if 조건절 로직을 SearchDatashboard에서 구현하도록 리팩토링한다.
		if (projectList != null && projectList.size() > 0) {
			model.addAttribute("projectList", projectList);
		}

		// TODO if 조건절 로직을 SearchDatashboard에서 구현하도록 리팩토링한다.
		if (projectId != null) {
			model.addAttribute("projectId", projectId);
		}

		// TODO if 조건절 로직을 SearchDatashboard에서 구현하도록 리팩토링한다.
		if (projectId != null || (projectList != null && projectList.size() > 0)) {
			Page<DashBoard> dashBoardList = dashBoardService.getDashboard(searchDashboard);
			model.addAttribute("invoiceDetail", dashBoardList);
		}
		
		model.addAttribute("search", searchDashboard);
		
		return "dashboard";
	}

	@PostMapping("/chartData")
	@ResponseBody
	public String getChartData(@RequestParam Map<String, Object> params) {
		return dashBoardService.getChartData(params);
	}
}

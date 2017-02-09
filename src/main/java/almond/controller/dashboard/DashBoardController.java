package almond.controller.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import almond.domain.DashBoard;
import almond.service.dashboard.DashBoardService;

@Controller
@RequestMapping("/dashboards")
public class DashBoardController {
	
	@Autowired
	DashBoardService dashBoardService;

	@GetMapping()
	public String dashboard(Model model){
		
		String accountId = "00C7AF-773114-6DB700";
		List<DashBoard> dashBoardList = dashBoardService.getDashboard(accountId);
		
		model.addAttribute("projectList", dashBoardList);
		
		return "dashboard";
	}
}

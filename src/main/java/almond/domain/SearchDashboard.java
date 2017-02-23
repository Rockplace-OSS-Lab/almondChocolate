package almond.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class SearchDashboard extends Search {
	private String projectId;
	private List<Project> projectList;

	private int startPage = 1;
	private int currentPage = 1;
	private int totalPageCount = 1;

	private List<PageNumber> pages = new ArrayList<PageNumber>();

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void settingPage(Page<DashBoard> dashBoardList) {

		this.startPage = (dashBoardList.getNumber() / 10) * 10 + 1;
		this.totalPageCount = dashBoardList.getTotalPages();
		for (int i = startPage; i < startPage + 10; i++) {
			PageNumber num = new PageNumber();
			num.setPage(i);
			pages.add(num);
		}
	}

	public List<PageNumber> getPages() {
		return pages;
	}

	public void setPages(List<PageNumber> pages) {
		this.pages = pages;
	}

}

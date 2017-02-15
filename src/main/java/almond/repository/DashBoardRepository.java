package almond.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almond.domain.DashBoard;
import almond.domain.DashStatistic;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {
	public List<DashBoard> findByAccountId(String accountId);
	
	/*public List<DashBoard> findByProjectId(String projectId);
	
	public List<DashBoard> findByAccountIdAndByProjectId(String accountId, String projectId);
	*/
	@Query(value = "SELECT date_format(m.start_time, '%Y-%m') as month, m.cost as Total_cost from dash_board m where m.account_id = '00C7AF-773114-6DB700' ", nativeQuery = true)
	public List<String> getDashStatistic(); 
}
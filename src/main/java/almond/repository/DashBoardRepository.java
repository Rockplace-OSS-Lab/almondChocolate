package almond.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almond.domain.DashBoard;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {
	
	public Page<DashBoard> findByProjectId(String projectId, Pageable pageable);
	
	@Query("SELECT m FROM dash_board m WHERE m.project_id IN (?1)")
	public Page<DashBoard> findByProjectId(Collection<String> projectList, Pageable pageable);
	
	// public List<DashBoard> findByAccountIdAndByProjectId(String accountId, String projectId);
	
	@Query(value = "SELECT date_format(m.start_time, '%Y-%m') AS month, m.cost AS Total_cost FROM dash_board m WHERE m.account_id = ?1 ", nativeQuery = true)
	public List<Object[]> getDashStatistic(String accountId); 
	
	@Query(value = "SELECT m.description, SUM(m.cost) AS Total_cost FROM dash_board m WHERE m.account_id = ?1", nativeQuery = true)
	public List<Object[]> getResourceStatistic(String accountId);
}
package almond.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almond.domain.DashBoard;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {
	
	public Page<DashBoard> findByProjectId(String projectId, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdIn(List<String> projectList, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdAndMeasurement1Like(
			String projectId, String measurement1, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdAndMeasurement1LikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			String projectId, String measurement1, String startDate, String endDate, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdAndDescriptionLikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			String projectId, String description, String startDate, String endDate, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			String projectId, String startDate, String endDate, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdInAndMeasurement1LikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			List<String> projectList, String measurement1, String startDate, String endDate, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdInAndDescriptionLikeAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			List<String> projectList, String description, String startDate, String endDate, Pageable pageable);
	
	public Page<DashBoard> findByProjectIdInAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			List<String> projectList, String startDate, String endDate, Pageable pageable);
	
	@Query(value = "SELECT date_format(m.start_time, '%Y-%m') AS month, m.cost AS Total_cost FROM dash_board m WHERE m.account_id = ?1 ", nativeQuery = true)
	public List<Object[]> getDashStatistic(String accountId); 
	
	@Query(value = "SELECT m.description, SUM(m.cost) AS Total_cost FROM dash_board m WHERE m.account_id = ?1", nativeQuery = true)
	public List<Object[]> getResourceStatistic(String accountId);
}
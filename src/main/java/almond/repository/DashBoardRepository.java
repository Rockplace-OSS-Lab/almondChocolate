package almond.repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;

import almond.domain.DashBoard;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {
	public List<DashBoard> findByAccountId(String accountId);
	
	/*public List<DashBoard> findByProjectId(String projectId);
	
	public List<DashBoard> findByAccountIdAndByProjectId(String accountId, String projectId);
	*/
	
	
	
}
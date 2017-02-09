package almond.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import almond.domain.DashBoard;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {
	public List<DashBoard> findByAccountId(String accountId);
}
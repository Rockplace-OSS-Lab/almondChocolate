package almond.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import almond.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	public List<Project> findByProjectId(String projectId);
}

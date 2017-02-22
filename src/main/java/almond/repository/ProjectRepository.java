package almond.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import almond.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	public List<Project> findByProjectId(String projectId);

	// TODO 메소드 인자의 변수명을 i와 같이 명확하지 않은 변수명을 사용하지 않는다. 클래스, 변수 이름을 명확히 한다.
	public List<Project> findByUserUserSeq(Long i);
}

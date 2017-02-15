package almond.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almond.domain.Project;
import almond.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public List<Project> getProjects(){
		return projectRepository.findByProjectId("astute-charter-133923");
	}
}

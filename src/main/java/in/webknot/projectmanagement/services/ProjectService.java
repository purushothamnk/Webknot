package in.webknot.projectmanagement.services;


import in.webknot.projectmanagement.models.Project;
import in.webknot.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    public Project updateProject(Long id, Project project) {
        Project existingProject = getProjectById(id);
        // Update fields
        return projectRepository.save(existingProject);
    }

    public void updateProjectStatus(Long id, String status) {
        Project project = getProjectById(id);
        project.setStatus(status);
        projectRepository.save(project);
    }
}

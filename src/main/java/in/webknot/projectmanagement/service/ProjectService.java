package in.webknot.projectmanagement.service;


import in.webknot.projectmanagement.entity.Project;
import org.springframework.stereotype.Service;
import java.util.List;
@Service






    public interface ProjectService {
        Project createProject(Project project);
        Project updateProject(Long projectId, Project project);
        Project getProjectDetails(Long projectId);
        void deleteProject(Long projectId);
        List<Project> getAllProjects();
    }


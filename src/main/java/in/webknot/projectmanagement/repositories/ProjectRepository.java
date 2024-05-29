package in.webknot.projectmanagement.repositories;

import in.webknot.projectmanagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
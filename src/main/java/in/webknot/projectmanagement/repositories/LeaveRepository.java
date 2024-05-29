package in.webknot.projectmanagement.repositories;

import in.webknot.projectmanagement.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}

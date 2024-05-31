package in.webknot.projectmanagement.repository;

import in.webknot.projectmanagement.entity.ImportedEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportedEmployeeRepository extends JpaRepository<ImportedEmployee, Long> {


}
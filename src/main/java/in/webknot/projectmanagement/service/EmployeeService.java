package in.webknot.projectmanagement.service;



import in.webknot.projectmanagement.entity.Employee;
import in.webknot.projectmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;



public interface EmployeeService {
    void importEmployees(MultipartFile file);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
}

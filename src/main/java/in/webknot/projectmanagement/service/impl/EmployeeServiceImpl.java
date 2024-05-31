package in.webknot.projectmanagement.service.impl;

import in.webknot.projectmanagement.entity.Employee;
import in.webknot.projectmanagement.repository.EmployeeRepository;
import in.webknot.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void importEmployees(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Employee> employees = br.lines().skip(1).map(line -> {
                String[] fields = line.split(",");
                Employee employee = new Employee();
                employee.setName(fields[0]);
                employee.setEmail(fields[1]);
                employee.setTechStack(fields[2]);
                employee.setYearsOfExperience(Integer.parseInt(fields[3]));
                employee.setYearsOfExperienceInWebknot(Integer.parseInt(fields[4]));
                return employee;
            }).collect(Collectors.toList());
            employeeRepository.saveAll(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }
}

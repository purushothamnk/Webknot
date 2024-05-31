package in.webknot.projectmanagement.controller;

import com.opencsv.exceptions.CsvException;
import in.webknot.projectmanagement.entity.Employee;
import in.webknot.projectmanagement.service.EmployeeImportService;
import in.webknot.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    private EmployeeImportService employeeImportService;

    @Autowired
    private EmployeeService employeeService;
    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @PostMapping("/import-employees-csv")
    public ResponseEntity<String> importEmployeesFromCSV(@RequestParam("file") MultipartFile file) {
        try {
            employeeImportService.importEmployeesFromCSV(file);
            return new ResponseEntity<>("Employees imported successfully from CSV", HttpStatus.OK);
        } catch (IOException | CsvException e) {
            logger.severe("Failed to import employees from CSV: " + e.getMessage());
            return new ResponseEntity<>("Failed to import employees from CSV: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/import-employees-excel")
    public ResponseEntity<String> importEmployeesFromExcel(@RequestParam("file") MultipartFile file) {
        try {
            employeeImportService.importEmployeesFromExcel(file);
            return new ResponseEntity<>("Employees imported successfully from Excel", HttpStatus.OK);
        } catch (IOException e) {
            logger.severe("Failed to import employees from Excel: " + e.getMessage());
            return new ResponseEntity<>("Failed to import employees from Excel: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

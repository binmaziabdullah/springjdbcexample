package com.employee.springjdbcexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Employee> getAllEmployee() {

        List<Employee> employees = employeeRepo.getAllEmployee();

        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){

        Employee employee = employeeRepo.getEmployeeById(id);
        return employee;
    }

    @PostMapping
    public String empInsert(@RequestBody Employee employee) {

        int check = employeeRepo.insertEmployee(employee);
        return check == 1 ? "Record inserted Successfully" : "insertion failed";
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee) {
        int check = employeeRepo.updateEmployee(employee);

        return check == 1 ? "Record Updated Successfully" : "Update Operation Failed";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        int check = employeeRepo.deleteEmployee(id);

        return check == 1 ? "Record Deleted Successfully" : " Delete Operation Failed";
    }


}

package com.pedro.cruddemo.rest;

import com.pedro.cruddemo.entity.Employee;
import com.pedro.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee>  findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee theEmployeeById = employeeService.findById(id);

        if (theEmployeeById == null)
            throw new RuntimeException("Employee not found - " + theEmployeeById);
        return theEmployeeById;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee tempEmp = employeeService.findById(id);

        if (tempEmp == null)
            throw new RuntimeException("Employee id not found - " + id);
        employeeService.deleteById(id);

        return "Deleted employee id - " + id  ;
    }
}

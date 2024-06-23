package com.pedro.thymeleafdemo.controller;

import com.pedro.thymeleafdemo.entity.Employee;
import com.pedro.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // recuperar lista employees do db
        List<Employee> employees = employeeService.findAll();

        // adicionar ao model
        model.addAttribute("employees", employees);

        return "list-employees";
    }

}

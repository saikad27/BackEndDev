package com.example.__configuring_preauthorization_for_a_method_call.controller;

import com.example.__configuring_preauthorization_for_a_method_call.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.__configuring_preauthorization_for_a_method_call.service.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/book/{name}")
    public Employee book(@PathVariable String name){
        return employeeService.getEmployeeDetails(name);
    }
}

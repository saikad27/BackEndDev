package com.example.__configuring_preauthorization_for_a_method_call.service;

import com.example.__configuring_preauthorization_for_a_method_call.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    Map<String, Employee> employeeRecord = new HashMap<>();
    public EmployeeService(){
        employeeRecord.put("natalie",new Employee("Natalie Parker",List.of("Harry Potter","Lord of the rings"),List.of("MANAGER","READER")));
        employeeRecord.put("emma",new Employee("Emma Watson",List.of("Dead Poets Society"),List.of("HR")));
    }

    @PostAuthorize("returnObject.roles.contains('READER')")
    public Employee getEmployeeDetails(String name){
        return employeeRecord.get(name);
    }
}

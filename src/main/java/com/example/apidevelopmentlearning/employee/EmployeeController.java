package com.example.apidevelopmentlearning.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }


    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping(path = "/employees")
    public Employee addEmployees(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);

    }



}

package com.example.apidevelopmentlearning.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getEmployees(){

        List<Employee> employees = List.of(
                new Employee(1,"Hrushi","hrushi@gmail.com"),
                new Employee(2,"Mini","mini@gmail.com"));
            employeeRepository.saveAll(employees);

        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id) {

        Optional<Employee> byId = employeeRepository.findById(id);
        if(!byId.isPresent()){
            throw new IllegalStateException("Id is not present");
        }

        return employeeRepository.getById(id);
    }

    public Employee addEmployee(Employee employee) {

        if(employeeRepository.existsById(employee.getId())){
            throw new IllegalStateException("Id provide already exists");
        }
        employeeRepository.save(employee);

        return employee;

    }
}

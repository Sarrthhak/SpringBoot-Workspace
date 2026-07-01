package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository repo;



    // CREATE
    public String createEmployee(Employee emp){

        repo.save(emp);

        return "Employee Created Successfully";
    }




    // DISPLAY
    public List<Employee> displayEmployees(){

        return repo.findAll();

    }




    // RAISE SALARY
    public String raiseSalary(int id, int amount){


        Employee emp = repo.findById(id)
                .orElseThrow(
                () -> new RuntimeException("Employee not found")
                );


        emp.setSalary(
            emp.getSalary()+amount
        );


        repo.save(emp);


        return "Salary Raised Successfully";

    }

}
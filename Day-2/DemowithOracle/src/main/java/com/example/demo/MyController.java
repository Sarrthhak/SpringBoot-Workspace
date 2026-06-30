package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.example.demo.MyRepo;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
	@Autowired
	private MyRepo repository;
    // GET ALL
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/getAllEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }
    
    // ADD
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return "Employee added successfully";
    }
    
    // UPDATE
    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(
            @PathVariable int id,
            @RequestBody Employee newEmployee) {

        Optional<Employee> oldEmployee = repository.findById(id);

        if(oldEmployee.isPresent()) {

            Employee emp = oldEmployee.get();

            emp.setName(newEmployee.getName());
            emp.setSalary(newEmployee.getSalary());

            repository.save(emp);

            return "Employee updated successfully";
        }

        return "Employee not found";
    }
	
    //DELETE
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Optional<Employee> emp = repository.findById(id);

        if(emp.isPresent()) {

            repository.delete(emp.get());

            return "Employee deleted successfully";
        }

        return "Employee not found";
    }
}
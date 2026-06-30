package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyServices {
	@Autowired
	private MyRepo repo;
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	public Employee getEmployeeById(int id) {
	    return repo.findById(id)
	            .orElseThrow(() -> 
	                new EmployeeNotFoundException("Employee not found with id: " + id));
	}
	public String addEmployee(Employee employee) {
		repo.save(employee);
		return "Employee added successfully!";
	}
	public String updateEmployee(int id, Employee updatedEmployee) {
		Optional<Employee> existingEmp= repo.findById(id);
		if(existingEmp.isPresent()) {
			Employee emp= existingEmp.get();
			emp.setName(updatedEmployee.getName());
			emp.setAge(updatedEmployee.getAge());
			emp.setSalary(updatedEmployee.getSalary());
			emp.setDesig(updatedEmployee.getDesig());
			repo.save(emp);
			return "Employee Updated Successfully!!";
		}else {
				return "Employee not found with id: "+id;
		}
	}
	public String deleteEmployee(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Employee deleted Successfully";
		}else {
			return "Employee not found with id: "+id;
		}
	}
	public String deleteAllEmployees() {
		repo.deleteAll();
		return "All Data Deleted....";
	}
}

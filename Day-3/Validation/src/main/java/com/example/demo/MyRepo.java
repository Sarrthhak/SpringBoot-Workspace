package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Employee;
public interface MyRepo extends JpaRepository<Employee, Integer>{

}

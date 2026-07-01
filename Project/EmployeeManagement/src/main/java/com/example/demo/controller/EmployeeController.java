package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// Main Menu
	@GetMapping("/")
	public String home() {

		return "index";
	}

	// Open Create Page
	@GetMapping("/create")
	public String createPage() {

		return "create";
	}

	// Save Employee
	@PostMapping("/create")
	public String createEmployee(@ModelAttribute Employee employee, Model model) {

		service.createEmployee(employee);

		model.addAttribute("message", "Employee Created Successfully");

		return "continue";

	}

	// Display Employees
	@GetMapping("/display")
	public String displayEmployees(Model model) {

		model.addAttribute("employees", service.displayEmployees());

		return "display";

	}

	// Open Raise Salary Page
	@GetMapping("/raise")
	public String raisePage() {

		return "raise";
	}

	// Raise Salary
	@PostMapping("/raise")
	public String raiseSalary(@RequestParam int id, @RequestParam int amount, Model model) {

		try {

			service.raiseSalary(id, amount);

			model.addAttribute("message", "Salary Raised Successfully");

			return "continue";

		} catch (Exception e) {

			model.addAttribute("error", "Employee ID does not exist. Please enter a valid ID.");

			return "raise";

		}

	}

	// Exit Page
	@GetMapping("/exit")
	public String exit() {

		return "exit";
	}

}
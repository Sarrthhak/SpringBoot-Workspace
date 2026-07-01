package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String student(Model model) {

        model.addAttribute("title", "Student Details");

        model.addAttribute("name", "Sarthak Pipladiya");
        model.addAttribute("email", "sarthak@gmail.com");
        model.addAttribute("semester", "6th");
        model.addAttribute("college", "Lovely Professional University");

        return "dashboard";
    }
}
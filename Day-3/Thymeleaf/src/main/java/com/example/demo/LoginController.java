package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Optional<User> user = userRepo.findById(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
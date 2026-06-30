package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        boolean exists = repo.findByUsernameAndPassword(username, password).isPresent();

        if (exists) {
            model.addAttribute("username", username);
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String confirmPassword,
                         Model model) {

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            model.addAttribute("error", "Username and password cannot be empty");
            return "signup";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "signup";
        }

        if (repo.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username is already taken");
            return "signup";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        repo.save(newUser);

        model.addAttribute("success", "Registration successful! Please log in.");
        return "login";
    }
}
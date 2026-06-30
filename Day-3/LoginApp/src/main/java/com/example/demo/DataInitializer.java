package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            // Seed Admin User
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("password123");
            userRepository.save(admin);

            // Seed Regular User
            User user = new User();
            user.setUsername("user1");
            user.setPassword("password123");
            userRepository.save(user);

            System.out.println("--- Seeded default users into Oracle Database: 'admin' and 'user1' (password: password123) ---");
        }
    }
}

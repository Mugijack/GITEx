package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        // Logic to fetch users from a data source (e.g., database)
        // For simplicity, let's return a hardcoded list of users
        users.add(new User(1L, "user1", "user1@example.com"));
        users.add(new User(2L, "user2", "user2@example.com"));
        users.add(new User(3L, "user3", "user3@example.com"));
        return users;
    }
}

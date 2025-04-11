package com.astrotalk.astrology_booking.controller;

import com.astrotalk.astrology_booking.model.User;
import com.astrotalk.astrology_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}

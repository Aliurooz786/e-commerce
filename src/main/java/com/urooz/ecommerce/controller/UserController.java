package com.urooz.ecommerce.controller;

import com.urooz.ecommerce.dto.LoginRequest;
import com.urooz.ecommerce.dto.UserRequest;
import com.urooz.ecommerce.model.User;
import com.urooz.ecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        log.info("Fetching user by ID: {}", id);
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody UserRequest request) {
        log.info("Updating user with ID: {}, Data: {}", id, request);
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        log.info("Deleting user with ID: {}", id);
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
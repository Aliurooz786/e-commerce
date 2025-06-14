package com.urooz.ecommerce.service.impl;
import com.urooz.ecommerce.dto.LoginRequest;
import com.urooz.ecommerce.dto.UserRequest;
import com.urooz.ecommerce.model.User;
import com.urooz.ecommerce.repository.UserRepository;
import com.urooz.ecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return null;
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .role(request.getRole())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User loginUser(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        log.debug("UserServiceImpl - getUserById called with ID: {}", userId);
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(String userId, UserRequest request) {
        log.debug("UserServiceImpl - updateUser called for ID: {}", userId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            log.debug("User found: {}", user);

            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setPassword(request.getPassword());
            user.setRole(request.getRole());
            user.setUpdatedAt(new Date());

            User updatedUser = userRepository.save(user);
            log.debug("User updated: {}", updatedUser);
            return userRepository.save(user);
        }
        log.warn("User not found with ID: {}", userId);
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        log.debug("Deleting user with ID: {}", userId);
        userRepository.deleteById(userId);
    }
}
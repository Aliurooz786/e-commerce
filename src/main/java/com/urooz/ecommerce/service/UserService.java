package com.urooz.ecommerce.service;

import com.urooz.ecommerce.dto.LoginRequest;
import com.urooz.ecommerce.dto.UserRequest;
import com.urooz.ecommerce.model.User;

import java.util.List;

public interface UserService {

    User registerUser(UserRequest request);

    User loginUser(LoginRequest request);

    List<User> getAllUsers();

    User getUserById(String userId);

    User updateUser(String userId, UserRequest request);

    void deleteUser(String userId);
}
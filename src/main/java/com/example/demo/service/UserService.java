package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;

public interface UserService {
    User saveUser(User user, MultipartFile file);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
    User getUserByUsername(String username);
    User updateUser(User user, MultipartFile file);
}

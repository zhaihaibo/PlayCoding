package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(Integer id );
    int insertUser(User user);
    int deleteById(String id);
}

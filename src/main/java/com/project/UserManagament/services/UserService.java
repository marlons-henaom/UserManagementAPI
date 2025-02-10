package com.project.UserManagament.services;

import com.project.UserManagament.dto.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    List<User> getAllUsers();
}

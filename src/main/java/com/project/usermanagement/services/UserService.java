package com.project.usermanagement.services;

import com.project.usermanagement.dtos.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User updateUser(User user, Integer id);

    User updateUserActive(@RequestBody User user, Integer id);

    User updateUserDateBorn(@RequestBody User user, Integer id);

    void deleteUser(Integer id);

    User login(String email, String password);
}

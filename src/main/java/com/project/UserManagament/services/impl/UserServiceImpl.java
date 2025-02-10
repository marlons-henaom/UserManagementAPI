package com.project.UserManagament.services.impl;

import com.project.UserManagament.Entities.UserEntity;
import com.project.UserManagament.converters.UserConverter;
import com.project.UserManagament.dto.User;
import com.project.UserManagament.repositories.UserRepository;
import com.project.UserManagament.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User saveUser(User user) {
        UserEntity ue = userConverter.convertDTOtoEntity(user);
        ue = userRepository.save(ue);
        user = userConverter.convertEntitytoDTO(ue);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        for (UserEntity ue : users){
            User user = userConverter.convertEntitytoDTO(ue);
            userList.add(user);
        }
        return userList;
    }
}

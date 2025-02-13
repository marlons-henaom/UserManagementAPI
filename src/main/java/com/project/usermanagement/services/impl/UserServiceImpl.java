package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.DependencyConverter;
import com.project.usermanagement.entities.UserEntity;
import com.project.usermanagement.converters.UserConverter;
import com.project.usermanagement.dtos.User;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import com.project.usermanagement.repositories.UserRepository;
import com.project.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private DependencyConverter dependencyConverter;

    @Override
    public User saveUser(User user) {

        Optional<UserEntity> optue = userRepository.findByEmail(user.getEmail());
        if (optue.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("THE EMAIL EXISTS!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity ue = userConverter.convertDTOtoEntity(user);
        ue = userRepository.save(ue);
        user = userConverter.convertEntityDTO(ue);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        for (UserEntity ue : users){
            User user = userConverter.convertEntityDTO(ue);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User updateUser(User user, Integer id) throws BusinessException {
        Optional<UserEntity> optEn = userRepository.findById(id);
        User userDto = null;
        if (optEn.isPresent()){
            UserEntity ue = optEn.get();
            ue.setDateBorn(user.getDateBorn());
            ue.setActive(user.getActive());
            ue.setDependency(dependencyConverter.convertDTOtoEntity(user.getDependency()));
            userDto = userConverter.convertEntityDTO(ue);
            userRepository.save(ue);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_FOUND");
            errorModel.setMessage("USER NOT FOUND");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDto;
    }

    @Override
    public User updateUserActive(User user, Integer id) {
        Optional<UserEntity> optEn = userRepository.findById(id);
        User userDto = null;
        if (optEn.isPresent()){
            UserEntity ue = optEn.get();
            ue.setActive(user.getActive());
            userDto = userConverter.convertEntityDTO(ue);
            userRepository.save(ue);
        }

        return userDto;
    }

    @Override
    public User updateUserDateBorn(User user, Integer id) {
        Optional<UserEntity> optEn = userRepository.findById(id);
        User userDto = null;
        if (optEn.isPresent()){
            UserEntity ue = optEn.get();
            ue.setDateBorn(user.getDateBorn());
            userDto = userConverter.convertEntityDTO(ue);
            userRepository.save(ue);
        }

        return userDto;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmailAndPassword(email, password);
        User userDto = null;
        if(optionalUserEntity.isPresent()){
            userDto = userConverter.convertEntityDTO(optionalUserEntity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("EMAIL OR PASSWORD INCORRECT!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDto;
    }
}

package com.project.usermanagement.converters;

import com.project.usermanagement.entities.UserEntity;
import com.project.usermanagement.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private DependencyConverter dependencyConverter;

    @Autowired
    private ProfileConverter profileConverter;

    public UserEntity convertDTOtoEntity(User user){
        UserEntity ue = new UserEntity();
        ue.setId(user.getId());
        ue.setDateBorn(user.getDateBorn());
        ue.setEmail(user.getEmail());
        ue.setPassword(user.getPassword());
        ue.setActive(user.getActive());
        ue.setDependency(dependencyConverter.convertDTOtoEntity(user.getDependency()));
        return ue;
    }

    public User convertEntityDTO(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setDateBorn(userEntity.getDateBorn());
        user.setEmail(userEntity.getEmail());
        user.setActive(userEntity.getActive());
        user.setDependency(dependencyConverter.convertEntityDTO(userEntity.getDependency()));
        return user;
    }
}

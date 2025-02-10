package com.project.UserManagament.converters;

import com.project.UserManagament.Entities.UserEntity;
import com.project.UserManagament.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(User user){
        UserEntity ue = new UserEntity();
        ue.setDate_born(user.getDate_born());
        ue.setActive(user.getActive());
//        ue.setDependency(user.getDependency());
//        ue.setProfile(user.getProfile());
//        ue.setAssignments(user.getAssignments());
        return ue;
    }

    public User convertEntitytoDTO(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setDate_born(userEntity.getDate_born());
        user.setActive(userEntity.getActive());
//        user.setDependency(userEntity.getDependency());
//        user.setProfile(userEntity.getProfile());
//        user.setAssignments(userEntity.getAssignments());
        return user;
    }
}

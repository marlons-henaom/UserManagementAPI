package com.project.usermanagament.converters;

import com.project.usermanagament.entities.UserEntity;
import com.project.usermanagament.dtos.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(User user){
        UserEntity ue = new UserEntity();
        ue.setDateBorn(user.getDateBorn());
        ue.setEmail(user.getEmail());
        ue.setPassword(user.getPassword());
        ue.setActive(user.getActive());
        return ue;
    }

    public User convertEntityDTO(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setDateBorn(userEntity.getDateBorn());
        user.setEmail(userEntity.getEmail());
        user.setActive(userEntity.getActive());
        return user;
    }
}

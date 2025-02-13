package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.UserProfile;
import com.project.usermanagement.entities.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private ProfileConverter profileConverter;

    public UserProfileEntity convertDTOtoEntity(UserProfile userProfile){
        UserProfileEntity upe = new UserProfileEntity();
        upe.setUser(userConverter.convertDTOtoEntity(userProfile.getUser()));
        upe.setProfile(profileConverter.convertDTOtoEntity(userProfile.getProfile()));
        return upe;
    }

    public UserProfile convertEntityDTO(UserProfileEntity userProfileEntity){
        UserProfile userProfile = new UserProfile();
        userProfile.setId(userProfileEntity.getId());
        userProfile.setUser(userConverter.convertEntityDTO(userProfileEntity.getUser()));
        userProfile.setProfile(profileConverter.convertEntityDTO(userProfileEntity.getProfile()));
        return userProfile;
    }
}

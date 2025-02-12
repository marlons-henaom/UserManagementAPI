package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.entities.ProfileEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter {

    public ProfileEntity convertDTOtoEntity(Profile profile){
        ProfileEntity pe = new ProfileEntity();
        pe.setProfile(profile.getProfile());
        return pe;
    }

    public Profile convertEntityDTO(ProfileEntity profileEntity){
        Profile profile = new Profile();
        profile.setId(profileEntity.getId());
        profile.setProfile(profileEntity.getProfile());
        return profile;
    }
}

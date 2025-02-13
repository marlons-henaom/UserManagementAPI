package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.ProfileConverter;
import com.project.usermanagement.converters.UserProfileConverter;
import com.project.usermanagement.converters.UserConverter;
import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.dtos.User;
import com.project.usermanagement.dtos.UserProfile;
import com.project.usermanagement.entities.ProfileEntity;
import com.project.usermanagement.entities.UserEntity;
import com.project.usermanagement.entities.UserProfileEntity;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.repositories.ProfileRepository;
import com.project.usermanagement.repositories.UserProfileRepository;
import com.project.usermanagement.repositories.UserRepository;
import com.project.usermanagement.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserProfileConverter userProfileConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private ProfileConverter profileConverter;

    @Autowired
    private ExceptionService exceptionService;

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        Optional<UserEntity> existingUser = userRepository.findById(userProfile.getUser().getId());
        User usetDto = null;
        if (existingUser.isPresent()) {
            usetDto = userConverter.convertEntityDTO(existingUser.get());
        } else {
            throw exceptionService.buildNotFoundException("USER NOT FOUND");
        }

        Optional<ProfileEntity> existingProfile = profileRepository.findById(userProfile.getProfile().getId());
        Profile profileDto = null;
        if (existingProfile.isPresent()) {
            profileDto = profileConverter.convertEntityDTO(existingProfile.get());
        } else {
            throw exceptionService.buildNotFoundException("PROFILE NOT FOUND");
        }

        userProfile.setUser(usetDto);
        userProfile.setProfile(profileDto);
        UserProfileEntity upe = userProfileConverter.convertDTOtoEntity(userProfile);
        upe = userProfileRepository.save(upe);
        userProfile = userProfileConverter.convertEntityDTO(upe);
        return userProfile;
    }

    @Override
    public List<UserProfile> getAllUserProfile() {
        Iterable<UserProfileEntity> userProfiles = userProfileRepository.findAll();
        List<UserProfile> userProfileList = new ArrayList<>();
        for (UserProfileEntity upe : userProfiles){
            UserProfile userProfile = userProfileConverter.convertEntityDTO(upe);
            userProfileList.add(userProfile);
        }
        return userProfileList;
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile, Integer id) throws BusinessException {
        Optional<UserProfileEntity> optEn = userProfileRepository.findById(id);
        UserProfile userProfileDto = null;
        if (optEn.isPresent()){
            UserProfileEntity upe = optEn.get();
            upe.setProfile(profileConverter.convertDTOtoEntity(userProfile.getProfile()));
            upe.setUser(userConverter.convertDTOtoEntity(userProfile.getUser()));
            userProfileDto = userProfileConverter.convertEntityDTO(upe);
            userProfileRepository.save(upe);
        } else {
            throw exceptionService.buildNotFoundException("USER PROFILE NOT FOUND");
        }

        return userProfileDto;
    }

    @Override
    public void deleteUserProfile(Integer id) {
        userProfileRepository.deleteById(id);
    }

}

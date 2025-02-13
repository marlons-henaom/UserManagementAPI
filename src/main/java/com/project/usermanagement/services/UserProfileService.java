package com.project.usermanagement.services;

import com.project.usermanagement.dtos.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUserProfile();

    UserProfile updateUserProfile(UserProfile userProfile, Integer id);

    void deleteUserProfile(Integer id);
}

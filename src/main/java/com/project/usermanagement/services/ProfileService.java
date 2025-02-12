package com.project.usermanagement.services;

import com.project.usermanagement.dtos.Profile;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProfileService {

    Profile saveProfile(Profile profile);

    List<Profile> getAllProfile();

    Profile updateProfile(Profile profile, Integer id);

    void deleteProfile(Integer id);
}

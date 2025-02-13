package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.ProfileConverter;
import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.entities.ProfileEntity;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import com.project.usermanagement.repositories.ProfileRepository;
import com.project.usermanagement.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileConverter profileConverter;

    @Override
    public Profile saveProfile(Profile profile) {
        ProfileEntity pe = profileConverter.convertDTOtoEntity(profile);
        pe = profileRepository.save(pe);
        profile = profileConverter.convertEntityDTO(pe);
        return profile;
    }

    @Override
    public List<Profile> getAllProfile() {
        Iterable<ProfileEntity> profiles = profileRepository.findAll();
        List<Profile> profileList = new ArrayList<>();
        for (ProfileEntity pe : profiles){
            Profile profile = profileConverter.convertEntityDTO(pe);
            profileList.add(profile);
        }
        return profileList;
    }

    @Override
    public Profile updateProfile(Profile profile, Integer id) throws BusinessException {
        Optional<ProfileEntity> optEn = profileRepository.findById(id);
        Profile profileDto = null;
        if (optEn.isPresent()){
            ProfileEntity pe = optEn.get();
            pe.setProfile(profile.getProfile());
            profileDto = profileConverter.convertEntityDTO(pe);
            profileRepository.save(pe);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_FOUND");
            errorModel.setMessage("PROFILE NOT FOUND");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return profileDto;
    }

    @Override
    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }

}

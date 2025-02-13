package com.project.usermanagement.controllers;

import com.project.usermanagement.dtos.UserProfile;
import com.project.usermanagement.services.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfile> saveUserProfile(@Valid @RequestBody UserProfile userProfile){
        userProfile = userProfileService.saveUserProfile(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles(){
        List<UserProfile> userProfiles = userProfileService.getAllUserProfile();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile, @PathVariable Integer id){
        userProfile = userProfileService.updateUserProfile(userProfile, id);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Integer id){
        userProfileService.deleteUserProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

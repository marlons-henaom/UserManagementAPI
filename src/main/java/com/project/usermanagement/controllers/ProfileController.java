package com.project.usermanagement.controllers;

import com.project.usermanagement.dtos.Profile;
import com.project.usermanagement.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> saveProfile(@Valid @RequestBody Profile profile){
        profile = profileService.saveProfile(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles(){
        List<Profile> profiles = profileService.getAllProfile();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable Integer id){
        profile = profileService.updateProfile(profile, id);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Integer id){
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

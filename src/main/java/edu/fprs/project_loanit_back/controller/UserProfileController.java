package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.UserProfileDao;
import edu.fprs.project_loanit_back.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserProfileController {

    protected UserProfileDao userProfileDao;

    @Autowired
    public UserProfileController(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }


    //Get all user profiles return List of all user profiles
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileDao.findAll();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    //Get a user profile by ID / @param id The ID of the user profile / * @return The user profile if found
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Integer id) {
        Optional<UserProfile> userProfile = userProfileDao.findById(id);
        return userProfile
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Create a new user profile /@param userProfile The user profile to create /@return The created user profile
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile savedUserProfile = userProfileDao.save(userProfile);
        return new ResponseEntity<>(savedUserProfile, HttpStatus.CREATED);
    }

    //Update an existing user profile
    // @param id                 The ID of the user profile to update
    // @param userProfileDetails The updated user profile details
    // @return The updated user profile
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(
            @PathVariable Integer id,
            @RequestBody UserProfile userProfileDetails) {

        return userProfileDao.findById(id)
                .map(existingProfile -> {
                    existingProfile.setDescription(userProfileDetails.getDescription());
                    UserProfile updatedProfile = userProfileDao.save(existingProfile);
                    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a user profil /@param id The ID of the user profile to delete /@return No content response
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Integer id) {
        return userProfileDao.findById(id)
                .map(userProfile -> {
                    userProfileDao.delete(userProfile);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

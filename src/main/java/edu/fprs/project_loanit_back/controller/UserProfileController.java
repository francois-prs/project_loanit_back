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
    @GetMapping("/userprofile")
    public List<UserProfile> getAll() {
        return userProfileDao.findAll();
    }

    //Get a user profile by ID / @param id The ID of the user profile / * @return The user profile if found
    @GetMapping("userprofile/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable int id) {
        Optional<UserProfile> optionalUserProfile = userProfileDao.findById(id);

        if (optionalUserProfile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUserProfile.get(), HttpStatus.OK);

    }

    //Create a new user profile /@param userProfile The user profile to create /@return The created user profile
    @PostMapping("/userprofiles")
    public ResponseEntity<UserProfile> save(@RequestBody UserProfile userProfile) {
        userProfileDao.save(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    //Update an existing user profile
    // @param id                 The ID of the user profile to update
    // @param userProfileDetails The updated user profile details
    // @return The updated user profile
//    @PutMapping("/{id}")
//    public ResponseEntity<UserProfile> updateUserProfile(
//            @PathVariable Integer id,
//            @RequestBody UserProfile userProfileDetails) {
//
//        return userProfileDao.findById(id)
//                .map(existingProfile -> {
//                    existingProfile.setDescription(userProfileDetails.getDescription());
//                    UserProfile updatedProfile = userProfileDao.save(existingProfile);
//                    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
//                })
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    // Delete a user profil /@param id The ID of the user profile to delete /@return No content response
    @DeleteMapping("/userprofiles/{id}")
    public ResponseEntity<UserProfile> delete(@PathVariable Integer id) {

        Optional<UserProfile> optionalUserProfile = userProfileDao.findById(id);

        if (optionalUserProfile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userProfileDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

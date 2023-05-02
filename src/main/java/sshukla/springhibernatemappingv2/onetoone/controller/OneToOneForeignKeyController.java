package sshukla.springhibernatemappingv2.onetoone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.springhibernatemappingv2.onetoone.model.foreignkey.User;
import sshukla.springhibernatemappingv2.onetoone.model.foreignkey.UserProfile;
import sshukla.springhibernatemappingv2.onetoone.repo.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@RestController
@RequestMapping("/onetoone/v2/api")
public class OneToOneForeignKeyController {

    Logger LOGGER = LoggerFactory.getLogger(OneToOneForeignKeyController.class);

    private final UserRepo userRepo;
    private final UserProfileRepo userProfileRepo;

    public OneToOneForeignKeyController(UserRepo userRepo, UserProfileRepo userProfileRepo) {
        this.userRepo = userRepo;
        this.userProfileRepo = userProfileRepo;
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LOGGER.info("Controller.createUser() ---");
        user.setId(UUID.randomUUID().toString());
        UserProfile userProfile = user.getUserProfile();
        userProfile.setId(UUID.randomUUID().toString());
        user.setUserProfile(userProfile);
        return ResponseEntity.ok(userRepo.save(user));
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        LOGGER.info("Controller.updateUser() ---");
        User savedUser = userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("User Not Found!!!"));
        savedUser.setName(user.getName());
        savedUser.setUserProfile(user.getUserProfile());
        return ResponseEntity.ok(userRepo.save(savedUser));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser() {
        LOGGER.info("Controller.getAllUser() ---");
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") String userId) throws Throwable {
        LOGGER.info("Controller.getUserById() ---");
        return ResponseEntity.ok(userRepo.findById(userId).orElseThrow(() -> new Exception("User Not Found!!!!")));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable(value = "userId") String userId) {
        LOGGER.info("Controller.deleteUserById() ---");
        userRepo.deleteById(userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/userProfile/update")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile) {
        LOGGER.info("Controller.updateUserProfile() ---");
        UserProfile savedUserProfile = userProfileRepo.findById(userProfile.getId()).orElseThrow(() -> new RuntimeException("UserProfile Not Found!!!"));
        return ResponseEntity.ok(userProfileRepo.save(savedUserProfile));
    }

    @GetMapping("/userProfile/all")
    public ResponseEntity<List<UserProfile>> getAllUserProfile() {
        LOGGER.info("Controller.getAllEmployeeInfo() ---");
        return ResponseEntity.ok(userProfileRepo.findAll());
    }

    @GetMapping("/userProfile/{userProfileId}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable(value = "userProfileId") String userProfileId) throws Throwable {
        LOGGER.info("Controller.getUserProfileById() ---");
        return ResponseEntity.ok(userProfileRepo.findById(userProfileId).orElseThrow(() -> new Exception("UserProfile Not Found!!!!")));
    }

    // Todo: Not performing delete
    @DeleteMapping("/userProfile/{userProfileId}")
    public ResponseEntity<HttpStatus> deleteUserProfileById(@PathVariable(value = "userProfileId") String userProfileId) {
        LOGGER.info("Controller.deleteUserProfileById() ---");
        userProfileRepo.deleteById(userProfileId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}

package de.sep.calocalendar.controller;

import de.sep.calocalendar.api.UserProfileApiDelegate;
import de.sep.calocalendar.model.UserProfileModel;
import de.sep.calocalendar.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserProfileController implements UserProfileApiDelegate {

    @Autowired
    private UserProfileService service;

    @Override
    public ResponseEntity<Long> addUserProfile(UserProfileModel model) {
        return ResponseEntity.of(service.addUserProfile(model));
    }

    @Override
    public ResponseEntity<List<UserProfileModel>> getAllUserProfiles() {
        return ResponseEntity.of(service.getAllUserProfiles());
    }

    @Override
    public ResponseEntity<UserProfileModel> updateUserProfile(UserProfileModel model) {
        return ResponseEntity.of(service.updateUserProfile(model));
    }

    @Override
    public ResponseEntity<UserProfileModel> getUserProfileById(Long id) {
        return ResponseEntity.of(service.getUserProfileById(id));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        service.deleteUserProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

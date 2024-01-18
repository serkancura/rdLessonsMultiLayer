package com.rdLessons.multiLayerErrorHandling.controller;

import com.rdLessons.multiLayerErrorHandling.helpers.errorHandiling.ServiceException;
import com.rdLessons.multiLayerErrorHandling.repository.model.User;
import com.rdLessons.multiLayerErrorHandling.services.UserService;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Kullanıcı oluşturuldu.");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ServiceException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sunucu hatası oluştu.");
        }
    }
}


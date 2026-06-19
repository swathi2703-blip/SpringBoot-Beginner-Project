package com.being_infinity.Springboot_beginner.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.being_infinity.Springboot_beginner.models.User;
import com.being_infinity.Springboot_beginner.services.UserService;
@RestController
@RequestMapping("/api")
public class UserController {
     private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User res= userService.getUserById(id);
        if(res==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping("/users")
    public User addNewUser(User user) {
        return userService.addNewUser(user);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, User user) {
        user.setId(id);
        return userService.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

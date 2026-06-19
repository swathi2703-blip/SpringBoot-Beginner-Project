package com.being_infinity.Springboot_beginner.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.being_infinity.Springboot_beginner.models.User;
@Service
public class UserService {
    private List<User> allUsers;
    private int nextId = 3; // Initialize nextId to 3 since we have two users with IDs 1 and 2
    public UserService() {
        allUsers = new ArrayList<>();
        allUsers.add(new User(1, "John Doe", "Male", "../images/john.png"));
        allUsers.add(new User(2, "Jane Doe", "Female", "../images/jane.png"));
    }
    public List<User> getAllUsers() {
        return allUsers;
    }
    public User getUserById(int id) {
        for (User user : allUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Return null if user not found
    }
    public User addNewUser(User user) {
        user.setId(nextId);
        nextId++;
        allUsers.add(user);
        return user;
    }
    public User updateUser(User user) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == user.getId()) {
                allUsers.set(i, user);
                return user;
            }
        }
        return null; // Return null if user not found
    }
    public boolean deleteUser(int id) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == id) {
                allUsers.remove(i);
                return true; // Return true if user was found and deleted
            }
        }
        return false; // Return false if user not found
    }
}

package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.User;
import com.upgrad.TechnicalBlogApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Contain all the business logic and communicate to db
    public User login(User user) {
        User existingUser = userRepository.checkCredentials(user.getUsername(), user.getPassword());
        if(existingUser == null) {
            return null;
        } else {
            return existingUser;
        }
    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }
}

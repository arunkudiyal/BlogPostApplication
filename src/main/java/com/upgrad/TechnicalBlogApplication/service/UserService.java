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
    public boolean login(User user) {
        if(user.getUsername().equals("ashish_kumar") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }
}

package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Contain all the business logic and communicate to db
    public boolean login(User user) {
        if(user.getUsername().equals("ashish_kumar") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}

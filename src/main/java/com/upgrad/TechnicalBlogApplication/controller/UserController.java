package com.upgrad.TechnicalBlogApplication.controller;

import com.upgrad.TechnicalBlogApplication.model.User;
import com.upgrad.TechnicalBlogApplication.model.UserProfile;
import com.upgrad.TechnicalBlogApplication.service.PostService;
import com.upgrad.TechnicalBlogApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // GET Request to "/users/login
    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    // POST Request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user, HttpSession session) {

        User existingUser = userService.login(user);

        // check if the credentials match
        if(existingUser != null) {
            // Creating User Session
            session.setAttribute("LoggedUser", existingUser);
            System.out.println("USER FOUND!!");
            return "redirect:/posts";
        } else {
            System.out.println("USER DOES NOT EXIST!!");
            return "users/login";
        }
    }

    // AGENDA 3 : Create the user registration
    // Registration :- "/users/registration"
    // Logout :- "/users/logout

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration(Model model) {
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        model.addAttribute("user", user);
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        // Business logic to save the credentials. of the users to teh given database
        userService.registerUser(user);
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

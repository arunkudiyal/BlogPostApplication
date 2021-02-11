package com.upgrad.TechnicalBlogApplication.controller;

import com.upgrad.TechnicalBlogApplication.model.Post;
import com.upgrad.TechnicalBlogApplication.model.User;
import com.upgrad.TechnicalBlogApplication.service.PostService;
import com.upgrad.TechnicalBlogApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService = new UserService();
    private PostService postService = new PostService();

    // GET Request to "/users/login
    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    // POST Request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user) {
        // check if the credentials match
        if(userService.login(user)) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }
    }

    // AGENDA 3 : Create the user registration
    // Registration :- "/users/registration"
    // Logout :- "/users/logout

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        // Business logic to save the creds. of the users to teh given database

        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "redirect:/";
    }
}

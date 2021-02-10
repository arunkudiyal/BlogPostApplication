package com.upgrad.TechnicalBlogApplication.controller;

import com.upgrad.TechnicalBlogApplication.model.Post;
import com.upgrad.TechnicalBlogApplication.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class PostController {
    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        PostService postService = new PostService();
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
}

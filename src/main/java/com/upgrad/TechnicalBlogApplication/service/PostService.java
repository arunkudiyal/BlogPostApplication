package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("User's Post");
        post1.setBody("User's Post Body");
        post1.setDate(new Date());

        posts.add(post1);
        return posts;
    }
}

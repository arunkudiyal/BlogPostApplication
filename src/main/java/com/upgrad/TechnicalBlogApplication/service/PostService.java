package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    // Singleton
    private static ArrayList<Post>  POSTS = new ArrayList<>();
    static {
        Post post1 = new Post();
        post1.setTitle("Worldwide");
        post1.setBody("A news in Uttarakhand reported heavy floods in UK districts. Alert has benn declared!");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2 = new Post();
        post2.setTitle("Music");
        post2.setBody("Selena Gomez is about to drop her Spanish album. Two singles are also dropped");
        post2.setDate(new Date());
        POSTS.add(post2);

        Post post3 = new Post();
        post3.setTitle("Technology");
        post3.setBody("Apple's new iOS 14.5, iPadOS 14.5, macOS 11.3 updates are out for registered BETA testers.");
        post3.setDate(new Date());
        POSTS.add(post3);

        Post post4 = new Post();
        post4.setTitle("National");
        post4.setBody("COVID vaccine drive has started in India, where front-line workers are prioritized!");
        post4.setDate(new Date());
        POSTS.add(post4);
    }

    public ArrayList<Post> getAllPosts() {
        return POSTS;
    }

    public void createPost(Post newPost) {
        POSTS.add(newPost);
    }
}

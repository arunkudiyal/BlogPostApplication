package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import com.upgrad.TechnicalBlogApplication.model.User;
import com.upgrad.TechnicalBlogApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(Integer userId) {
        return  postRepository.getAllPosts(userId);
    }

    public void createPost(Post newPost) {
        postRepository.createPost(newPost);
    }


    public Post getPost(Integer postId) {
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        postRepository.updatePost(updatedPost);
    }
}

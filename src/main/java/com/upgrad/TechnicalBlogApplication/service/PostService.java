package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {
    // Singleton
    private static ArrayList<Post>  POSTS = new ArrayList<>();
    /* static {
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
    } */

    private final String url = "jdbc:postgresql://localhost:5432/technicalblog";
    private final String username = "arunkudiyal";  // "postgresql"
    private final String password = "examplepwd";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList<Post> getAllPosts() {
        try {
            // Business Logic for connecting the database

            // Step 1: Connect to the DB
            Connection connection = connect();

            // Step 2: Get/ Create the Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the select query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");

            // Step 4: Loop into the resultSet and get the data
            while(resultSet.next()) {
                Post post1 = new Post();
                post1.setTitle(resultSet.getString("title"));
                post1.setBody(resultSet.getString("body"));
                post1.setDate(resultSet.getDate("date"));

                // Store the data in the Singleton
                POSTS.add(post1);
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return POSTS;
    }

    public void createPost(Post newPost) {
        String query = "INSERT INTO posts(title, body, date) VALUES(?, ?, ?)";
        try {
            // Step 1: Connect to the DB
            Connection connection = connect();

            // Step 2: Prepare a statement
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Step 3: Fix the values from the VIEWS
            preparedStatement.setString(1, newPost.getTitle());
            preparedStatement.setString(2, newPost.getBody());
            preparedStatement.setDate(3, new Date(newPost.getDate().getTime()));

            int updatedRows = preparedStatement.executeUpdate();

            if(updatedRows > 0) {
                System.out.println("Update is working Fine!");
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

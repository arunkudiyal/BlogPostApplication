package com.upgrad.TechnicalBlogApplication.model;

import java.util.Date;

// POJO -> Plain Old Java Object
public class Post {
    // components of the post
    private String title;
    private String body;
    private Date date;

    // Getters and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

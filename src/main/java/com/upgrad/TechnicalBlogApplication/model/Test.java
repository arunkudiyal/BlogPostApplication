package com.upgrad.TechnicalBlogApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "testTable")          // test_table
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "testId")            // test_id
    private int id;

    @Column(name = "testName")          // test_name
    private String name;

    @Column(name = "testEmail")
    private String email;

    @Column(name = "testPassword")
    private String password;

    public Test() {
    }

    public Test(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

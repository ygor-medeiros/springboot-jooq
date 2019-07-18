package com.ygor.springbootjooq.model;

import java.sql.Timestamp;

public class Comment {

    private int id;
    private int post_id;
    private String name;
    private String email;
    private String content;
    private Timestamp created_on;

    public Comment () {}

    public Comment(int post_id, String name, String email, String content, Timestamp created_on) {
        this.post_id = post_id;
        this.name = name;
        this.email = email;
        this.content = content;
        this.created_on = created_on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return post_id;
    }

    public void setPostId(int post_id) {
        this.post_id = post_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedOn() {
        return created_on;
    }

    public void setCreatedOn(Timestamp created_on) {
        this.created_on = created_on;
    }
}

package com.model;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class User {

    @BsonProperty(value="name")
    private String name;

    @BsonProperty(value="password")
    private String password;

    @BsonProperty(value="role")
    private String role;

    public User(){}

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

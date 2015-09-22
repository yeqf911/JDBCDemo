package com.yeqf.jdbcdemo;

/**
 * Created by yeqf on 2015/9/20.
 */
public class User {
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + email;
    }
}

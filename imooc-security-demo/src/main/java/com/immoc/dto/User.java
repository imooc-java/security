package com.immoc.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends  UserSimpleView {};

    private String username;

    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}

package com.searchroom.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Account {

    @NotEmpty
    @Size(min = 3, max = 50)
    private String username;

    @NotEmpty
    @Size(min = 4, max = 50)
    private String password;

    private String role;

    public Account() {
    }

    public Account(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

package com.example.demo.testedPart;

public class UserRegistrationDto {

    private String username;

    private String roles;
    private String password;

    public UserRegistrationDto(){

    }

    public UserRegistrationDto(String username, String roles, String password) {
        super();
        this.username = username;
        this.roles = roles;
        this.password = password;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}

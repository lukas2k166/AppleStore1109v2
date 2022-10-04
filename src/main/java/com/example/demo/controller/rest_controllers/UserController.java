package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Macbook;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/homepage/administration/users_administration/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping (value = "delete/user",
            method={RequestMethod.DELETE, RequestMethod.GET})
    public void deleteUser(){
        userService.deleteByUsername();
    }

    @RequestMapping("my/username")
    public String  welcomeUser(Principal principal) {
        String loggedUserName = principal.getName();
        return "Hello " + loggedUserName;
    }
}

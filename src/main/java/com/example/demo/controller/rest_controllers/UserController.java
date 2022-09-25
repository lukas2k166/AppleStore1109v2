package com.example.demo.controller.rest_controllers;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

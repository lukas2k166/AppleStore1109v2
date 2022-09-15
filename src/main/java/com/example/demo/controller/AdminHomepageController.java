package com.example.demo.controller;

import com.example.demo.exception.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/homepage/")
public class AdminHomepageController {

    @GetMapping("administration")
    public String getUsers(HttpServletRequest request) {
        if (!request.isUserInRole("ROLE_ADMIN"))
            throw new UnauthorizedException("You don't have permission to access this page");

        return "administration";
    }
}

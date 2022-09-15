package com.example.demo.controller;

import com.example.demo.exception.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("loginpage")
    public String getLogin() {
        return "loginpage";
    }

    @GetMapping("homepage")
    public String getHomePage(){
        return "homepage";
    }



}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginPageController {

    @GetMapping("loginpage")
    public String getLoginPage() {
        return "loginpage";
    }

    @GetMapping("homepage")
    public String getHomePage(){
        return "homepage";
    }




}

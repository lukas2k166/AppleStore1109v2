package com.example.demo.controller.template_controllers;

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

}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IncorrectCredentialsController {

    @GetMapping("incorrectcredentialspage")
    public String getAdministration2() {
        return "incorrectcredentialspage";
    }

    @GetMapping("403")
    public String getAdministration3() {
        return "403";
    }


}

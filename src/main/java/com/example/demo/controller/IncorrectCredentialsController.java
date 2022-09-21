package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IncorrectCredentialsController {

    @GetMapping("incorrect_credentials_page")
    public String getIncorrectCredentialsPage() {
        return "incorrect_credentials_page";
    }

    @GetMapping("logon_denied_page")
    public String getLogonDeniedPage() {
        return "logon_denied_page";
    }


}

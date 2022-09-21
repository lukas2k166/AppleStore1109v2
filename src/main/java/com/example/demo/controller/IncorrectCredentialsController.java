package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IncorrectCredentialsController {

    @GetMapping("incorrect_credentials_page")
    public String getAdministration2() {
        return "incorrect_credentials_page";
    }

    @GetMapping("403")
    public String getAdministration3() {
        return "403";
    }


}

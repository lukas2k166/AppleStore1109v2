package com.example.demo.controller.template_controllers.client_pages.main_pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping("homepage")
    public String getHomePage() {
        return "homepage";
    }
}


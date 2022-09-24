package com.example.demo.controller.template_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage/administration")
public class AdministrationController {

    @GetMapping("")
    public String getAdministration() {
        return "administration";
    }

    @GetMapping("/users_administration")
    public String getUsersAdministration() {
        return "users_administration";
    }

    @GetMapping("/products_administration")
    public String getProductsAdministration() {
        return "products_administration";
    }




}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage/products/")
public class ProductsPageController {

    @GetMapping("productspage")
    public String getAdministration() {
        return "productspage";
    }

    @GetMapping("macbookspage")
    public String getAdministration2() {
        return "macbookspage";
    }


}

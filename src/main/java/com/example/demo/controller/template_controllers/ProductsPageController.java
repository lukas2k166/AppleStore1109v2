package com.example.demo.controller.template_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage/products/")
public class ProductsPageController {

    @GetMapping("productspage")
    public String getProductsPage() {
        return "productspage";
    }

    @GetMapping("macbookspage")
    public String getMacbooksPage() {
        return "macbookspage";
    }


}

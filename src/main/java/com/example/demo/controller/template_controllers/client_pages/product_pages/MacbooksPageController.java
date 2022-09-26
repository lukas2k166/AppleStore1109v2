package com.example.demo.controller.template_controllers.client_pages.product_pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage/products/macbookspage")
public class MacbooksPageController {


    @GetMapping("")
    public String getMacbooksPage() {
        return "macbookspage";
    }


}

package com.example.demo.controller.template_controllers.administration.products_administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/macbooks_administration")
public class MacbookAdminController {

    @GetMapping("")
    public String getMacbookAdminPage() {
        return "macbooks_administration";
    }



}

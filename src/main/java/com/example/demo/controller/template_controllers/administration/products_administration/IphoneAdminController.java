package com.example.demo.controller.template_controllers.administration.products_administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/iphones_administration")
public class IphoneAdminController {

    @GetMapping("")
    public String getIphoneAdminPage() {
        return "iphones_administration";
    }

}

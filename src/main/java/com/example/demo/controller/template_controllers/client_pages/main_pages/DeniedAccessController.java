package com.example.demo.controller.template_controllers.client_pages.main_pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class DeniedAccessController {

    @GetMapping("incorrect_credentials_page")
    public String getIncorrectCredentialsPage() {
        return "incorrect_credentials_page";
    }

    @GetMapping("logon_denied_page")
    public String getLogonDeniedPage() {
        return "logon_denied_page";
    }








}

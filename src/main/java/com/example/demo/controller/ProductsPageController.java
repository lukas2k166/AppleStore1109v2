package com.example.demo.controller;

import com.example.demo.exception.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/homepage/products/")
public class ProductsPageController {


    @GetMapping("productspage")
    public String getAdministration(HttpServletRequest request) {
//        if (!request.isUserInRole("ROLE_ADMIN"))
//            throw new UnauthorizedException("You don't have permission to access this page");

        return "productspage";
    }

    @GetMapping("macbookspage")
    public String getAdministration2(HttpServletRequest request) {
//        if (!request.isUserInRole("ROLE_ADMIN"))
//            throw new UnauthorizedException("You don't have permission to access this page");

        return "macbookspage";
    }


}

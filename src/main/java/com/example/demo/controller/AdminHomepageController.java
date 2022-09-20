package com.example.demo.controller;

import com.example.demo.auth.AppUserRole;
import com.example.demo.exception.UnauthorizedException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


@Controller
@RequestMapping("/homepage/")
public class AdminHomepageController {

    @Autowired
    UserDetailsService userDetailsService;



    @GetMapping("administration")
    public String getAdministration(HttpServletRequest request) {

//        if (!request.isUserInRole("ROLE_ADMIN"))
//            throw new UnauthorizedException("You don't have permission to access this page");

        return "administration";
    }



}

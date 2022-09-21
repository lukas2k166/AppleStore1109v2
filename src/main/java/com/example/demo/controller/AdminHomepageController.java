package com.example.demo.controller;

import com.example.demo.auth.AppUserRole;
import com.example.demo.exception.UnauthorizedException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
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
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.Collection;

import static com.example.demo.auth.AppUserRole.ADMIN;
import static com.example.demo.auth.AppUserRole.values;


@Controller
@RequestMapping("/homepage/")
public class AdminHomepageController {


    @GetMapping("administration")
    public String getAdministration() {
//        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        return "administration";
    }




}

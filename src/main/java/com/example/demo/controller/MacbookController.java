package com.example.demo.controller;

import com.example.demo.entities.Macbook;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.service.MacbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/macbooks")
public class MacbookController {

    @Autowired
    MacbookService macbookService;

    @PostMapping("/add/new/macbook")
    public void addNewProduct(){
        macbookService.addNewMacbook();
    }

    @GetMapping("/find/macbook/by/name")
    public List<Macbook> getMacbookByName(){
        return macbookService.findMacbookByName();
    }

}

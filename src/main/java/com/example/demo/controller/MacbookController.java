package com.example.demo.controller;

import com.example.demo.service.MacbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/macbooks")
public class MacbookController {

    @Autowired
    MacbookService macbookService;

    @PostMapping("/add/new/macbook")
    public void addNewProduct(){
        macbookService.addNewMacbook();
    }



}

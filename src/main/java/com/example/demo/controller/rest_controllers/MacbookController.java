package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Macbook;
import com.example.demo.service.MacbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/macbooks")
public class MacbookController {

    @Autowired
    MacbookService macbookService;

    @GetMapping("/get/all/macbooks")
    public List<Macbook> getAllMacbooks(){
       return macbookService.getAllMacbooks();
    }


    @PostMapping("/add/new/macbook")
    public void addNewMacbook(){
        macbookService.addNewMacbook();
    }

    @GetMapping("/find/macbook/by/name")
    public List<Macbook> getMacbookByName(){
         return macbookService.findMacbookByName();
    }

}

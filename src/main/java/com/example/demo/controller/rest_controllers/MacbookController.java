package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Macbook;
import com.example.demo.service.MacbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Macbook> getMacbookByName(){
         return macbookService.findMacbookByName();
    }

    @PostMapping("/update")
    public void updateMacbookProperties(){
        macbookService.updateMacbook();
    }

    @RequestMapping(value = "/delete",
            method={RequestMethod.DELETE, RequestMethod.GET})
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteMacbook() {
        macbookService.deleteMacbook();
    }

}

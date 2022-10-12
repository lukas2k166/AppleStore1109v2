package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Macbook;
import com.example.demo.service.MacbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.example.demo.authorization.AppUserRole.ADMIN;

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


    @GetMapping("/update/{macbook_id}/{macbook_name}/{macbook_price}/{macbook_processor}/{macbook_ram}")
    public void updateMacbookProperties(
            @PathVariable(value = "macbook_id") Long macbook_id,
            @PathVariable(value = "macbook_name") String macbook_name,
            @PathVariable(value = "macbook_price") BigDecimal macbook_price,
            @PathVariable(value = "macbook_processor") String macbook_processor,
            @PathVariable(value = "macbook_ram") Integer macbook_ram
            ){
        macbookService.updateMacbook(
                macbook_id,
                macbook_name,
                macbook_price,
                macbook_processor,
                macbook_ram
                );
    }

    @RequestMapping(value = "/delete",
            method={RequestMethod.DELETE, RequestMethod.GET})
    public void deleteMacbook() {
        macbookService.deleteMacbook();
    }


}

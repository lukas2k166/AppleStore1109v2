package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Macbook;
import com.example.demo.service.service_implementations.MacbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/macbooks")
public class MacbookController {

    @Autowired
    MacbookServiceImpl macbookService;

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

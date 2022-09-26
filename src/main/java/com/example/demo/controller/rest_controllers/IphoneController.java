package com.example.demo.controller.rest_controllers;

import com.example.demo.entities.Iphone;
import com.example.demo.service.IphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iphones")
public class IphoneController {

    @Autowired
    IphoneService iphoneService;

    @GetMapping("/get/all/iphones")
    public List<Iphone> getAllIphones(){
        return iphoneService.getAllIphones();
    }




}

package com.example.demo.service;

import com.example.demo.entities.Iphone;
import com.example.demo.repository.IphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IphoneService {

    @Autowired
    private IphoneRepository iphoneRepository;

    public List<Iphone> getAllIphones(){

        return (List<Iphone>) iphoneRepository.findAll();
    }






}

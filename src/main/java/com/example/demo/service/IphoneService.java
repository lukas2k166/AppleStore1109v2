package com.example.demo.service;

import com.example.demo.entities.Iphone;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class IphoneService {

    @Autowired
    private IphoneRepository iphoneRepository;

    public List<Iphone> getAllIphones(){

        return (List<Iphone>) iphoneRepository.findAll();
    }










    public List<Iphone> findIphoneByName(){

        System.out.println("put iphone name");
        var putIphone = new Scanner(System.in);
        String puttedIphone = putIphone.nextLine();

        if (iphoneRepository.findByIphoneName(puttedIphone).isEmpty())
            throw new ResourceNotFoundException(puttedIphone + " cannot be found");

        return iphoneRepository.findByIphoneName(
                puttedIphone
        );

    }




}

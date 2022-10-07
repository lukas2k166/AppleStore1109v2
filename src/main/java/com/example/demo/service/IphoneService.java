package com.example.demo.service;

import com.example.demo.entities.Iphone;
import com.example.demo.entities.Product;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Service
public class IphoneService {

    @Autowired
    private IphoneRepository iphoneRepository;
    @Autowired
    private ProductService productService;

    public List<Iphone> getAllIphones(){

        return (List<Iphone>) iphoneRepository.findAll();
    }

    public void addNewIphone() {

        var product = Product.builder()
                .product_name("Iphone 13")
                .product_price(new BigDecimal("4000"))
                .build();

        var newIphone = Iphone.builder()
                .product(product)
                .iphone_price(product.getProduct_price())
                .iphone_name(product.getProduct_name())
                .build();

        if (iphoneRepository.findByIphoneName(newIphone.getIphone_name())
                .stream().findFirst().isPresent())
            throw new AlreadyExistsException(
                    newIphone.getIphone_name() + " already exists"
            );

        iphoneRepository.save(newIphone);
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

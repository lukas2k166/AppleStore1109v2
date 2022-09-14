package com.example.demo.service;

import com.example.demo.entities.Macbook;
import com.example.demo.entities.MacbookSpecification;
import com.example.demo.entities.Product;
import com.example.demo.repository.MacbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Service
public class MacbookService {

    @Autowired
    private MacbookRepository macbookRepository;

    public void addNewMacbook() {

        Product product = Product.builder()
                .product_name("Macbook Pro")
                .product_price(new BigDecimal("12000"))
                .build();

        var macbookSpecification = new MacbookSpecification();
        macbookSpecification.setMacbook_ram(16);
        macbookSpecification.setMacbook_processor("M1 Pro");

        Macbook macbook = Macbook.builder()
                .product(product)
                .macbookSpecification(macbookSpecification)
                .macbook_price(product.getProduct_price())
                .macbook_name(product.getProduct_name())
                .build();

            macbookRepository.save(macbook);
    }

    public List<Macbook> findMacbookByName(){
       return macbookRepository.findMacbookByName(
               askMacbookName()
       );
    }

    private String askMacbookName(){
        System.out.println("put macbook name");
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

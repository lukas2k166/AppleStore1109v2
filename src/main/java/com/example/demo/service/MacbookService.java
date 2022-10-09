package com.example.demo.service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Macbook;
import com.example.demo.entities.MacbookSpecification;
import com.example.demo.entities.Product;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static com.example.demo.service.Categories.LAPTOP;

@Service
public class MacbookService {

    @Autowired
    private MacbookRepository macbookRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    public MacbookService(MacbookRepository macbookRepository) {
        this.macbookRepository = macbookRepository;
    }

    public List<Macbook> getAllMacbooks(){

       return (List<Macbook>) macbookRepository.findAll();
    }

    public void addNewMacbook() {

        var product = Product.builder()
                .category(new Category(String.valueOf(LAPTOP)))
                .product_name("Macbook Pro M2")
                .product_price(new BigDecimal("12000"))
                .build();

        var macbookSpecification = new MacbookSpecification();
        macbookSpecification.setMacbook_ram(16);
        macbookSpecification.setMacbook_processor("M1 Pro");

        var newMacbook = Macbook.builder()
                .product(product)
                .macbookSpecification(macbookSpecification)
                .macbook_price(product.getProduct_price())
                .macbook_name(product.getProduct_name())
                .build();

        if (productRepository.findByProductName(newMacbook.getMacbook_name())
                .stream().findFirst().isPresent())
            throw new AlreadyExistsException(
                    newMacbook.getMacbook_name() + " already exists"
            );

        macbookRepository.save(newMacbook);
    }

    public void updateMacbook(){
        System.out.println("put macbook ID that you want to modify");
        var putId = new Scanner(System.in);
        Long puttedId = putId.nextLong();

        macbookRepository.updateMacbook(
                puttedId,
                "Macbook Name Modified",
                new BigDecimal("1000000"),
                new MacbookSpecification("M1 Max",64)
        );
    }

    public void deleteMacbook(){

        System.out.println("put macbook ID that you want to delete");
        var putId = new Scanner(System.in);
        Long puttedId = putId.nextLong();

        macbookRepository.deleteById(puttedId);
    }

}

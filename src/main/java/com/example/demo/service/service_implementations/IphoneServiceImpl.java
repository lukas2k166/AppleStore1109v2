package com.example.demo.service.service_implementations;

import com.example.demo.entities.Category;
import com.example.demo.entities.Iphone;
import com.example.demo.entities.Product;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.IphoneRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.service_interfaces.IphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.example.demo.service.Categories.PHONE;

@Service
public class IphoneServiceImpl implements IphoneService {

    @Autowired
    private IphoneRepository iphoneRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Iphone> getAllIphones(){

        return (List<Iphone>) iphoneRepository.findAll();
    }

    public void addNewIphone() {

        var product = Product.builder()
                .product_name("Iphone 14 Pro")
                .category(new Category(String.valueOf(PHONE)))
                .product_price(new BigDecimal("4000"))
                .build();

        var newIphone = Iphone.builder()
                .product(product)
                .iphone_price(product.getProduct_price())
                .iphone_name(product.getProduct_name())
                .build();

        if (productRepository.findByProductName(newIphone.getIphone_name())
                .stream().findFirst().isPresent())
            throw new AlreadyExistsException(
                    newIphone.getIphone_name() + " already exists"
            );

        iphoneRepository.save(newIphone);
    }






}

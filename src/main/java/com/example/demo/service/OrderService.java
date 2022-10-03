package com.example.demo.service;

import com.example.demo.entities.*;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MacbookRepository macbookRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(){

        var product = Product.builder()
                .product_name("Macbook Pro M1")
                .product_price(new BigDecimal("15000"))
                .build();

        var macbookSpecification = new MacbookSpecification();
        macbookSpecification.setMacbook_ram(32);
        macbookSpecification.setMacbook_processor("M1 Pro");

        var newMacbook = Macbook.builder()
                .product(product)
                .macbookSpecification(macbookSpecification)
                .macbook_price(product.getProduct_price())
                .macbook_name(product.getProduct_name())
                .product(product)
                .build();

        macbookRepository.save(newMacbook);

        Cart cart = Cart.builder()
                .product(product)
                .build();

        Order order = Order.builder()
                .cart(cart)
                .build();

        orderRepository.save(order);
    }

    public void deleteById(long order_id) {
        this.orderRepository.deleteById(order_id);
    }





}

package com.example.demo.service;

import com.example.demo.entities.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public void addOrder(String product_name, String product_name2){

        try {
            Collection<Product> products = new ArrayList<Product>();
            products.add(productRepository.findByProductName(product_name).stream().findFirst().get());
            products.add(productRepository.findByProductName(product_name2).stream().findFirst().get());

            Cart cart = Cart.builder()
                    .products(products)
                    .build();

            Order order = Order.builder()
                    .cart(cart)
                    .build();

            orderRepository.save(order);
        }catch (NoSuchElementException e){
            throw new ResourceNotFoundException(product_name +" or "+ product_name2 +" not found");
        }

    }

    public void deleteById(long order_id) {
        this.orderRepository.deleteById(order_id);
    }




}

package com.example.demo.service;

import com.example.demo.entities.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.example.demo.service.Categories.LAPTOP;

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

    public void addOrder(String product_name){

        var product = Product.builder()
                .category(new Category(String.valueOf(LAPTOP)))
                .product_name(product_name)
                .product_price(new BigDecimal("15000"))
                .build();

        if (productRepository.findByProductName(product_name).
                stream().findAny().isEmpty()){
            throw new ResourceNotFoundException(product.getProduct_name() + " does not exist");
        }

        Cart cart = Cart.builder()
                .product(productRepository.findByProductName(product_name).stream().findFirst().get())
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

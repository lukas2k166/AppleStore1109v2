package com.example.demo.testedPart;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(){

        Product product = Product.builder()
                .product_price(new BigDecimal("10000"))
                .product_name("Macbook")
                .build();

        Cart cart = Cart.builder()
                .product(product)
                .build();

        Order order = Order.builder()
                .cart(cart)
                .build();

        orderRepository.save(order);


    }



}

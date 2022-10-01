package com.example.demo.testedPart;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CartRepo cartRepo;

    @GetMapping("add/order")
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

        orderRepo.save(order);


    }


}

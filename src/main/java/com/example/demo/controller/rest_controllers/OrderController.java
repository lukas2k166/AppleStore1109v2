package com.example.demo.controller.rest_controllers;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("add/order/{product_name}")
    public void addOrder(@PathVariable(value = "product_name") String product_name){
        orderService.addOrder(product_name);
    }

    @GetMapping("/deleteOrder/{order_id}")
    public void deleteOrder(@PathVariable(value = "order_id") long order_id) {
        this.orderService.deleteById(1L);
    }

}

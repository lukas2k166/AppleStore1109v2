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

    @GetMapping("add/order/{product_name}/{product_name2}")
    public void addOrder(
            @PathVariable(value = "product_name") String product_name,
            @PathVariable(value = "product_name2") String product_name2){

        orderService.addOrder(product_name,product_name2);
    }

    @GetMapping("/deleteOrder/{order_id}")
    public void deleteOrder(@PathVariable(value = "order_id") long order_id) {
        this.orderService.deleteById(1L);
    }

    @GetMapping("addProductToExistingOrder/{order_id}/{product_name}")
    public void addProductToExistingOrder(
            @PathVariable(value = "order_id") long order_id,
            @PathVariable(value = "product_name") String product_name){

        orderService.addProductToExistingOrder(order_id,product_name);
    }

}

package com.example.demo.controller.rest_controllers;

import com.example.demo.service.service_implementations.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("add/order/{product_name}/{product_name2}")
    public void addOrder(
            @PathVariable(value = "product_name") String product_name,
            @PathVariable(value = "product_name2") String product_name2){

        orderService.addOrder(product_name,product_name2);
    }

    @GetMapping("/deleteOrder/{order_id}")
    public void deleteOrder(@PathVariable(value = "order_id") long order_id) {
        this.orderService.deleteOrderById(1L);
    }

    @GetMapping("add/ProductToExistingOrder/{order_id}/{product_name}")
    public void addProductToExistingOrder(
            @PathVariable(value = "order_id") long order_id,
            @PathVariable(value = "product_name") String product_name){

        orderService.addProductToExistingOrder(order_id,product_name);
    }

    @GetMapping("remove/ProductFromExistingOrder/{order_id}/{product_name}")
    public void removeProductFromExistingOrder(
            @PathVariable(value = "order_id") long order_id,
            @PathVariable(value = "product_name") String product_name){

        orderService.removeProductFromOrder(order_id,product_name);
    }

    @GetMapping("remove/all/ProductsFromOrder/{order_id}")
    public void removeAllProductsFromOrder(
            @PathVariable(value = "order_id") long order_id){

        orderService.removeAllProductsFromOrder(order_id);
    }




}

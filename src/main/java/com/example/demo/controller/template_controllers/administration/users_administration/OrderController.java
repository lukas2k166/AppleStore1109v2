package com.example.demo.controller.template_controllers.administration.users_administration;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("add/order")
    public void addOrder(){
        orderService.addOrder();
    }


}

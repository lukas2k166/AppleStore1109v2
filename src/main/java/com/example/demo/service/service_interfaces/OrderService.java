package com.example.demo.service.service_interfaces;

public interface OrderService {

    void addOrder(String product_name, String product_name2);

    void deleteOrderById(long order_id);

    void addProductToExistingOrder(long order_id, String product_name);

    void removeProductFromOrder(long order_id, String product_name);

    void removeAllProductsFromOrder(long order_id);



}

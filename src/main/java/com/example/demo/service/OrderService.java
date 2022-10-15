package com.example.demo.service;

import com.example.demo.entities.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.MacbookRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MacbookRepository macbookRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(String product_name, String product_name2) {

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
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(product_name + " or " + product_name2 + " not found");
        }
    }

    public void deleteOrderById(long order_id) {
        this.orderRepository.deleteById(order_id);
    }

    public void addProductToExistingOrder(long order_id, String product_name) {

        if (!orderRepository.existsById(order_id))
            throw new ResourceNotFoundException("Order with " + order_id + " ID cannot be found");

        Order existingOrder = orderRepository.findById(order_id).get();
        Collection<Product> products = new ArrayList<Product>(existingOrder.getCart().getProducts());

        if (productRepository.findByProductName(product_name).stream().findAny().isEmpty())
            throw new ResourceNotFoundException("Product: " + product_name + " cannot be found");

        Product existingProduct = productRepository.findByProductName(product_name).stream().findFirst().get();

        products.add(existingProduct);


        Cart selectedCart = cartRepository.findById(order_id).get();
        selectedCart.setCart_id(order_id);
        selectedCart.setProducts(products);

        existingOrder.setCart(selectedCart);
        orderRepository.save(existingOrder);
    }

    public void removeProductFromOrder(long order_id, String product_name){

        if (!orderRepository.existsById(order_id))
            throw new ResourceNotFoundException("Order with " + order_id + " ID cannot be found");

        Order existingOrder = orderRepository.findById(order_id).get();
        Collection<Product> products = new ArrayList<Product>(existingOrder.getCart().getProducts());

        if (productRepository.findByProductName(product_name).stream().findAny().isEmpty())
            throw new ResourceNotFoundException("Product: " + product_name + " cannot be found");

        Product existingProduct = productRepository.findByProductName(product_name).stream().findFirst().get();

        products.remove(existingProduct);

        Cart selectedCart = cartRepository.findById(order_id).get();
        selectedCart.setCart_id(order_id);
        selectedCart.setProducts(products);

        existingOrder.setCart(selectedCart);
        orderRepository.save(existingOrder);
    }

    public void removeAllProductsFromOrder(long order_id) {

        if (cartRepository.findById(order_id).stream().findFirst().isEmpty())
            throw new ResourceNotFoundException(order_id + " cannot be found");

        Cart cart = cartRepository.findById(order_id).stream().findFirst().get();

        Collection<Product> newCartContent = new HashSet<>();


                cart.setProducts(newCartContent);
                cart.setCart_id(order_id);

                Order order = orderRepository.findById(order_id).get();
                order.setCart(cart);


                orderRepository.save(order);
            }
        }






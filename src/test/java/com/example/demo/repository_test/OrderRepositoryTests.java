package com.example.demo.repository_test;

import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class OrderRepositoryTests {

	@Autowired
	private OrderRepository orderRepository;




}

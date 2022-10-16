package com.example.demo.service_test;

import com.example.demo.repository.OrderRepository;
import com.example.demo.service.service_implementations.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

class OrderServiceTests {

	@Mock
	private OrderRepository orderRepository;
	private AutoCloseable autoCloseable;
	private OrderServiceImpl underTest;


	@BeforeEach
	void setUp(){
		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new OrderServiceImpl(orderRepository);
	}
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void shouldDeleteOrderById(){

		underTest.deleteOrderById(1L);

		verify(orderRepository).deleteById(1L);

	}




}

package com.example.demo.service_test;

import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
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
	private OrderService underTest;


	@BeforeEach
	void setUp(){
		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new OrderService(orderRepository);
	}
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void shouldDeleteOrderById(){

		underTest.deleteById(1L);

		verify(orderRepository).deleteById(1L);

	}




}

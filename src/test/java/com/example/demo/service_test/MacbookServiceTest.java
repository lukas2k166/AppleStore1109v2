package com.example.demo.service_test;

import com.example.demo.repository.MacbookRepository;
import com.example.demo.service.MacbookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class MacbookServiceTest {

	@Mock
	private MacbookRepository macbookRepository;
	private AutoCloseable autoCloseable;
	private MacbookService underTest;


	@BeforeEach
	void setUp(){
		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new MacbookService(macbookRepository);
	}
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void shouldGetAllMacbooks() {
		underTest.getAllMacbooks();

		verify(macbookRepository).findAll();
	}


}

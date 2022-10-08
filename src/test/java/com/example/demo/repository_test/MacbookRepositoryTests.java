package com.example.demo.repository_test;

import org.assertj.core.api.Assertions;
import com.example.demo.entities.Macbook;
import com.example.demo.entities.MacbookSpecification;
import com.example.demo.entities.Product;
import com.example.demo.repository.MacbookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;


@DataJpaTest
class MacbookRepositoryTests {

	@Autowired
	private MacbookRepository underTest;

	@Test
	void shouldSaveMacbook() {
		var product = Product.builder()
				.product_name("Macbook Pro M3")
				.product_price(new BigDecimal("12000"))
				.build();

		var macbookSpecification = new MacbookSpecification();
		macbookSpecification.setMacbook_ram(16);
		macbookSpecification.setMacbook_processor("M1 Pro");

		var newMacbook = Macbook.builder()
				.product(product)
				.macbookSpecification(macbookSpecification)
				.macbook_price(product.getProduct_price())
				.macbook_name(product.getProduct_name())
				.build();

		underTest.save(newMacbook);

		Assertions.assertThat(newMacbook.getMacbook_id()).isGreaterThan(0);
	}


}

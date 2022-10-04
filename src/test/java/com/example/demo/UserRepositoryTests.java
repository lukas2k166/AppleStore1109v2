package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.LinkedList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserRepository underTest;

	private User newUser;

	@AfterEach
	void deleteCreatedUser(){
		underTest.deleteByUsername(newUser.getUsername());
	}

	@Test
	void shouldRegisterUser(){

				newUser = entityManager.persist(new User(
						"TestUser","password",
				new LinkedList<>(List.of(new Role("ROLE_ADMIN"))
				)));

		underTest.save(newUser);

		assertThat(newUser).isNotNull();
	}


}

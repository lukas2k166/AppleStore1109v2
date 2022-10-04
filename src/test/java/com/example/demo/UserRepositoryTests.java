package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

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

	@Test
	void shouldRegisterUser(){

				User newUser = entityManager.persist(new User(
						"TestUser44","password",
				new LinkedList<>(List.of(new Role("ROLE_ADMIN"))
				)));

		underTest.save(newUser);


		assertThat(newUser).isNotNull();

		underTest.deleteById(newUser.getId());
	}

	@Test
	public void shouldFindUserByUsername() {
		User user = new User();
		user.setUsername("AdminUser");

		assertThat(underTest.findByUsername(user.getUsername()).get().getUsername())
				.isEqualTo(user.getUsername());
	}





}

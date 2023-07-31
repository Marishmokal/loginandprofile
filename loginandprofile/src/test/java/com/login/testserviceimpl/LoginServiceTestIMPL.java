package com.login.testserviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.login.entity.User;
import com.login.service.LoginServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTestIMPL {
	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private LoginServiceImpl loginService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void getByMailId() {
		User expectedUser = new User();
		expectedUser.setEmailId("jax@gmail.com");
		expectedUser.setPassword("password");

		when(restTemplate.getForObject(eq("http://localhost:8080/v1/api/getByMailId/jax@gmail.com"), eq(User.class)))
				.thenReturn(expectedUser);

		User result = loginService.getByMailId("jax@gmail.com");
		assertEquals(expectedUser, result);
	}

	@Test
	void getAllUsers() {
		List<User> expectedUsers = Arrays.asList(new User("Jax@gmail.com", "password1"),
				new User("Max@gmail.com", "password2"));

		ResponseEntity<List> responseEntity = new ResponseEntity<>(expectedUsers, HttpStatus.OK);
		when(restTemplate.getForEntity(eq("http://localhost:8080/v1/api/users"), eq(List.class)))
				.thenReturn(responseEntity);

		List<User> result = loginService.getAllUsers();
		assertEquals(expectedUsers, result);
	}
}
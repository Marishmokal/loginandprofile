package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.User;
import com.login.service.LoginService;

@RestController
@RequestMapping("/v2")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> loginEmployee(@RequestBody User user) {
		String msg = loginService.loginEmployee(user);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/profile/{emailId}")
	public ResponseEntity<User>  getMyProfile(@PathVariable String emailId) {
		User user = loginService.getByMailId(emailId);
	return new ResponseEntity(user, HttpStatus.FOUND);

	}

	@GetMapping("/users")
	public List<User>getAllUsers()
	{
		return loginService.getAllUsers();
		
	}
}

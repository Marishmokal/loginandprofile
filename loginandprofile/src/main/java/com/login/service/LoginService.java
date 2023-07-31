package com.login.service;

import java.util.List;

import com.login.entity.User;

public interface LoginService {

	String loginEmployee(User user);

	User getByMailId(String emailId);
	
	List<User>getAllUsers();

}

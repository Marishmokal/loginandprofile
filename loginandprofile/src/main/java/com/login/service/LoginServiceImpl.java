package com.login.service;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.login.entity.User;

@Service
public class LoginServiceImpl implements LoginService {

	
	RestTemplate template=new RestTemplate();

	@Override
	public String loginEmployee(User user) {
		String mail = user.getEmailId();
		String pass = user.getPassword();
		User user1 = getByMailId(mail);
		if (user1.getPassword().equals(pass)) {
			return "login successfully";
		}
		return "User Not Found";
	}

	@Override
	public User getByMailId(String emailId) {
		String url="http://localhost:8080/v1/api/getByMailId/"+emailId;
		User user=template.getForObject(url, User.class);
			
		return user;
	}
	
	public List<User>getAllUsers()
	{
		String url="http://localhost:8080/v1/api/users";
		ResponseEntity<List> user=template.getForEntity(url,List.class);
		List<User>users=user.getBody();
		return users;
		
	}

}

package com.login.entity;

public class User {
	
	private String newPassword;
	
	
	private int userId;
	
	private String userName;
	
	private String emailId;
	
	private String password;
	
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	

	public User(String newPassword, int userId, String userName, String emailId, String password) {
		super();
		this.newPassword = newPassword;
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ userId=" + userId + ", userName=" + userName + ", emailId="
				+ emailId + ", ]";
	}

	
	

}

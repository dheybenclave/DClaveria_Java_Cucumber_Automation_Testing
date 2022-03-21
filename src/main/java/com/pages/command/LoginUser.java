package com.pages.command;

import java.util.HashMap;

public class LoginUser {

	private String userName;
	private String password;

	private HashMap<String, String> userCredentials = new HashMap<String, String>();

	public LoginUser(String userName, String password) {
//		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, String> getUserCredentials() {

		userCredentials.put(userName, password);
		
		userCredentials.put("author@vrbank", "pega123!");
		userCredentials.put("manager@vrbank", "pega123!");
		userCredentials.put("user@vrbank", "pega123!");

		return userCredentials;

	}

}

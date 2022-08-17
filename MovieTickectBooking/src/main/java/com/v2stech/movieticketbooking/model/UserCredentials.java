package com.v2stech.movieticketbooking.model;

public class UserCredentials {

	private String user_name;
	private String password;
	private int isAdmin;
	
	
	
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
	
}

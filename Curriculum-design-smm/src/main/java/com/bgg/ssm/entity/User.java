package com.bgg.ssm.entity;

public class User {
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	private String user_password;
	public User() {}
	public User(String user_id,String user_password) {
		this.user_id=user_id;
		this.user_password=user_password;
	}

}

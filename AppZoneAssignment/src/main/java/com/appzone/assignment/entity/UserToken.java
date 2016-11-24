package com.appzone.assignment.entity;

public class UserToken {

	private Long token;
	private String username;

	public UserToken(Long token, String username) {
		this.token = token;
		this.username = username;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

package com.csd.authenticator;

public class UserInfo {
	
	private String userName;
	private String password;
	public void setPassword(String string) {
		this.password = string;
		
	}

	public void setUserName(String string) {
		this.userName = string;
		
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}
	
}

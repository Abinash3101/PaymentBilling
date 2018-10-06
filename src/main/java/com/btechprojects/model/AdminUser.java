package com.btechprojects.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AdminUser {
	
	@NotNull
	@Pattern(regexp = "abinash", message="Username is invalid !")
	private String username;
	@NotNull
	@Pattern(regexp = "1234", message="Password is invalid !")
	private String password;
	
	public AdminUser() {
		super();
	}
	public AdminUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AdminUser [username=" + username + ", password=" + password + "]";
	}
	
}

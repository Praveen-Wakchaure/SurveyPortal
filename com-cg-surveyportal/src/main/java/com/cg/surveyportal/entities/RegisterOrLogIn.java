package com.cg.surveyportal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class RegisterOrLogIn {

	@Id
	@Column(length = 25)
	private String userName;
	@Column(length = 30, nullable = false)
	private String password;
	@Column(nullable = false)
	private UserRoles role;
	
	//Constructors
	public RegisterOrLogIn() {
		super();
	}
	public RegisterOrLogIn(String userName, String password, UserRoles role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	//Getters and setters
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
	public UserRoles getRole() {
		return role;
	}
	public void setRole(UserRoles role) {
		this.role = role;
	}
	
	//To string
	@Override
	public String toString() {
		return "RegisterOrLogIn [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
}

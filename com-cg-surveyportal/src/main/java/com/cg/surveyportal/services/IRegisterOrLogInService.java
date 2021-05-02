package com.cg.surveyportal.services;

public interface IRegisterOrLogInService {

	String register(String userName, String password, String role);
	String logIn(String userName, String password);
}

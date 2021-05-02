package com.cg.surveyportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.surveyportal.services.IRegisterOrLogInService;

@RestController
public class RegisterOrLogIn {

	@Autowired
	IRegisterOrLogInService registerOrLogInService;
	
//	@PostMapping("/register/{userName}/{password}/{role}")
//	private String registerUser(@PathVariable("userName") String userName, @PathVariable("password") String password, @PathVariable("role") String role)
//	{
//		return registerOrLogInService.register(userName, password, role);
//	}
//	
//	@GetMapping("/LogIn/{userName}/{password}")
//	private String logIn(@PathVariable("userName") String userName, @PathVariable("password") String password)
//	{
//		return registerOrLogInService.logIn(userName, password);
//	}
}
package com.cg.surveyportal.exceptions;
/*
 * This class will store and send appropriate message for any exception thrown by GolbalExceptionHandler.
 */
public class ErrorDetails {

	private String message;
    private String details;
    
    //Constructors
	public ErrorDetails() {
		super();
	}
	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	
	//Getters and setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}

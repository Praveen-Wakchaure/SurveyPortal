package com.cg.surveyportal.exceptions;

public class InvalidFeedbackException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidFeedbackException() {
		
	}
	
	public InvalidFeedbackException (String msg) {
		
		super(msg);
	}

}

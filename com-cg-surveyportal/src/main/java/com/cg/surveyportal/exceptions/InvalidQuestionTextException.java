package com.cg.surveyportal.exceptions;

public class InvalidQuestionTextException extends Exception{

    
	private static final long serialVersionUID = 1L;

	public InvalidQuestionTextException(){

    }

    public InvalidQuestionTextException(String msg){
        super(msg);
    }
}

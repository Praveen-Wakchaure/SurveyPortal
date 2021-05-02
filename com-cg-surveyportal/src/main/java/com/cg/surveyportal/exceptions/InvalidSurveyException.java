package com.cg.surveyportal.exceptions;

public class InvalidSurveyException extends Exception{
   
	private static final long serialVersionUID = 1L;

	public InvalidSurveyException(){

    }

    public InvalidSurveyException(String msg){
        super(msg);
    }
}

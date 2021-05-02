package com.cg.surveyportal.exceptions;

public class InvalidSurveyorException extends Exception{

    
	private static final long serialVersionUID = 1L;

	public InvalidSurveyorException(){

    }

    public InvalidSurveyorException(String msg){
        super(msg);
    }


}

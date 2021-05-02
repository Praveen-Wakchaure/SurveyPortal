package com.cg.surveyportal.exceptions;

public class SurveyNotFoundException extends Exception{

   
	private static final long serialVersionUID = 1L;

	public SurveyNotFoundException(){
    }

    public SurveyNotFoundException(String msg){
        super(msg);
    }
}

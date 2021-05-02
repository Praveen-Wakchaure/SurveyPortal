package com.cg.surveyportal.exceptions;

public class QuestionNotFoundException extends Exception{
   
	private static final long serialVersionUID = 1L;

	public QuestionNotFoundException(){

    }

    public QuestionNotFoundException(String msg){
        super(msg);
    }
}

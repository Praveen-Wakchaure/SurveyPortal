package com.cg.surveyportal.exceptions;

public class InvalidParticipantException extends Exception{

    
	private static final long serialVersionUID = 1L;

	public InvalidParticipantException(){

    }

    public InvalidParticipantException(String msg){
        super(msg);
    }
}

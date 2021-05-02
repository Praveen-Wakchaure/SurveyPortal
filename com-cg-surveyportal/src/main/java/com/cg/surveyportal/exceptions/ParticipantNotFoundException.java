package com.cg.surveyportal.exceptions;

public class ParticipantNotFoundException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticipantNotFoundException(){

    }

    public ParticipantNotFoundException(String msg){
        super(msg);
    }
}

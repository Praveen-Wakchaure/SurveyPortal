package com.cg.surveyportal.exceptions;

/**
 *Custom exception class which will be invoked if the asked topic is not found.
 */
public class TopicNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public TopicNotFoundException(){
    }
    public TopicNotFoundException(String msg){
        super(msg);
    }
}

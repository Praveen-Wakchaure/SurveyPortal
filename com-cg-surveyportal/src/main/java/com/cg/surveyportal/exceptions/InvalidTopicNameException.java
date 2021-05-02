package com.cg.surveyportal.exceptions;

/**
 *Custom exception class which will be invoked if the asked topic name is an invalid one.
 */
public class InvalidTopicNameException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidTopicNameException() {
    }
    public InvalidTopicNameException(String msg) {
        super(msg);
    }
}

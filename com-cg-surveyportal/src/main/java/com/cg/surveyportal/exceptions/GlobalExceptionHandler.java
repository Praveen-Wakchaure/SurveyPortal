package com.cg.surveyportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 * This class will handle all the exceptions occurred in this application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private String TOPIC_NOT_FOUND = "TOPIC_NOT_FOUND";
	private String INVALID_TOPIC_NAME_EXCEPTION = "INVALID_TOPIC_NAME_EXCEPTION";	
	private String SURVEYOR_NOT_FOUND = "SURVEYOR_NOT_FOUND";
	private String INVALID_SURVEYOR_EXCEPTION = "INVALID_SURVEYOR_EXCEPTION";
	private String PARTICIPANT_NOT_FOUND = "PARTICIPANT_NOT_FOUND";
	private String INVALID_PARTICIPANT_EXCEPTION = "INVALID_PARTICIPANT_EXCEPTION";	
	private String FEEDBACK_NOT_FOUND = "FEEDBACK_NOT_FOUND";
	private String INVALID_QUESTION_TEXT_EXCEPTION = "INVALID_QUESTION_TEXT_EXCEPTION";	
	private String QUESTION_NOT_FOUND = "QUESTION_NOT_FOUND";
	private String SURVEY_NOT_FOUND = "SURVEY_NOT_FOUND";
	private String INVALID_SURVEY_EXCEPTION = "INVALID_SURVEY_EXCEPTION";	
	@ExceptionHandler(TopicNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTopicNotFoundException(TopicNotFoundException topicNotFoundException, WebRequest request) {
		String details = topicNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(TOPIC_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidTopicNameException.class)
	public ResponseEntity<ErrorDetails> handleInvalidTopicException(InvalidTopicNameException invalidTopicException, WebRequest request) {
		String details = invalidTopicException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(INVALID_TOPIC_NAME_EXCEPTION, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SurveyorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleSurveyorNotFoundException(SurveyorNotFoundException surveyorNotFoundException, WebRequest request) {
		String details = surveyorNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(SURVEYOR_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidSurveyorException.class)
	public ResponseEntity<ErrorDetails> handleInvalidSurveyorException(InvalidSurveyorException invalidSurveyorException, WebRequest request) {
		String details = invalidSurveyorException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(INVALID_SURVEYOR_EXCEPTION, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ParticipantNotFoundException.class)
	public ResponseEntity<ErrorDetails> handelParticipantNotFoundException(ParticipantNotFoundException participantNotFoundException, WebRequest request) {
		String details = participantNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(PARTICIPANT_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidParticipantException.class)
	public ResponseEntity<ErrorDetails> handleInvalidParticipantException(InvalidParticipantException invalidParticipantException, WebRequest request) {
		String details = invalidParticipantException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(INVALID_PARTICIPANT_EXCEPTION, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleFeedbackNotFoundException(FeedbackNotFoundException feedbackNotFoundException, WebRequest request) {
		String details = feedbackNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(FEEDBACK_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidQuestionTextException.class)
	public ResponseEntity<ErrorDetails> handleInvalidQuestionTextException(InvalidQuestionTextException invalidQuestionTextException, WebRequest request) {
		String details = invalidQuestionTextException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(INVALID_QUESTION_TEXT_EXCEPTION, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleQuestionNotFoundException(QuestionNotFoundException questionNotFoundException, WebRequest request) {
		String details = questionNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(QUESTION_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SurveyNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleSurveyNotFoundException(SurveyNotFoundException surveyNotFoundException, WebRequest request) {
		String details = surveyNotFoundException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(SURVEY_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidSurveyException.class)
	public ResponseEntity<ErrorDetails> handleInvalidSurveyException(InvalidSurveyException invalidSurveyException, WebRequest request) {
		String details = invalidSurveyException.getLocalizedMessage();
        ErrorDetails error = new ErrorDetails(INVALID_SURVEY_EXCEPTION, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

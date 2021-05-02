package com.cg.surveyportal.services;


import java.util.List;

import com.cg.surveyportal.entities.Feedback;
import com.cg.surveyportal.exceptions.FeedbackNotFoundException;
import com.cg.surveyportal.exceptions.ParticipantNotFoundException;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;


public interface IFeedbackService {
	
	public List<Feedback> getAll();
	public Feedback getById(long id) throws FeedbackNotFoundException;
	public Feedback removeById(Long feedbackId);
	public void addFeedback(long participantId, long surveyId, long questionId, String option) throws ParticipantNotFoundException, SurveyNotFoundException;
}

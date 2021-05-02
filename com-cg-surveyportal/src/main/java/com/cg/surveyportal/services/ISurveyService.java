package com.cg.surveyportal.services;

import java.util.List;

import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.exceptions.InvalidSurveyException;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;

public interface ISurveyService {
	public List<Survey> getAllSurveys();
	public Survey updateSurveyDescription(Long surveyId, String description) throws SurveyNotFoundException;
	public Survey getSurveyById(long id) throws SurveyNotFoundException;
	public Survey add(Survey survey) throws InvalidSurveyException;
	public void deleteAllsurveys();
	void removeSurveyById(Long id) throws SurveyNotFoundException;
	void closeSurvey(long id) throws SurveyNotFoundException;
}

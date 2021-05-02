package com.cg.surveyportal.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.exceptions.InvalidSurveyException;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;
import com.cg.surveyportal.repositories.ISurveyRepository;
import com.cg.surveyportal.services.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {
	
	@Autowired
	ISurveyRepository surveyRepository;
	
	//getting all Survey record by using the method findaAll() of JpaRepository
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> surveyById = surveyRepository.findAll();
		return surveyById;
	}
	//getting a specific Survey record using the method findById() of JpaRepository
	@Override
	public Survey getSurveyById(long id) throws SurveyNotFoundException {
		return surveyRepository.findById(id).orElseThrow(()-> new SurveyNotFoundException("Invalid SurveyId"));
	}
	//deleting all surveys
	@Override
	public void deleteAllsurveys() {
		surveyRepository.deleteAll(); 
	}
    //updating details of specific Survey
	@Override
	public Survey updateSurveyDescription(Long surveyId, String description) throws SurveyNotFoundException {
		Survey survey=surveyRepository.findById(surveyId).get();
		survey.setDescription(description);
		surveyRepository.save(survey);
		return survey;
	}
	//Adding new Surveys with details to the database
	@Override
	public Survey add(Survey survey) throws InvalidSurveyException {
		surveyRepository.save(survey);
		return survey;
	}
	//deleting a specific record by using the method deleteById() of JpaRepository
	@Override
	public void removeSurveyById(Long id) throws SurveyNotFoundException {
		surveyRepository.deleteById(id);
	}
	@Override
	public void closeSurvey(long id) throws SurveyNotFoundException {
		Survey survey = this.getSurveyById(id);
		survey.setIsActive(false);
		surveyRepository.save(survey);
	}
}

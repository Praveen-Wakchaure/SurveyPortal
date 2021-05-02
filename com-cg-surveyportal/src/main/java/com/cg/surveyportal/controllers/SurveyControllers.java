package com.cg.surveyportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.exceptions.InvalidSurveyException;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;
import com.cg.surveyportal.exceptions.TopicNotFoundException;
import com.cg.surveyportal.services.ISurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyControllers {
	
	@Autowired
	private ISurveyService surveyService;
	
	//creating a get mapping that retrieves the details of all Surveys
	@GetMapping("/allsurveys")
	public List<Survey> getAllSurveys() {
		return surveyService.getAllSurveys();
	}
	
	//creating a get mapping that shows the Survey details by surveyId
	@GetMapping("/getbyid/{surveyId}")
	public Survey getSurveyById(@PathVariable("surveyId") Long surveyId) throws SurveyNotFoundException
	{
			return surveyService.getSurveyById(surveyId);
	}
	
	//creating a delete mapping that delete all the surveys present
//	@DeleteMapping("/delete/all")
//	private void deleteAllsurveys()
//	{
//		surveyService.deleteAllsurveys();
//	}

	//creating a delete mapping that deletes a specified Survey
	@DeleteMapping("/remove/{id}")
	public void removeSurveyById(@PathVariable("id") long id) throws SurveyNotFoundException {
		surveyService.removeSurveyById(id);
	}
	
	//Deactivating a survey
	@PutMapping("/close/{surveyId}")
	public void closeSurvey(@PathVariable("surveyId") Long surveyId) throws SurveyNotFoundException {
		surveyService.closeSurvey(surveyId);
	}

	//creating put mapping that updates the Survey details
	@PutMapping("/update/{surveyId}/{description}")
	public Survey updateSurveyDescription(@PathVariable("surveyId") Long surveyId,@PathVariable("description") String description) throws SurveyNotFoundException {
		return surveyService.updateSurveyDescription(surveyId,description);
	}
	
	//creating post mapping that post the Survey detail in the database
	@PostMapping("/add")
	public Survey add(@RequestBody Survey survey) throws InvalidSurveyException, TopicNotFoundException {
		surveyService.add(survey);
		return survey;
	}
}
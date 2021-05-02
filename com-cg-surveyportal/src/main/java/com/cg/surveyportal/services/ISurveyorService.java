package com.cg.surveyportal.services;

import java.util.List;

import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;

public interface ISurveyorService {
	public Surveyor getById(Long surveyorId) throws SurveyorNotFoundException;
	public List<Surveyor> getAllSurveyors();
	public Surveyor getByUsername(String username) throws InvalidSurveyorException;
	public String removeById(Long surveyorId) throws InvalidSurveyorException;
	public String add(Surveyor surveyor) throws InvalidSurveyorException;
	public String update(Surveyor surveyor)throws InvalidSurveyorException,SurveyorNotFoundException;
	public Long getRecordsCount(); 
	public String removeAllRecords();
}

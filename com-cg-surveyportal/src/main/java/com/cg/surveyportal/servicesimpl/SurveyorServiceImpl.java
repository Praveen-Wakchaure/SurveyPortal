package com.cg.surveyportal.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.repositories.ISurveyorRepository;
import com.cg.surveyportal.services.ISurveyorService;
@Service
public class SurveyorServiceImpl implements ISurveyorService {

	@Autowired
	ISurveyorRepository surveyorRepository;

	@Override
	public List<Surveyor> getAllSurveyors() {
		return surveyorRepository.findAll();
		
	}
	@Override
	public Surveyor getById(Long surveyorId) throws SurveyorNotFoundException {
		
		return surveyorRepository.findById(surveyorId).orElseThrow(()-> new SurveyorNotFoundException("Invalid Surveyor Id"));
	}
	@Override
	public Surveyor getByUsername(String username) throws InvalidSurveyorException {
		
		Surveyor sv = surveyorRepository.findByUsername(username);
		if(sv == null)
		{
			throw new InvalidSurveyorException("Invalid Username");
		}
		return sv;
	}
	@Override
	public String removeById(Long surveyorId) throws InvalidSurveyorException {
		
		Surveyor sv = surveyorRepository.findById(surveyorId).orElseThrow(()-> new InvalidSurveyorException("Invalid Surveyor Id"));
		surveyorRepository.deleteById(sv.getId());
		return "Data Deleted Successfully";
		
	}
	@Override
	public String add(Surveyor surveyor) throws InvalidSurveyorException {
		
		surveyorRepository.save(surveyor);
		return "Surveyor Added Successfully";
	}
	@Override
	public String update(Surveyor surveyor) throws InvalidSurveyorException, SurveyorNotFoundException {
		
		surveyorRepository.save(surveyor);
		return "Surveyor Updated Successfully";
	}
	@Override
	public Long getRecordsCount() {
		
		return surveyorRepository.count();
	}
	@Override
	public String removeAllRecords() {
		
		surveyorRepository.deleteAll();
		return "All Records Deleted ";
	}
}

package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.Survey;

public interface ISurveyRepository extends JpaRepository<Survey, Long> {
	
	

}

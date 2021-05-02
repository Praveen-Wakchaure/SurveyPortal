package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.Surveyor;

public interface ISurveyorRepository extends JpaRepository<Surveyor, Long> {

	public Surveyor findByUsername(String userName);
}

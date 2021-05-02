package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.Feedback;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long>{

}

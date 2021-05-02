package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.surveyportal.entities.Question;


public interface IQuestionRepository extends JpaRepository<Question,Long> {

}
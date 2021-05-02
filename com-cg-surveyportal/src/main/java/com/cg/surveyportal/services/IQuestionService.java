package com.cg.surveyportal.services;

import java.util.List;

import com.cg.surveyportal.entities.Question;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;


public interface IQuestionService {

    public Question getById(long id) ;
    public List<Question> getQuestionDetails();
    public Question removeById(Long questionId);
    public Question updateQuestion(long questionId,String questionText);
	public Question addQuestion(String questionText, Long surveyId) throws SurveyNotFoundException;
	public void setOptionDefault(Question question);
}
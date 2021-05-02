package com.cg.surveyportal.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.surveyportal.entities.Question;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;
import com.cg.surveyportal.repositories.IQuestionRepository;
import com.cg.surveyportal.services.IQuestionService;
import com.cg.surveyportal.services.ISurveyService;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	private IQuestionRepository questionRepository;
	@Autowired
	private ISurveyService surveyService;
	
	@Override
	public Question getById(long questionId) {
    Question questionById = questionRepository.findById(questionId).get();
		return questionById;
	}
	@Override
   public Question updateQuestion(long questionId,String questionText){
		Question updateQuestion = questionRepository.findById(questionId).get();
	    updateQuestion.setQuestionText(questionText);
		questionRepository.save(updateQuestion);
		return updateQuestion;
	}
	@Override
	public Question removeById(Long questionId) {
		Question deletedQuestion = questionRepository.findById(questionId).get();
		questionRepository.deleteById(questionId);
		return deletedQuestion;
	}
	@Override
	public List<Question> getQuestionDetails() {
		return (List<Question>) questionRepository.findAll();
	}
	@Override
	public void setOptionDefault(Question question) {
		question.setOption1("Very satisfied");
		question.setOption2("Satisfied");
		question.setOption3("Dissatisfied");
		question.setOption4("Very dissatisfied");
	}
	@Override
	public Question addQuestion(String questionText, Long surveyId) throws SurveyNotFoundException {
		Question newQuestion = new Question();
		newQuestion.setqId(201l);
		newQuestion.setQuestionText(questionText);
		this.setOptionDefault(newQuestion);
		newQuestion.setSurvey(surveyService.getSurveyById(surveyId));
		questionRepository.save(newQuestion);
		return newQuestion;
	}
}
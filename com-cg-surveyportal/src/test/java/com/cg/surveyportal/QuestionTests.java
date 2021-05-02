package com.cg.surveyportal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.surveyportal.entities.Question;
import com.cg.surveyportal.exceptions.InvalidQuestionTextException;
import com.cg.surveyportal.exceptions.QuestionNotFoundException;
import com.cg.surveyportal.repositories.IQuestionRepository;
import com.cg.surveyportal.services.IQuestionService;

@SpringBootTest
public class QuestionTests {
		@Autowired
		IQuestionService questionService;
		@MockBean
		IQuestionRepository questionRepository;
		Question p;
		@BeforeEach
		public void init() {
			p = new Question();
			p.setqId(20l);
			p.setQuestionText("How would you rate your experience you have with this organization?");
			p.setOption1("Very satisfied");
			p.setOption2("Satisfied");
			p.setOption3("Dissatisfied");
			p.setOption4("Very dissatisfied");
				
		}
		@Test
		@DisplayName ("Positive Test case for getting Question ID by ID")
		public void testgetqIdPositive() throws QuestionNotFoundException {
			Mockito.when(questionRepository.findById(p.getqId())).thenReturn(Optional.of(p));
			assertEquals(p,questionService.getById(20l));
		}
		@Test
		@DisplayName ("Negative Test case for getting Question by ID")
		public void testgetqIdNegative() {
			Mockito.when(questionRepository.findById(p.getqId())).thenReturn(Optional.of(p));
			Assertions.assertThrows(NoSuchElementException.class, ()-> questionService.getById(21l));
		}
		@Test
		@DisplayName ("Positive test case for getting all Question")
		public void testgetallQuestionPositive() throws QuestionNotFoundException {
			Mockito.when(questionRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList()));
			assertEquals(1, questionService.getQuestionDetails().size());
		}
		@Test
		@DisplayName ("Negative test case for getting all Question")
		public void testgetallQuestionNegative() throws QuestionNotFoundException 
		{
			
			Mockito.when(questionRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList()));
			assertNotEquals(2, questionService.getQuestionDetails().size());
		}
		@Test
		@DisplayName("Positive testcase for updating Question")
		public void testUpdateQuestion() throws InvalidQuestionTextException  {
			String newQuestionText = "How would you rate your experience in your last trip?";
			p.setQuestionText(newQuestionText);
			Mockito.when(questionRepository.save(p)).thenReturn(p);
			assertEquals(p.getQuestionText(),newQuestionText);
		}
		@Test
		@DisplayName("Negative testcase for updating Question")
		public void UpdateQuestionNegative() throws InvalidQuestionTextException {
			String newQuestionText = "How would you rate your experience in your last trip?";
			String oldQuestionText = p.getQuestionText();
			p.setQuestionText(newQuestionText);
			Mockito.when(questionRepository.save(p)).thenReturn(p);
			assertNotEquals(p.getQuestionText(),oldQuestionText);
		}
		@Test
		@DisplayName("Positive testcase for Remove Question by Id")
		public void testRemoveQuestion() throws QuestionNotFoundException {
			questionRepository.deleteById(p.getqId());
			assertEquals(0, questionRepository.count());
		}
		@Test
		@DisplayName("Negative testcase for Remove Question by Id")
		public void testRemoveQuestionNegative() throws QuestionNotFoundException {
			questionRepository.deleteById(p.getqId());
			assertNotEquals(1, questionRepository.count());
		}	
}
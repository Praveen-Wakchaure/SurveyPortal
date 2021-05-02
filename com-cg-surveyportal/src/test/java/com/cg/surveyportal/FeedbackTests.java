package com.cg.surveyportal;
 
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertNotEquals; 
 
 
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
import com.cg.surveyportal.entities.Feedback;
import com.cg.surveyportal.exceptions.FeedbackNotFoundException;
import com.cg.surveyportal.exceptions.InvalidFeedbackException; 
import com.cg.surveyportal.repositories.IFeedbackRepository;  
import com.cg.surveyportal.services.IFeedbackService;

 
	@SpringBootTest 
 	public class FeedbackTests { 
 		@Autowired 
 		IFeedbackService feedbackService; 
 		@MockBean 
 		IFeedbackRepository feedbackRepository; 
		 
		Feedback p; 
 		@BeforeEach 
		public void init() { 
			p = new Feedback(); 
 			p.setId(20l); 
 			p.setSurvey(null); 
 			p.setParticipant(null); 
 			p.setQuestion(null); 
 			p.setChosenOption(null);
 		} 
 		@Test 
 		@DisplayName ("Positive Test case for getting Feedback by ID") 
 		public void testgetById() throws FeedbackNotFoundException  
 		{ 
 		 
 			Mockito.when(feedbackRepository.findById(p.getId())).thenReturn(Optional.of(p)); 
 			assertEquals(p,feedbackService.getById(20l)); 
 		} 
 		 
 		@Test 
 		@DisplayName ("Negative Test case for getting Feedback by ID") 
 		public void testgetByIdNegative()  
 		{ 
 			Mockito.when(feedbackRepository.findById(p.getId())).thenReturn(Optional.of(p)); 
 			Assertions.assertThrows(FeedbackNotFoundException.class, ()-> feedbackService.getById(100l)); 
 		} 
 		 		 
 				 
 		@Test 
 		@DisplayName ("Positive test case for getting all Participant") 
 		public void testallfeedback() throws InvalidFeedbackException 
 		{ 
 			 
 			Mockito.when(feedbackRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList())); 
 			assertEquals(1, feedbackService.getAll().size()); 
 		} 
 		 
 		@Test 
 		@DisplayName ("Negative test case for getting all Participant") 
 		public void testallfeedbackNegative() throws InvalidFeedbackException 
 		{ 
 			 
 			Mockito.when(feedbackRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList())); 
 			assertNotEquals(2, feedbackService.getAll().size()); 
 		} 
 } 

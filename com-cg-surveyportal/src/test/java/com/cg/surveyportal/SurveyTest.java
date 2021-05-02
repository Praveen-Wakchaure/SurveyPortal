package com.cg.surveyportal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.exceptions.SurveyNotFoundException;
import com.cg.surveyportal.exceptions.TopicNotFoundException;
import com.cg.surveyportal.repositories.ISurveyRepository;
import com.cg.surveyportal.services.ISurveyService;

@SpringBootTest
public class SurveyTest {

	@Autowired
	private ISurveyService surveyService;
	@MockBean
	private ISurveyRepository surveyRepository;
	
	
	Topic topic;
	Surveyor surveyor;
	Survey survey;
	
	@BeforeEach
	public void init()
	{
		survey = new Survey();
		survey.setId(10L);
		survey.setDescription("Dear user, we would like to request you kindly give us your crucial feedback on your recent purchases of a new iphone.");
	}
	
	
	@Test
	@DisplayName ("Positive Test case for getting Partiticipant by ID")
	public void testgetById() throws SurveyNotFoundException 
	{
	
		Mockito.when(surveyRepository.findById(survey.getId())).thenReturn(Optional.of(survey));
		assertEquals(survey,surveyService.getSurveyById(10L));
	}
	

	@Test
	@DisplayName("Negative testcase for get survey detail by using ID")
	public void testGetTopicsDetailNegative() throws SurveyNotFoundException{
		Mockito.when(surveyRepository.findById(survey.getId())).thenReturn(Optional.of(survey));
		assertThrows(SurveyNotFoundException.class, ()->surveyService.getSurveyById(15L));
	}

	@Test
	@DisplayName("Positive testcase for getting all surveys")
	public void testgetAllSurveys() {
		Mockito.when(surveyRepository.findAll()).thenReturn(Stream.of(survey).collect(Collectors.toList()));
		assertEquals(1,surveyService.getAllSurveys().size());
	}
	@Test
	@DisplayName("Negative testcase for getting all surveys")
	public void testgetAllSurveysNegative() {
		Mockito.when(surveyRepository.findAll()).thenReturn(Stream.of(survey).collect(Collectors.toList()));
		assertNotEquals(0,surveyService.getAllSurveys().size());
	}
	@Test
	@DisplayName("Positive testcase for removing a survey")
	public void testremoveSurveyById() throws TopicNotFoundException {
		surveyRepository.deleteById(survey.getId());
		assertEquals(0, surveyRepository.count());
	}
	@Test
	@DisplayName("Negative testcase for removing a survey")
	public void testremoveSurveyByIdNegative() throws SurveyNotFoundException {
		surveyRepository.deleteById(survey.getId());
		assertNotEquals(1, surveyRepository.count());
	}
	
	@Test
	@DisplayName("Positive testcase for updating survey description")
	public void testupdateSurveyDescription() throws SurveyNotFoundException {
		String newSurveyDescription = "feedback on iphone service.";
		survey.setDescription(newSurveyDescription);
		Mockito.when(surveyRepository.save(survey)).thenReturn(survey);
		assertEquals(survey.getDescription(),newSurveyDescription);
	}
	@Test
	@DisplayName("Negative testcase for updating survey description")
	public void testupdateSurveyDescriptionNegative() throws SurveyNotFoundException {
		String newSurveyDescription = "feedback on iphone service.";
		String oldSurveyDescription = survey.getDescription();
		survey.setDescription(newSurveyDescription);
		Mockito.when(surveyRepository.save(survey)).thenReturn(survey);
		assertNotEquals(survey.getDescription(),oldSurveyDescription);
	}
}

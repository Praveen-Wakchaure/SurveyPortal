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


import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.InvalidTopicNameException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.exceptions.TopicNotFoundException;
import com.cg.surveyportal.repositories.ITopicRepository;
import com.cg.surveyportal.services.ITopicService;

@SpringBootTest
public class TopicServicesTest {

	@Autowired
	private ITopicService topicService;
	@MockBean
	private ITopicRepository topicRepository;
	
	Topic topic;
	Surveyor surveyor;
	
	@BeforeEach
	public void init()
	{
		topic = new Topic();
		topic.setId(101L);
		topic.setName("Lifestyle");
		topic.setDescription("Surveys on daily life of us.");
	}
	@Test
	@DisplayName("Positive testcase for get topics detail by using ID")
	public void testGetTopicsDetail() throws TopicNotFoundException{
		Mockito.when(topicRepository.findById(topic.getId())).thenReturn(Optional.of(topic));
		assertEquals(topic, topicService.getTopicDetails(topic.getId()));
	}
	@Test
	@DisplayName("Negative testcase for get topics detail by using ID")
	public void testGetTopicsDetailNegative() throws TopicNotFoundException{
		Mockito.when(topicRepository.findById(topic.getId())).thenReturn(Optional.of(topic));
		assertThrows(TopicNotFoundException.class, ()->topicService.getTopicDetails(000));
	}
	@Test
	@DisplayName("Positive testcase for get topics detail by using Name")
	public void testGetTopicsDetails() throws TopicNotFoundException, InvalidTopicNameException{
		Mockito.when(topicRepository.findByName("Lifestyle")).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertEquals(1,topicService.getTopicsDetails("Lifestyle").size());
	}
	@Test
	@DisplayName("Negative testcase for get topics detail by using Name")
	public void testGetTopicsDetailsNegative() throws TopicNotFoundException, InvalidTopicNameException{
		Mockito.when(topicRepository.findByName("Lifestyle")).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertNotEquals(0,topicService.getTopicsDetails("Lifestyle").size());
	}
	//@Test
	@DisplayName("Positive testcase for adding a topic")
	public void testAddTopic() throws SurveyorNotFoundException, InvalidSurveyorException, TopicNotFoundException, InvalidTopicNameException {
		Mockito.when(topicRepository.save(topic)).thenReturn(topic);
		assertEquals(topic.toString(), topicService.addTopic("Lifestyle", "Surveys on daily life of us.", null).toString());
	}
	//@Test
	@DisplayName("Negative testcase for adding a topic")
	public void testAddTopicNegagtive() throws SurveyorNotFoundException, InvalidSurveyorException, TopicNotFoundException, InvalidTopicNameException {
		Topic anotherTopic = new Topic();
		topic.setName("Citylife");
		topic.setDescription("Surveys on daily city life activities.");
		Mockito.when(topicRepository.save(anotherTopic)).thenReturn(anotherTopic);
		assertNotEquals(anotherTopic.toString(), topicService.addTopic("Lifestyle", "Surveys on daily life of us.", null).toString());
	}
	@Test
	@DisplayName("Positive testcase for getting all topic")
	public void testGetAllTopic() {
		Mockito.when(topicRepository.findAll()).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertEquals(1,topicService.getAllTopic().size());
	}
	@Test
	@DisplayName("Negative testcase for getting all topic")
	public void testGetAllTopicNegative() {
		Mockito.when(topicRepository.findAll()).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertNotEquals(0,topicService.getAllTopic().size());
	}
	@Test
	@DisplayName("Positive testcase for removing a topic")
	public void testRemoveTopic() throws TopicNotFoundException {
		topicRepository.deleteById(topic.getId());
		assertEquals(0, topicRepository.count());
	}
	@Test
	@DisplayName("Negative testcase for removing a topic")
	public void testRemoveTopicNegative() throws TopicNotFoundException {
		topicRepository.deleteById(topic.getId());
		assertNotEquals(1, topicRepository.count());
	}
	@Test
	@DisplayName("Positive testcase for count number of topics")
	public void testGetTopicCount() throws TopicNotFoundException {
		Long numberOfTopics =0L;
		Mockito.when(topicRepository.count()).thenReturn(numberOfTopics);
		assertEquals(numberOfTopics,topicService.getTopicCount());
	}
	@Test
	@DisplayName("Negative testcase for count number of topics")
	public void testGetTopicCountNegative() throws TopicNotFoundException {
		Long numberOfTopics =0L;
		Mockito.when(topicRepository.count()).thenReturn(numberOfTopics);
		assertNotEquals(numberOfTopics+1,topicService.getTopicCount());
	}
	@Test
	@DisplayName("Positive testcase for updating topic name")
	public void testUpdateTopicName() throws TopicNotFoundException {
		String newTopicName = "City LifeStyle";
		topic.setName(newTopicName);
		Mockito.when(topicRepository.save(topic)).thenReturn(topic);
		assertEquals(topic.getName(),newTopicName);
	}
	@Test
	@DisplayName("Negative testcase for updating topic name")
	public void UpdateTopicNameNegative() throws TopicNotFoundException {
		String newTopicName = "City LifeStyle";
		String oldTopicName = topic.getName();
		topic.setName(newTopicName);
		Mockito.when(topicRepository.save(topic)).thenReturn(topic);
		assertNotEquals(topic.getName(),oldTopicName);
	}
	@Test
	@DisplayName("Positive testcase for updating topic description")
	public void testUpdateTopicDescription() throws TopicNotFoundException {
		String newTopicDescription = "Surveys on daily city life of us.";
		topic.setDescription(newTopicDescription);
		Mockito.when(topicRepository.save(topic)).thenReturn(topic);
		assertEquals(topic.getDescription(),newTopicDescription);
	}
	@Test
	@DisplayName("Negative testcase for updating topic description")
	public void testUpdateTopicDescriptionNegative() throws TopicNotFoundException {
		String newTopicDescription = "Surveys on daily city life of us.";
		String oldTopicDescription = topic.getName();
		topic.setName(newTopicDescription);
		Mockito.when(topicRepository.save(topic)).thenReturn(topic);
		assertNotEquals(topic.getDescription(),oldTopicDescription);
	}
	@Test
	@DisplayName("Posivite testcase for geting topics with no surveys")
	public void testGetTopicsWithNoSurveys() {
		Mockito.when(topicService.getTopicsWithNoSurveys()).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertEquals(1,topicService.getAllTopic().size());
	}
	@Test
	@DisplayName("Negative testcase for geting topics with no surveys")
	public void testGetTopicsWithNoSurveysNegative() {
		Mockito.when(topicService.getTopicsWithNoSurveys()).thenReturn(Stream.of(topic).collect(Collectors.toList()));
		assertNotEquals(0,topicService.getAllTopic().size());
	}
}

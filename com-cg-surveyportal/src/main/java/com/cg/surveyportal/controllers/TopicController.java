package com.cg.surveyportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.InvalidTopicNameException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.exceptions.TopicNotFoundException;
import com.cg.surveyportal.services.ITopicService;

/**
 *It is the controller class for topic which contains all the end points
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private ITopicService topicService;
	
	/**
	 * Show all the topics presents.
	 * 
	 * @return a list of all topics with an OK http status.
	 */
	@GetMapping("/alltopics")
	public ResponseEntity<List<Topic>> getAllTopics() 
	{
		return new ResponseEntity<List<Topic>>(topicService.getAllTopic(), HttpStatus.OK);
	}
	/**
	 * Show a topics with a particular ID.
	 * 
	 * @param id : Topic ID
	 * @return the topic details of a topic by ID with a FOUND http status.
	 * @throws TopicNotFoundException : If the topic is not found.
	 */
	@GetMapping("/topicbyid/{id}")
	public ResponseEntity<Topic> getTopicDetails(@PathVariable("id") long id) throws TopicNotFoundException
	{
		return new ResponseEntity<Topic>(topicService.getTopicDetails(id), HttpStatus.FOUND);
	}
	/**
	 * Show all the topics with a particular name.
	 * 
	 * @param name : Name of the topic
	 * @return the topic details of a topic by name with a FOUND http status.
	 * @throws TopicNotFoundException : If the topic is not found.
	 * @throws InvalidTopicNameException : If the name of the topic is invalid.
	 */
	@GetMapping("/topicbyname/{name}")
	public ResponseEntity<List<Topic>> getTopicsDetails(@PathVariable("name") String name) throws TopicNotFoundException, InvalidTopicNameException
	{
		//return topicService.getTopicsDetails(name);
		return new ResponseEntity<List<Topic>>(topicService.getTopicsDetails(name), HttpStatus.FOUND);
	}
	/**
	 * Show the number of topic present.
	 * 
	 * @return number of topics present as a Long with an OK http status.
	 */
	@GetMapping("/topiccount")
	public ResponseEntity<Long> getTopicCount()
	{
		return new ResponseEntity<Long>(topicService.getTopicCount(), HttpStatus.OK);
	}
	/**
	 * Show the number of surveys done on a particular topic.
	 * 
	 * @param name : Name of the topic
	 * @return the number of survey on a topic as long with an OK http status.
	 * @throws TopicNotFoundException : If the topic is not found.
	 * @throws InvalidTopicNameException : If the name of the topic is invalid.
	 */
	@GetMapping("/surveycountontopic/{name}")
	public ResponseEntity<Long> getSurveyDoneOnTopic(@PathVariable("name") String name) throws TopicNotFoundException, InvalidTopicNameException
	{
		return new ResponseEntity<Long>(topicService.getSurveyCountOnTopic(name), HttpStatus.OK);
	}
	/**
	 * Show all topic with no surveys done on them.
	 * 
	 * @return a list of topics with no surveys done on them with a FOUND http status.
	 */
	@GetMapping("/topicwithnosurvey")
	public ResponseEntity<List<Topic>> getTopicsWithNoSurveys() 
	{
		return new ResponseEntity<List<Topic>>(topicService.getTopicsWithNoSurveys(), HttpStatus.FOUND);
	}
	/**
	 * Create a new topic. 
	 * 
	 * @param name : Name of the topic
	 * @param description : Description of the topic
	 * @param surveyorUsername : Surveyor's user name who is creating the topic
	 * @return the details of the newly created topic.
	 * @throws SurveyorNotFoundException : If the surveyor is not found.
	 * @throws InvalidSurveyorException : If the surveyor is invalid.
	 * @throws TopicNotFoundException : If the topic is not found.
	 * @throws InvalidTopicNameException : If the name of the topic is invalid. 
	 */
	@PostMapping("/addtopic/{name}/{description}/{surveyorUsername}")
	public ResponseEntity<Topic> addNewTopic(@PathVariable("name") String name, @PathVariable("description") String description, @PathVariable("surveyorUsername") String surveyorUsername ) throws SurveyorNotFoundException, InvalidSurveyorException, TopicNotFoundException, InvalidTopicNameException
	{
		return new ResponseEntity<Topic>(topicService.addTopic(name, description, surveyorUsername), HttpStatus.CREATED);
	}
	/**
	 *Update the name of the topic.
     * 
     * @param id : Topic ID
     * @param name : New topic name
     * @return the details of the of the topic with new name.
     * @throws TopicNotFoundException : If the topic is not found.
	 * @throws InvalidTopicNameException : If the name of the topic is invalid. 
	 */
	@PutMapping("/modify/name/{id}/{name}")
	public ResponseEntity<Topic> modifyTopicName(@PathVariable("id") long id, @PathVariable("name") String name) throws TopicNotFoundException, InvalidTopicNameException
	{
		return new ResponseEntity<Topic>(topicService.updateTopicName(id, name), HttpStatus.OK);
	}
	/**
     * Update the description of the topic.
     * 
     * @param id : Topic ID
     * @param description : New topic description.
     * @return the details of the of the topic with new description.
     * @throws TopicNotFoundException : If the topic is not found.
     */
	@PutMapping("/modify/description/{id}/{description}")
	public ResponseEntity<Topic> modifyTopicDescription(@PathVariable("id") long id, @PathVariable("description") String description) throws TopicNotFoundException
	{
		return new ResponseEntity<Topic>(topicService.updateTopicDescription(id, description), HttpStatus.OK);
	}
	/**
	 * Change the surveyor of a topic.
	 * 
	 * @param topicId : Topic ID
	 * @param surveyorId : New surveyor ID
	 * @return topic details with the new surveyor data.
	 * @throws TopicNotFoundException : If the topic is not found.
	 * @throws SurveyorNotFoundException : If the surveyor is not found
	 */
	@PutMapping("/modify/surveyor/{id}/{surveyorid}")
	public ResponseEntity<Topic> modifyTopicSurveyor(@PathVariable("id") long id, @PathVariable("surveyorid") long surveyorid) throws TopicNotFoundException, SurveyorNotFoundException
	{
		return new ResponseEntity<Topic>(topicService.changeSurveyor(id, surveyorid), HttpStatus.OK);
	}
	/**
     * Remove a particular topic based on ID.
     * 
     * @param id : Topic ID
     * @return the topic details that is been removed.
     * @throws TopicNotFoundException : If the topic is not found.
     */
	@DeleteMapping("/removetopic/{id}")
	public ResponseEntity<Topic> removeTopic(@PathVariable("id") long id) throws TopicNotFoundException
	{
		return new ResponseEntity<Topic>(topicService.removeTopic(id), HttpStatus.OK);
	}
}

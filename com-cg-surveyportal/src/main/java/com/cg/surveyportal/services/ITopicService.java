package com.cg.surveyportal.services;

import java.util.List;

import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.InvalidTopicNameException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.exceptions.TopicNotFoundException;

/**
 * Contains business logics for the topics.
 * 
 */
public interface ITopicService {

	/**
	 * Search for a particular topic by it's ID
	 * 
	 * @param id : Topic ID
	 * @return  All topic detail of topic with the given id.
	 * @throws TopicNotFoundException : If the topic is not found.
	 */
	public Topic getTopicDetails(long id) throws TopicNotFoundException;
    /**
     * Search for all the topic by there name
     * 
     * @param name : Topic name
     * @return  All topic detail of topics with the given name.
     * @throws TopicNotFoundException : If the topic is not found.
     */
    public List<Topic> getTopicsDetails(String name) throws TopicNotFoundException;
    /**
     * Remove a particular topic have the passed id
     * 
     * @param id : Topic ID
     * @return The topic details that is been removed.
     * @throws TopicNotFoundException : If the topic is not found.
     */
    public Topic removeTopic(long id) throws TopicNotFoundException;
    /**
     * Create a new topic. 
     * 
     * @param name : Name of the topic
     * @param description : Description for the topic
     * @param surveyorUsername : Surveyor's user name who is creating the topic
     * @return the details of the newly created topic.
     * @throws SurveyorNotFoundException : If the surveyor is not found.
     * @throws InvalidSurveyorException : If the surveyor is invalid.
     * @throws TopicNotFoundException : If the topic is not found.
     */
    public Topic addTopic(String name, String description, String surveyorUsername) throws SurveyorNotFoundException, InvalidSurveyorException, InvalidTopicNameException, TopicNotFoundException;
    /**
     * Update the name of the topic.
     * 
     * @param id : Topic ID
     * @param name : New topic name
     * @return the details of the of the topic with new name.
     * @throws TopicNotFoundException : If the topic is not found.
     * @throws InvalidTopicNameException: If the topic name is invalid.
     */
    public Topic updateTopicName(long id, String name) throws TopicNotFoundException, InvalidTopicNameException;
    /**
     * Update the description of the topic.
     * 
     * @param id : Topic ID
     * @param description : New topic description.
     * @return the details of the of the topic with new description.
     * @throws TopicNotFoundException : If the topic is not found.
     */
    public Topic updateTopicDescription(long id, String description) throws TopicNotFoundException;
    
    //public void populateTopic() throws InvalidSurveyorException;
    /**
     * Get details of all the topics.
     * 
     * @return Details of all the topics as a List.
     */
    public List<Topic> getAllTopic();
    /**
     * Count the number of topics.
     * 
     * @return a long value with number of topics present.
     */
    public long getTopicCount();
    /**
     * Count the number of surveys done on a topics.
     * 
     * @param name : Name of the topic.
     * @return a long value with number of surveys done a particular topics.
     * @throws TopicNotFoundException : If the topic is not found.
     */
    public long getSurveyCountOnTopic(String name) throws TopicNotFoundException;
	/**
	 * This will add surveys to the a topic
	 * 
	 * @param survey : Survey to be added.
	 * @param topicName : Name of the topic on to which a survey is to be added.
	 * @throws TopicNotFoundException : If the topic is not found.
	 */
	public void addSurveysToTopic(Survey survey, String topicName) throws TopicNotFoundException;
	/**
	 * Change the surveyor of a topic.
	 * 
	 * @param topicId : Topic ID
	 * @param surveyorId : New surveyor ID
	 * @return topic details with the new surveyor data.
	 * @throws TopicNotFoundException : If the topic is not found.
	 * @throws SurveyorNotFoundException : If the surveyor is not found
	 */
	public Topic changeSurveyor(long topicId, long surveyorId) throws TopicNotFoundException, SurveyorNotFoundException;
	/**
	 * This will give the topics detail which has no surveys done on them.
	 * 
	 * @return a LIst of topics which has no surveys done on them.
	 */
	public List<Topic> getTopicsWithNoSurveys();
	
}

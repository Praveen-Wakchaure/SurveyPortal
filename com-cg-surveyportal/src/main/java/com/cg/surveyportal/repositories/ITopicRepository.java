package com.cg.surveyportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.exceptions.TopicNotFoundException;

/**
 * This interface deals with all the basic database operations with the help
 * of predefined interface called JpaRepository.
 */
public interface ITopicRepository extends JpaRepository<Topic, Long> {
	
	/**
	 * @param name
	 * @return the topic details of topic with a particular name
	 * @throws TopicNotFoundException : If the topic is not found.
	 */
	public List<Topic> findByName(String name) throws TopicNotFoundException;
}

package com.cg.surveyportal.services;

import java.util.List;

import com.cg.surveyportal.entities.Feedback;
import com.cg.surveyportal.entities.Participant;
import com.cg.surveyportal.exceptions.InvalidParticipantException;
import com.cg.surveyportal.exceptions.ParticipantNotFoundException;

public interface IParticipantService {

	public String register(String userName, String password) throws  InvalidParticipantException;
    public Participant findParticipantById(Long participantId) throws ParticipantNotFoundException;
    public String update(Long id, String firstName, String lastName, String userName)throws InvalidParticipantException,ParticipantNotFoundException;
    public String add(String firstName, String lastName, String userName)throws InvalidParticipantException,ParticipantNotFoundException;
    public String delete(Long participantId) throws InvalidParticipantException;
    public List<Participant> getAllParticipant();
    public void addFeedbackToParticipant(Long id, Feedback feedback) throws ParticipantNotFoundException;
    public Long getRecordsCount(); 
}



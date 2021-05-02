package com.cg.surveyportal.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.surveyportal.entities.Feedback;
import com.cg.surveyportal.entities.Participant;
import com.cg.surveyportal.exceptions.InvalidParticipantException;
import com.cg.surveyportal.exceptions.ParticipantNotFoundException;
import com.cg.surveyportal.repositories.IParticipantRepository;
import com.cg.surveyportal.services.IParticipantService;
import com.cg.surveyportal.services.IRegisterOrLogInService;

@Service
public class ParticipantServiceImpl  implements IParticipantService
{
	@Autowired
	IParticipantRepository iparticipantrepository;
	@Autowired
	IRegisterOrLogInService registerOrLogInService;

	@Override
	public String register(String userName, String password) throws InvalidParticipantException 
	{
		return registerOrLogInService.register(userName, password, "PARTICIPANT");
	}
	@Override
	public Participant findParticipantById(Long participantId) throws ParticipantNotFoundException {
		return iparticipantrepository.findById(participantId).orElseThrow(()-> new ParticipantNotFoundException("Invalid ParticipantId"));
	}
	@Override
	public String update(Long id, String firstName, String lastName, String userName) throws InvalidParticipantException, ParticipantNotFoundException {
		 Participant participant = iparticipantrepository.findById(id).get();
		 participant.setFirstName(firstName);
		 participant.setLastName(lastName);
		 participant.setUsername(userName);
		 iparticipantrepository.save(participant);
		 return "Data Update Succesfully";
	}
	@Override
	public String delete(Long participantId) throws InvalidParticipantException {
		Participant participant = iparticipantrepository.findById(participantId).orElseThrow(()-> new InvalidParticipantException("Invalid ParticipantId"));
		participant.getFeedback().clear();
		iparticipantrepository.deleteById(participantId);
		return "Data Deleted Succesfully";
	}
	@Override
	public List<Participant> getAllParticipant() {
		return iparticipantrepository.findAll();
	}
	@Override
	public void addFeedbackToParticipant(Long id ,Feedback feedback) throws ParticipantNotFoundException {
		Participant participant = this.findParticipantById(id);
		participant.getFeedback().add(feedback);
	}
	@Override
	public Long getRecordsCount() {
		return iparticipantrepository.count();
	}
	@Override
	public String add(String firstName, String lastName, String userName)throws InvalidParticipantException, ParticipantNotFoundException {
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		participant.setLastName(lastName);
		participant.setUsername(userName);
		iparticipantrepository.save(participant);
		return "Data added Succesfully";
	}
}

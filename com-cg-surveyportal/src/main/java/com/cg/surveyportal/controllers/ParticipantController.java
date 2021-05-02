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

import com.cg.surveyportal.entities.Participant;
import com.cg.surveyportal.exceptions.InvalidParticipantException;
import com.cg.surveyportal.exceptions.ParticipantNotFoundException;
import com.cg.surveyportal.servicesimpl.ParticipantServiceImpl;

@RestController
@RequestMapping("/participant")
public class ParticipantController 
{
	@Autowired
	ParticipantServiceImpl participantserviceimpl;
	
	@GetMapping("/count")
	public ResponseEntity<Long> countRecords(){
		return new ResponseEntity<>(participantserviceimpl.getRecordsCount(),HttpStatus.ACCEPTED);
	}
		
	@GetMapping("/allparticipant")
	public List<Participant> getParticipant(){
		return participantserviceimpl.getAllParticipant();
	}
	
	@GetMapping("/{participantId}")
	public Participant getParticipantbyid(@PathVariable("participantId") Long participantId) throws NumberFormatException, ParticipantNotFoundException{
		return participantserviceimpl.findParticipantById(participantId);
	}
	
	@PostMapping("/register/{userName}/{password}")
	public ResponseEntity<String> registerParticipant(@PathVariable("userName") String userName, @PathVariable("password") String password) throws InvalidParticipantException{
		return new ResponseEntity<>(participantserviceimpl.register(userName, password),HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}/{firstName}/{lastName}/{userName}")
	public ResponseEntity <String> updateParticipant(@PathVariable("id") Long id, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("userName") String userName) throws InvalidParticipantException, ParticipantNotFoundException{
		return new ResponseEntity<>(participantserviceimpl.update(id,firstName, lastName, userName),HttpStatus.OK);
	}
	
	@PostMapping("/add/{firstName}/{lastName}/{userName}")
	public ResponseEntity <String> addParticipant(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("userName") String userName) throws InvalidParticipantException, ParticipantNotFoundException{
		return new ResponseEntity<>(participantserviceimpl.add(firstName, lastName, userName),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{participantId}")
	public ResponseEntity<String> deleteParticipant(@PathVariable Long participantId) throws NumberFormatException, InvalidParticipantException
	{
		return new ResponseEntity<>( participantserviceimpl.delete(participantId),HttpStatus.OK);
	}
}
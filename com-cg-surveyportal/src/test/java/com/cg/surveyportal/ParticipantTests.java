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

import com.cg.surveyportal.entities.Participant;
import com.cg.surveyportal.exceptions.InvalidParticipantException;
import com.cg.surveyportal.exceptions.ParticipantNotFoundException;
import com.cg.surveyportal.repositories.IParticipantRepository;
import com.cg.surveyportal.services.IParticipantService;

	@SpringBootTest

	public class ParticipantTests {
		
		@Autowired
		IParticipantService participantService;
		
		@MockBean
		IParticipantRepository participantRepository;
		
		Participant p;
		
		
		@BeforeEach
		public void init() {
			p = new Participant();
			p.setId(20l);
			p.setFirstName("abc");
			p.setLastName("xyz");
			p.setUsername("cvb");
			p.setFeedback(null);
		}
		
		@Test
		@DisplayName ("Positive Test case for getting Partiticipant by ID")
		public void testgetById() throws ParticipantNotFoundException 
		{
		
			Mockito.when(participantRepository.findById(p.getId())).thenReturn(Optional.of(p));
			assertEquals(p,participantService.findParticipantById(20l));
		}
		
		@Test
		@DisplayName ("Negative Test case for getting Partiticipant by ID")
		public void testgetByIdNegative() 
		{
			Mockito.when(participantRepository.findById(p.getId())).thenReturn(Optional.of(p));
			Assertions.assertThrows(ParticipantNotFoundException.class, ()-> participantService.findParticipantById(21l));
		}
		@Test
		@DisplayName("Negative testcase for updating participant username")
		public void UpdateUserNameNegative() throws ParticipantNotFoundException {
			String newUsername = "sonu";
			String oldUsername = p.getUsername();
			p.setUsername(newUsername);
			Mockito.when(participantRepository.save(p)).thenReturn(p);
			assertNotEquals(p.getUsername(),oldUsername);
		}
		@Test
		@DisplayName("Positive testcase for updating participant username")
		public void testUpdateUserName() throws ParticipantNotFoundException {
			String newUsername = "monu";
			p.setUsername(newUsername);
			Mockito.when(participantRepository.save(p)).thenReturn(p);
			assertEquals(p.getUsername(),newUsername);
		}
		@Test
		@DisplayName ("Positive test case for getting all Participant")
		public void testallparticipant() throws InvalidParticipantException
		{
			
			Mockito.when(participantRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList()));
			assertEquals(1, participantService.getAllParticipant().size());
		}
		
		@Test
		@DisplayName ("Negative test case for getting all Participant")
		public void testallparticipantNegative() throws InvalidParticipantException
		{
			
			Mockito.when(participantRepository.findAll()).thenReturn(Stream.of(p).collect(Collectors.toList()));
			assertNotEquals(2, participantService.getAllParticipant().size());
		}
		
		
}


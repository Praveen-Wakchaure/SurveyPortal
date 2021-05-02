package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.Participant;

public interface IParticipantRepository extends JpaRepository<Participant, Long> {

	public Participant findByUsername(String username);
}

package com.cg.surveyportal.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Participant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column(length = 20)	
    private String username;
	@Column(length = 20)
    private String firstName;
	@Column(length = 20)
    private String lastName;
	
	
    @OneToMany(mappedBy="participant")
    @JsonManagedReference("participant_feedback")
    private List<Feedback> feedback;

	public Participant(Long id, String username, String firstName, String lastName, List<Feedback> feedback) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feedback = feedback;
	}

	public Participant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}

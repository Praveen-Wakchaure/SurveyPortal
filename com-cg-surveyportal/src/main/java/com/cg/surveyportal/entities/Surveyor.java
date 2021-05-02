package com.cg.surveyportal.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Surveyor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column(length = 20)	
    private String username;
	@Column(length = 20)
    private String firstName;
	@Column(length = 20)
    private String lastName;
    @OneToMany(mappedBy="surveyor")
    @JsonIgnore //@JsonManagedReference("surveyor_surveys")
    private List<Survey> surveys;
	
	public Surveyor() {
		super();
	}
	
	public Surveyor(Long id, String username, String firstName, String lastName, List<Survey> surveys) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.surveys = surveys;
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

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	@Override
	public String toString() {
		return "Surveyor [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", surveys=" + surveys + "]";
	}
}

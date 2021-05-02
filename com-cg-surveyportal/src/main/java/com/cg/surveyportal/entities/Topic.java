package com.cg.surveyportal.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/*
 * This will create a table in the database in below mentioned format.
 */
@Entity
@Table
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length = 50)
    private String name;
	@Column(length = 100)
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="topic")
    @JsonManagedReference("topic_surveys")
    private List<Survey> surveys;
	@OneToOne(fetch = FetchType.EAGER)
	@JsonManagedReference("topic_surveyor")
	private Surveyor surveyor;
	
	//Constructors
	public Topic() {
	}
	/**
	 * @param id : Topic ID
	 * @param name : Name of the topic
	 * @param description : Description of the topic
	 * @param surveys : Survey on that topic
	 * @param surveyor : Surveyor who created the survey
	 */
	public Topic(Long id, String name, String description, List<Survey> surveys, Surveyor surveyor) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.surveys = surveys;
		this.surveyor = surveyor;
	}
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Survey> getSurveys() {
		return surveys;
	}
	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	public Surveyor getSurveyor() {
		return surveyor;
	}
	public void setSurveyor(Surveyor surveyor) {
		this.surveyor = surveyor;
	}
	// toString
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + ", surveys=" + surveys
				+ ", surveyor=" + surveyor + "]";
	}
}

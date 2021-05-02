package com.cg.surveyportal.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column
    private LocalDateTime postedDateTime;
	@ManyToOne(optional = true)
	@JsonBackReference("surveys_feedback")
	private Survey survey;
	@ManyToOne(optional = true)
	@JsonBackReference("participant_feedback")
	private Participant participant;
	@OneToOne
	@JsonBackReference("feedback_question")
	private Question question;
	@Column
	private String chosenOption;
	
	public Feedback() {}

	public Feedback(Long id, LocalDateTime postedDateTime, Survey survey, Participant participant, Question question,
			String chosenOption) {
		super();
		this.id = id;
		this.postedDateTime = postedDateTime;
		this.survey = survey;
		this.participant = participant;
		this.question = question;
		this.chosenOption = chosenOption;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(LocalDateTime postedDateTime) {
		this.postedDateTime = postedDateTime;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChosenOption() {
		return chosenOption;
	}

	public void setChosenOption(String chosenOption) {
		this.chosenOption = chosenOption;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", postedDateTime=" + postedDateTime + ", survey=" + survey + ", participant="
				+ participant + ", question=" + question + ", chosenOption=" + chosenOption + "]";
	}
}

package com.cg.surveyportal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long qId;
	@Column(nullable = false, length = 200)	
    private String questionText;
	@Column(nullable = false, length = 20)	
    private String Option1;
	@Column(nullable = false, length = 20)	
    private String Option2;
	@Column(nullable = false, length = 20)	
    private String Option3;
	@Column(nullable = false, length = 20)	
    private String Option4;
	@OneToOne(optional = true)
	@JsonManagedReference("question_survey")
	private Survey survey;
	
	public Question() {
		super();
	}

	public Question(Long qId, String questionText, String option1, String option2, String option3, String option4,
			Survey survey) {
		super();
		this.qId = qId;
		this.questionText = questionText;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		this.survey = survey;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return Option1;
	}

	public void setOption1(String option1) {
		Option1 = option1;
	}

	public String getOption2() {
		return Option2;
	}

	public void setOption2(String option2) {
		Option2 = option2;
	}

	public String getOption3() {
		return Option3;
	}

	public void setOption3(String option3) {
		Option3 = option3;
	}

	public String getOption4() {
		return Option4;
	}

	public void setOption4(String option4) {
		Option4 = option4;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
}

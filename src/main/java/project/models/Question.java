package com.example.myapp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Question {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private int points;
	private String title;
	private String description;
	private String questionType;
	
	@ManyToOne
	@JsonIgnore
	private Exam exam;
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}

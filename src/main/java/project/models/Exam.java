package com.example.myapp.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="EXAM")
public class Exam extends Widget {
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@OneToMany(mappedBy="exam", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Question> questions;
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
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
package com.example.myapp.models;

import javax.persistence.*;

@Entity
@Table(name ="MULTIPLE CHOICE QUESTION")
public class MultipleChoiceQuestion extends Question {
	@Column(name = "OPTIONS", nullable = false)
	private String options;
	@Column(name = "CORRECTOPTION", nullable = false)
	private int correctOption;
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
}
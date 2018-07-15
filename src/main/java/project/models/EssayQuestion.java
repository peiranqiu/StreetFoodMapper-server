package com.example.myapp.models;

import javax.persistence.*;

@Entity
@Table(name ="ESSAY QUESTION")
public class EssayQuestion extends Question {
	@Column(name = "ESSAY", nullable = false)
	private String Essay;

	public String getEssay() {
		return Essay;
	}

	public void setEssay(String essay) {
		Essay = essay;
	}
	
}
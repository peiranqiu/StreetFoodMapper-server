package com.example.myapp.models;
import javax.persistence.*;

@Entity 
public class FillInTheBlankQuestion extends Question{
	@Column(name = "VARIABLES", nullable = false) 
	private String variables;

	public String getVariables() {
		return variables;
	}

	public void setVariables(String variables) {
		this.variables = variables;
	}
}

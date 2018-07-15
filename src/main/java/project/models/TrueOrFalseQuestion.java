package com.example.myapp.models;
import javax.persistence.*;

@Entity
public class TrueOrFalseQuestion extends Question {
	@Column(name = "IS_TRUE", nullable = false) 
	private Boolean isTrue;

	public Boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
}

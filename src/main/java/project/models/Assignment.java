package com.example.myapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="ASSIGNMENT")
public class Assignment extends Widget {
	@Column(name = "TITLE")
	private String title;
	@Column(name = "POINTS")
	private int points;
	@Column(name = "DESCRIPTION")
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	
}
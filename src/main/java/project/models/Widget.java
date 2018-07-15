package com.example.myapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String text;
	private String widgetType;
	private String name;
	private String width;
	private String height;
	
	//for heading
	private int size;
	//for link
	private String herf;
	//for image
	private String src;
	//for list
	private String listItems;
	private ListType listType;
	
	@Column(name="widgetOrder") 
	private Integer order;
	
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}
	public String getListItems() {
		return listItems;
	}
	public void setListItems(String listItems) {
		this.listItems = listItems;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getHerf() {
		return herf;
	}
	public void setHerf(String herf) {
		this.herf = herf;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}

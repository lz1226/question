package com.paper.question.domain.entity;

import java.io.Serializable;

public class Class implements Serializable {
	private Integer id;
	private String name;
	private String headmaster;
	private String teacher;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}

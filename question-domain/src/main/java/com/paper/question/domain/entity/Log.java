package com.paper.question.domain.entity;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class Log implements Serializable{
	private Integer id;
	private String classname;
	private Data examDate;
	private Integer paperID;
	
	private Paper paper;
	
	
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Data getExamDate() {
		return examDate;
	}
	public void setExamDate(Data examDate) {
		this.examDate = examDate;
	}
	public Integer getPaperID() {
		return paperID;
	}
	public void setPaperID(Integer paperID) {
		this.paperID = paperID;
	}
	
}

package com.paper.question.domain.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Paper implements Serializable{
	private Integer id;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	
	private Integer time;
	
	/**
	 * ����
	 */
	private List<PaperQuestion> paperQuestions;
	
	
	
	public List<PaperQuestion> getPaperQuestions() {
		return paperQuestions;
	}
	public void setPaperQuestions(List<PaperQuestion> paperQuestions) {
		this.paperQuestions = paperQuestions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	
}

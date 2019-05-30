package com.paper.question.domain.entity;
import java.io.Serializable;
public class Options implements Serializable {
	//ѡ���
	private Integer id;

	private String optname;

	private Integer questionId;

	private Integer disorder;

	public Integer getId() {
		 return id;
	}

	public void setId(Integer id) {
		 this.id=id;
	}
	public String getOptName() {
		 return optname;
	}

	public void setOptName(String optname) {
		 this.optname=optname;
	}
	
	public String getOptname() {
		return optname;
	}

	public void setOptname(String optname) {
		this.optname = optname;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getDisorder() {
		 return disorder;
	}

	public void setDisorder(Integer disorder) {
		 this.disorder=disorder;
	}

	@Override
	public String toString() {
		return "Options [id=" + id + ", optname=" + optname + ", questionId=" + questionId + ", disorder=" + disorder
				+ "]";
	}

	
	
}
package com.paper.question.domain.entity;
import java.io.Serializable;
public class QuestionType implements Serializable {
	//���ͱ�
	private Integer id;

	private String name;

	public Integer getId() {
		 return id;
	}

	public void setId(Integer id) {
		 this.id=id;
	}
	public String getName() {
		 return name;
	}

	public void setName(String name) {
		 this.name=name;
	}

	@Override
	public String toString() {
		return "QuestionType [id=" + id + ", name=" + name + "]";
	}
	
	
}
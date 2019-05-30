package com.paper.question.domain.entity;

import java.io.Serializable;

public class StrategyInfo implements Serializable{
	private Integer id; //id
	private Integer strId; //������������ĸ�������ߵ�
	private Integer typeId;//��������
	
	private QuestionType questionType;
	
	private Integer number;//������͵�����
	
	
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStrId() {
		return strId;
	}
	public void setStrId(Integer strId) {
		this.strId = strId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}

package com.paper.question.domain.entity;
import java.io.Serializable;
import java.util.List;
public class Question implements Serializable {
	//�����
	private Integer id;

	private String quesName;

	private Integer typeId;
	//��������
	private QuestionType questionType;
	//ѡ��
	private List<Options> list;
	
	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public List<Options> getList() {
		return list;
	}

	public void setList(List<Options> list) {
		this.list = list;
	}

	public Integer getId() {
		 return id;
	}

	public void setId(Integer id) {
		 this.id=id;
	}
	
	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", quesName=" + quesName + ", typeId=" + typeId + ", questionType=" + questionType
				+ ", list=" + list + "]";
	}

	
	
}
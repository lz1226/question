package com.paper.question.domain.entity;

import java.io.Serializable;

public class PaperQuestion implements Serializable {
		private Integer id;
		private Integer paperId;
		private Integer questionId;
		private Integer disorder;
		
		/**
		 * ����ǰ���������Ϣ��װ��ȥ��
		 */
		private Question question;
		
		
		public Question getQuestion() {
			return question;
		}
		public void setQuestion(Question question) {
			this.question = question;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getPaperId() {
			return paperId;
		}
		public void setPaperId(Integer paperId) {
			this.paperId = paperId;
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
			this.disorder = disorder;
		}
		
		
}

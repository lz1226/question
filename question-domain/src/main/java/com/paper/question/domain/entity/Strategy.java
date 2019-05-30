package com.paper.question.domain.entity;

import java.io.Serializable;

public class Strategy implements Serializable {
	private Integer id;
	private String strName;
	private Integer isopen;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public Integer getIsopen() {
		return isopen;
	}
	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}
	
	
}

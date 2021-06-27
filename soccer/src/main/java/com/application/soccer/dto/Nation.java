package com.application.soccer.dto;

import java.io.Serializable;

public class Nation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long nationId;
	private String nationName;
	private String nationCode;
	
	public Long getNationId() {
		return nationId;
	}
	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

}

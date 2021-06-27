package com.application.soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCX_NATION")
public class NationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NATION_ID")
	private Long nationId;
	
	@Column(name = "NATION_NAME")
	private String nationName;
	
	@Column(name = "NATION_CODE")
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

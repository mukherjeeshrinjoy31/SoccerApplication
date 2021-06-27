package com.application.soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCX_POSITION")
public class PlayerPositionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POSITION_ID")
	private Long positonId;
	
	@Column(name = "POSITION_NAME")
	private String positionName;
	
	
	public Long getPositonId() {
		return positonId;
	}
	public void setPositonId(Long positonId) {
		this.positonId = positonId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}

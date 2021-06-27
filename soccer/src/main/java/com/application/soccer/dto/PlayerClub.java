package com.application.soccer.dto;

import java.io.Serializable;

public class PlayerClub implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String clubName;
	private String clubCode;
	private String clubNationName;

	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubCode() {
		return clubCode;
	}
	public void setClubCode(String clubCode) {
		this.clubCode = clubCode;
	}
	public String getClubNationName() {
		return clubNationName;
	}
	public void setClubNationName(String clubNationName) {
		this.clubNationName = clubNationName;
	}

}

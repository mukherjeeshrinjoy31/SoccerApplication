package com.application.soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCX_CLUB")
public class ClubEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLUB_ID")
	private Long clubId;
	
	@Column(name = "CLUB_NAME")
	private String clubName;
	
	@Column(name = "CLUB_CODE")
	private String clubCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLUB_NATION_ID", referencedColumnName = "NATION_ID")
	private NationEntity playerNation;

	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}

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

	public NationEntity getPlayerNation() {
		return playerNation;
	}

	public void setPlayerNation(NationEntity playerNation) {
		this.playerNation = playerNation;
	}

}

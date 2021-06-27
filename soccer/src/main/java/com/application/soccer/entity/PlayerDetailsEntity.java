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
@Table(name = "SCX_PLAYER_DETAILS")
public class PlayerDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_ID")
	private Long playerId;
	
	@Column(name = "PLAYER_NAME")
	private String playerName;
	
	@Column(name = "PLAYER_AGE")
	private Integer playerAge;
	
	@Column(name = "PLAYER_GOALS")
	private Integer playerGoals;
	
	@Column(name = "PLAYER_ASSISTS")
	private Integer playerAssists;
	
	@Column(name = "PLAYER_CLEAN_SHEETS")
	private Integer playerCleanSheets;
	
	@Column(name = "PLAYER_RATING")
	private Integer playerStarRating;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAYER_POSITION_ID" , referencedColumnName = "POSITION_ID")
	private PlayerPositionEntity playerPosition;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAYER_NATION_ID" , referencedColumnName = "NATION_ID")
	private NationEntity playerNation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAYER_CLUB_ID" , referencedColumnName = "CLUB_ID")
	private ClubEntity playerClub;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(Integer playerAge) {
		this.playerAge = playerAge;
	}

	public Integer getPlayerGoals() {
		return playerGoals;
	}

	public void setPlayerGoals(Integer playerGoals) {
		this.playerGoals = playerGoals;
	}

	public Integer getPlayerAssists() {
		return playerAssists;
	}

	public void setPlayerAssists(Integer playerAssists) {
		this.playerAssists = playerAssists;
	}

	public Integer getPlayerCleanSheets() {
		return playerCleanSheets;
	}

	public void setPlayerCleanSheets(Integer playerCleanSheets) {
		this.playerCleanSheets = playerCleanSheets;
	}

	public Integer getPlayerStarRating() {
		return playerStarRating;
	}

	public void setPlayerStarRating(Integer playerStarRating) {
		this.playerStarRating = playerStarRating;
	}

	public PlayerPositionEntity getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(PlayerPositionEntity playerPosition) {
		this.playerPosition = playerPosition;
	}

	public NationEntity getPlayerNation() {
		return playerNation;
	}

	public void setPlayerNation(NationEntity playerNation) {
		this.playerNation = playerNation;
	}

	public ClubEntity getPlayerClubEntity() {
		return playerClub;
	}

	public void setPlayerClubEntity(ClubEntity playerClubEntity) {
		this.playerClub = playerClubEntity;
	}

}

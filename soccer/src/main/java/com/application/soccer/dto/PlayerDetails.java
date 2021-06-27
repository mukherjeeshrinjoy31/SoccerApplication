package com.application.soccer.dto;

import java.io.Serializable;

public class PlayerDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long playerId;
	private String playerName;
	private Integer playerAge;
	private Integer playerGoals;
	private Integer playerAssists;
	private Integer playerCleanSheets;
	private Integer playerStarRating;
	private String playerNationality;
	private String playerPosition;
	private String playerClub;
	
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
	public String getPlayerNationality() {
		return playerNationality;
	}
	public void setPlayerNationality(String playerNationality) {
		this.playerNationality = playerNationality;
	}
	public String getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}
	public String getPlayerClub() {
		return playerClub;
	}
	public void setPlayerClub(String playerClub) {
		this.playerClub = playerClub;
	}
	
	
}

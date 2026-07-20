package com.tka.entity;

public class Players {
	
	private int playerJn;
	private String playerName;
	private String team;
	private String role;
	private int matches;
	private int runs;
	private int wickets;
	private int price;
	
	public Players() {
		super();
	}

	public Players(int playerJn, String playerName, String team, String role, int matches, int runs, int wickets,
			int price) {
		super();
		this.playerJn = playerJn;
		this.playerName = playerName;
		this.team = team;
		this.role = role;
		this.matches = matches;
		this.runs = runs;
		this.wickets = wickets;
		this.price = price;
	}

	public int getPlayerJn() {
		return playerJn;
	}

	public void setPlayerJn(int playerJn) {
		this.playerJn = playerJn;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
	    return String.format("\n| %-4s | %-20s | %-5s | %-12s | %-4s | %-5s | %-4s | %-10s |", 
	        playerJn, playerName, team, role, matches, runs, wickets, price);
	}
	

}

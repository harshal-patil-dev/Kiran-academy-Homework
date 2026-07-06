package com.harsh.july05;

public class Player {

	private int jerseyNo;
	private String name;
	private long runs;
	private long wickets;
	private String teamName;

	public Player() {
		super();
	}

	public Player(int jerseyNo, String name, long runs, long wickets, String teamName) {
		super();
		this.jerseyNo = jerseyNo;
		this.name = name;
		this.runs = runs;
		this.wickets = wickets;
		this.teamName = teamName;
	}

	public int getJerseyNo() {
		return jerseyNo;
	}

	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRuns() {
		return runs;
	}

	public void setRuns(long runs) {
		this.runs = runs;
	}

	public long getWickets() {
		return wickets;
	}

	public void setWickets(long wickets) {
		this.wickets = wickets;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
	    return String.format(
	        "%-8d %-25s %-10d %-10d",
	        jerseyNo,
	        name,
	        runs,
	        wickets
	    );
	}


}

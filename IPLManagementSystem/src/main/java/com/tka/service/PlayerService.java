package com.tka.service;

import java.util.List;
import com.tka.dao.PlayerDao;
import com.tka.entity.Players;

public class PlayerService {

	private PlayerDao playerdao = new PlayerDao();

	public List<Players> getAllPlayers() {

		List<Players> allPlayers = playerdao.getAllPlayers();
		return allPlayers;
	}

	public boolean addPlayers(Players p1) {

		if (!p1.getRole().equalsIgnoreCase("Allrounder") && !p1.getRole().equalsIgnoreCase("Bowler")
				&& !p1.getRole().equalsIgnoreCase("Batsman") && !p1.getRole().equalsIgnoreCase("Wicketkeeper")) {
			return false;
		}

		if (p1.getPlayerJn() <= 0 || p1.getPlayerJn() > 999) {
			return false;
		}

		if (p1.getRuns() < 0 || p1.getWickets() < 0) {
			return false;
		}

		if (p1.getPrice() <= 0) {
			return false;
		}

		boolean addplayers = playerdao.addPlayers(p1);
		return addplayers;

	}

	public List<Players> findPlayers(Players p1) {

		List<Players> findplayers = playerdao.findPlayers(p1);
		return findplayers;
	}

	public boolean updatePlayers(Players p1) {

		if (!p1.getRole().equalsIgnoreCase("Allrounder") && !p1.getRole().equalsIgnoreCase("Bowler")
				&& !p1.getRole().equalsIgnoreCase("Batsman") && !p1.getRole().equalsIgnoreCase("Wicketkeeper")) {
		    System.out.println("Invalid Role!");
			return false;
		}

		if (p1.getPlayerJn() <= 0 || p1.getPlayerJn() > 999) {
			System.out.println("Invalid Jersey Number!");
			return false;
		}

		if (p1.getRuns() < 0 || p1.getWickets() < 0) {
			System.out.println("Invalid Runs And Wickets!");
			return false;
		}

		if (p1.getPrice() <= 0) {
			System.out.println("Invalid Price!");
			return false;
		}
		
		boolean updateplayers = playerdao.updatePlayers(p1);
		return updateplayers;
	}

	public boolean deletePlayer(Players p1) {
		boolean updateplayers = playerdao.deletePlayers(p1);
		return updateplayers;
	}

}

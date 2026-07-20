package com.tka.controller;

import java.util.List;
import java.util.Scanner;
import com.tka.entity.Players;
import com.tka.service.PlayerService;
import com.tka.utility.PlayersDB;

public class PlayerController {

	private Players p1 = null;
	private PlayerService playerservice = new PlayerService();
	private Scanner scanner = new Scanner(System.in);

	public List<Players> getAllPlayers() {
		List<Players> allPlayers = playerservice.getAllPlayers();

		if (!allPlayers.isEmpty()) {
			System.out.println(
					"=========================================================================================");
			System.out.println(
					"                                     DISPLAY PLAYERS                                     ");
			System.out.println(
					"=========================================================================================");

			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");
			System.out.println(
					"| JN   | Player Name          | Team  | Role         | Mat  | Runs  | Wkt  | Price      |");
			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");

			System.out.println(allPlayers);

			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");

		} else {
			System.out.println("=========================================");
			System.out.println("            Players Not Found!           ");
			System.out.println("=========================================");
		}

		return allPlayers;
	}

	public List<Players> addPlayers() {

		System.out.println("=========================================");
		System.out.println("              ADD PLAYERS                ");
		System.out.println("=========================================");

		System.out.println("Enter Player Jersey Number :");
		int PlayerJn = scanner.nextInt();

		System.out.println("-----------------------------------------");

		scanner.nextLine();
		System.out.println("Enter Player Team :");
		String team = scanner.nextLine();

		p1 = new Players();
		p1.setPlayerJn(PlayerJn);
		p1.setTeam(team);
        
		PlayersDB.loading();
		List<Players> findplayers = playerservice.findPlayers(p1);

		if (!findplayers.isEmpty()) {

			System.out.println("-----------------------------------------");

			System.out.println("Enter Name :");
			String playerName = scanner.nextLine();

			System.out.println("-----------------------------------------");

			System.out.println("Enter Role :");
			String role = scanner.nextLine();

			System.out.println("-----------------------------------------");

			System.out.println("Enter Matches :");
			int matches = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter Runs :");
			int runs = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter Wickets :");
			int wickets = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter Price :");
			int price = scanner.nextInt();

			p1.setPlayerName(playerName);
			p1.setRole(role);
			p1.setMatches(matches);
			p1.setRuns(runs);
			p1.setWickets(wickets);
			p1.setPrice(price);
			
			PlayersDB.loading();
			boolean addplayers = playerservice.addPlayers(p1);
			if (addplayers) {
				System.out.println("=========================================");
				System.out.println("       Player Added Successfully...      ");
				System.out.println("=========================================");
			} else {
				System.out.println("=========================================");
				System.out.println("          Something went wrong!          ");
				System.out.println("=========================================");
			}

		} else {
			System.out.println("=========================================");
			System.out.println("           Players Not Found!            ");
			System.out.println("=========================================");
		}

		return findplayers;

	}

	public List<Players> updatePlayers() {

		System.out.println("=========================================");
		System.out.println("             UPDATE PLAYER               ");
		System.out.println("=========================================");

		System.out.println("Enter Jersey Number :");
		int PlayerJn = scanner.nextInt();

		System.out.println("-----------------------------------------");

		scanner.nextLine();
		System.out.println("Enter Team :");
		String team = scanner.nextLine();

		p1 = new Players();
		p1.setPlayerJn(PlayerJn);
		p1.setTeam(team);

		PlayersDB.loading();
		List<Players> findplayers = playerservice.findPlayers(p1);

		if (!findplayers.isEmpty()) {

			System.out.println(
					"=========================================================================================");
			System.out.println(
					"                                     CURRENT DETAILS                                     ");
			System.out.println(
					"=========================================================================================");

			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");
			System.out.println(
					"| JN   | Player Name          | Team  | Role         | Mat  | Runs  | Wkt  | Price      |");
			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");

			System.out.println(findplayers);

			System.out.println(
					"+------+----------------------+-------+--------------+------+-------+------+------------+");

			System.out.println("Enter New Name :");
			String playerName = scanner.nextLine();
			
			System.out.println("-----------------------------------------");

			System.out.println("Enter New Role :");
			String role = scanner.nextLine();

			System.out.println("-----------------------------------------");

			System.out.println("Enter New Matches :");
			int matches = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter New Runs :");
			int runs = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter New Wickets :");
			int wickets = scanner.nextInt();

			System.out.println("-----------------------------------------");

			System.out.println("Enter New Price :");
			int price = scanner.nextInt();

			p1.setRole(role);
			p1.setPlayerName(playerName);
			p1.setMatches(matches);
			p1.setRuns(runs);
			p1.setWickets(wickets);
			p1.setPrice(price);

			PlayersDB.loading();
			boolean updateplayers = playerservice.updatePlayers(p1);

			if (updateplayers) {
				System.out.println("=========================================");
				System.out.println("       Player Updated Successfully...      ");
				System.out.println("=========================================");
			} else {
				System.out.println("=========================================");
				System.out.println("          Something went wrong!          ");
				System.out.println("=========================================");
			}

		} else {

			System.out.println("=========================================");
			System.out.println("           Players Not Found!            ");
			System.out.println("=========================================");
		}

		return findplayers;
	}

	public List<Players> deletePlayers() {
		
		System.out.println("=========================================");
		System.out.println("             DELETE PLAYER               ");
		System.out.println("=========================================");

		System.out.println("Enter Jersey Number :");
		int PlayerJn = scanner.nextInt();

		System.out.println("-----------------------------------------");

		scanner.nextLine();
		System.out.println("Enter Team :");
		String team = scanner.nextLine();

		p1 = new Players();
		p1.setPlayerJn(PlayerJn);
		p1.setTeam(team);

		PlayersDB.loading();
		List<Players> findplayers = playerservice.findPlayers(p1);
		
		if(!findplayers.isEmpty()) {
			
			boolean deleteplayers = playerservice.deletePlayer(p1);
			if(deleteplayers) {
				System.out.println("=========================================");
				System.out.println("      Players Deleted Successfully!     ");
				System.out.println("=========================================");
			} else {
				System.out.println("=========================================");
				System.out.println("          Something went wrong!          ");
				System.out.println("=========================================");
			}
			
		} else {

			System.out.println("=========================================");
			System.out.println("           Players Not Found!            ");
			System.out.println("=========================================");
		}
		
		return findplayers;
	}
}

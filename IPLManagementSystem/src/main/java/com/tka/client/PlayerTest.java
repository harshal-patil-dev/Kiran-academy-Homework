package com.tka.client;

import java.util.Scanner;
import com.tka.controller.PlayerController;
import com.tka.utility.PlayersDB;

public class PlayerTest {
	
	int choice = 0;
	private Scanner scanner = new Scanner(System.in);
	private PlayerController playercontroller = new PlayerController();
	
	public static void main(String[] args) {
		
		PlayerTest p1 = new PlayerTest();
		p1.start();
		
	}

	private void start() {
		do {
			menu();
		}while(choice < 10 && choice > 0);
		
	}

	private void menu() {
		System.out.println("=========================================\r\n"
				+ "         IPL PLAYER MANAGEMENT\r\n"
				+ "=========================================\r\n"
				+ "\r\n"
				+ "1 -> Display Players\r\n"
				+ "2 -> Add Player\r\n"
				+ "3 -> Update Player\r\n"
				+ "4 -> Delete Player\r\n"
				+ "\r\n"
				+ "5 -> Search Player by ID\r\n"
				+ "6 -> Search Player by Name\r\n"
				+ "7 -> Display Batsmen\r\n"
				+ "8 -> Display Bowlers\r\n"
				+ "9 -> Display All-Rounders\r\n"
				+ "10 -> Display Wicket Keepers\r\n"
				+ "\r\n"
				+ "0 -> Exit\r\n"
				+ "\r\n"
				+ "=========================================\r\n");
		
		System.out.println("Enter Choice :");
		choice = scanner.nextInt();
		
		while(choice > 10) {
			System.out.println("Invalid Choice!");
			System.out.println("---------------");
			System.out.println("Enter Choice :");
			choice = scanner.nextInt();
		}
		
		switch(choice) {
		case 1:
			PlayersDB.loading();
			playercontroller.getAllPlayers();
			break;
		case 2:
			PlayersDB.loading();
			playercontroller.addPlayers();
			break;
		case 3:
			PlayersDB.loading();
			playercontroller.updatePlayers();
			break;
		case 4:
			PlayersDB.loading();
			playercontroller.deletePlayers();
			break;
		case 0:
			PlayersDB.loading();
			Exists();
			break;
		}
		
	}

	private void Exists() {
		System.out.println("=========================================");
		System.out.println("            System Exists...             ");
		System.out.println("=========================================");
	}

}

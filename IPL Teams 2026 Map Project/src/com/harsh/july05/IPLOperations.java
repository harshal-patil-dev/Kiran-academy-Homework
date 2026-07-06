package com.harsh.july05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLOperations {

	List<Player> rcbTeam = new ArrayList<>();
	List<Player> gtTeam = new ArrayList<>();
	List<Player> rrTeam = new ArrayList<>();
	List<Player> srhTeam = new ArrayList<>();

	Map<String, List<Player>> ipl_2026_db = new HashMap<>();

	Scanner scanner = new Scanner(System.in);

	int choice = 0;

	public void start() {

		do {
			this.showMenu();
		} while (choice < 5);

	}

	public void playerData() {

		rcbTeam.add(new Player(18, "Virat Kohli", 675, 0, "RCB"));
		rcbTeam.add(new Player(21, "Rajat Patidar", 485, 0, "RCB"));
		rcbTeam.add(new Player(13, "Phil Salt", 412, 0, "RCB"));
		rcbTeam.add(new Player(19, "Devdutt Padikkal", 345, 0, "RCB"));
		rcbTeam.add(new Player(85, "Tim David", 280, 0, "RCB"));
		rcbTeam.add(new Player(25, "Venkatesh Iyer", 240, 2, "RCB"));
		rcbTeam.add(new Player(4, "Krunal Pandya", 185, 8, "RCB"));
		rcbTeam.add(new Player(15, "Bhuvneshwar Kumar", 35, 28, "RCB"));
		rcbTeam.add(new Player(7, "Rasikh Salam", 12, 19, "RCB"));
		rcbTeam.add(new Player(38, "Josh Hazlewood", 8, 15, "RCB"));
		rcbTeam.add(new Player(9, "Jacob Duffy", 4, 9, "RCB"));

		gtTeam.add(new Player(7, "Shubman Gill", 732, 0, "GT"));
		gtTeam.add(new Player(23, "Sai Sudharsan", 722, 0, "GT"));
		gtTeam.add(new Player(63, "Jos Buttler", 526, 0, "GT"));
		gtTeam.add(new Player(10, "David Miller", 310, 0, "GT"));
		gtTeam.add(new Player(9, "Shahrukh Khan", 215, 1, "GT"));
		gtTeam.add(new Player(22, "Rahul Tewatia", 185, 3, "GT"));
		gtTeam.add(new Player(25, "Kagiso Rabada", 15, 29, "GT"));
		gtTeam.add(new Player(19, "Rashid Khan", 95, 21, "GT"));
		gtTeam.add(new Player(13, "Mohammed Siraj", 8, 19, "GT"));
		gtTeam.add(new Player(58, "Jason Holder", 45, 17, "GT"));
		gtTeam.add(new Player(15, "Manav Suthar", 12, 11, "GT"));

		rrTeam.add(new Player(2, "Vaibhav Sooryavanshi", 776, 0, "RR"));
		rrTeam.add(new Player(16, "Dhruv Jurel", 515, 0, "RR"));
		rrTeam.add(new Player(11, "Sanju Samson", 442, 0, "RR"));
		rrTeam.add(new Player(50, "Yashasvi Jaiswal", 398, 0, "RR"));
		rrTeam.add(new Player(27, "Shimron Hetmyer", 265, 0, "RR"));
		rrTeam.add(new Player(5, "Riyan Parag", 242, 4, "RR"));
		rrTeam.add(new Player(93, "Jofra Archer", 38, 25, "RR"));
		rrTeam.add(new Player(3, "Yuzvendra Chahal", 5, 14, "RR"));
		rrTeam.add(new Player(18, "Trent Boult", 12, 13, "RR"));
		rrTeam.add(new Player(29, "Avesh Khan", 2, 11, "RR"));
		rrTeam.add(new Player(8, "Sandeep Sharma", 0, 10, "RR"));

		srhTeam.add(new Player(45, "Heinrich Klaasen", 624, 0, "SRH"));
		srhTeam.add(new Player(4, "Abhishek Sharma", 563, 0, "SRH"));
		srhTeam.add(new Player(32, "Ishan Kishan", 495, 0, "SRH"));
		srhTeam.add(new Player(62, "Travis Head", 380, 0, "SRH"));
		srhTeam.add(new Player(59, "Nitish Kumar Reddy", 220, 6, "SRH"));
		srhTeam.add(new Player(26, "Abdul Samad", 195, 0, "SRH"));
		srhTeam.add(new Player(70, "Pat Cummins", 112, 14, "SRH"));
		srhTeam.add(new Player(99, "Eshan Malinga", 4, 20, "SRH"));
		srhTeam.add(new Player(30, "T Natarajan", 2, 12, "SRH"));
		srhTeam.add(new Player(44, "Bhuvneshwar Kumar", 15, 11, "SRH"));
		srhTeam.add(new Player(5, "Washington Sundar", 65, 8, "SRH"));

		ipl_2026_db.put("RCB", rcbTeam);
		ipl_2026_db.put("GT", gtTeam);
		ipl_2026_db.put("RR", rrTeam);
		ipl_2026_db.put("SRH", srhTeam);

	}

	public void showMenu() {

		System.out.println("-----------------------------------------------------");
		System.out.println("          IPL 2026 Database System");
		System.out.println("-----------------------------------------------------");

		System.out.println("\n" 
		                    + "1. Display Team Players\r\n" 
				            + "2. Search Player by Jersey Number\r\n"
				            + "3. Highest Run Scorer\r\n" 
				            + "4. Highest Wicket taker\r\n" 
				            + "5. Exit" 
				            + "\n");

		System.out.println("-----------------------------------------------------");

		System.out.println("Enter choice :");
		choice = scanner.nextInt();

		while (choice > 5) {
			System.out.println("Invalid choice!");
			System.out.println("----------------");
			System.out.println("Enter choice :");
			choice = scanner.nextInt();
		}

		switch (choice) {
		case 1:
			this.displayTeamPlayers();
			break;
		case 2:
			this.searchByJersey();
			break;
		case 3:
			this.highestRunScorer();
			break;
		case 4:
			this.highestWicket();
			break;
		case 5:
			this.exit();
		}
	}

	private void displayTeamPlayers() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Display Team Players");
		System.out.println("-----------------------------------------------------");

		System.out.println("\n" 
		                   + "1. Display All Teams\r\n" 
				           + "2. Display Players of Particular Team\r\n" 
		                   + "3. Exit" 
				           + "\n");

		System.out.println("-----------------------------------------------------");
		System.out.println("Enter choice :");
		choice = scanner.nextInt();

		while (choice > 3) {
			System.out.println("Invalid choice!");
			System.out.println("----------------");
			System.out.println("Enter choice :");
			choice = scanner.nextInt();
		}

		switch (choice) {
		case 1:
			this.displayAllTeams();
			break;
		case 2:
			this.displayPlayersTeam();
			break;
		case 3:
			break;
		}
	}

	private void displayAllTeams() {

		if (!ipl_2026_db.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("                Display All Teams");
			System.out.println("-----------------------------------------------------");

			for (String obj : ipl_2026_db.keySet()) {
				System.out.println(" ");
				System.out.println("=====================================================");
				System.out.println("Team :" + obj);
				System.out.println("=====================================================");
				System.out.println("Jersey   Player Name               Runs      Wickets");
				System.out.println("-----------------------------------------------------");
				for (Player teamDetails : ipl_2026_db.get(obj)) {
					System.out.println(teamDetails);

				}

			}

		} else {
			System.out.println("-----------------------------------------------------");
			System.out.println("No data available!");
			System.out.println("-----------------------------------------------------");

		}

	}

	private void displayPlayersTeam() {

		if (!ipl_2026_db.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("       Display Players of Particular Team");
			System.out.println("-----------------------------------------------------");

			scanner.nextLine();
			System.out.println("----------------------------------");
			System.out.println("Enter Team Name :");
			String teamName = scanner.nextLine();

			System.out.println(" ");
			System.out.println("=====================================================");
			System.out.println("Team :" + teamName);
			System.out.println("=====================================================");
			System.out.println("Jersey   Player Name               Runs      Wickets");
			System.out.println("-----------------------------------------------------");
			for (String obj : ipl_2026_db.keySet()) {
				for (Player teamDetails : ipl_2026_db.get(obj))
					if (teamDetails.getTeamName().equalsIgnoreCase(teamName)) {
						System.out.println(teamDetails);
					}
			}

		} else {
			System.out.println("-----------------------------------------------------");
			System.out.println("No data available!");
			System.out.println("-----------------------------------------------------");

		}

	}

	private void searchByJersey() {

		if (!ipl_2026_db.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("        Search Player by Jersey Number");
			System.out.println("-----------------------------------------------------");

			System.out.println("Enter Jersey Number :");
			int jerseyNo = scanner.nextInt();

			System.out.println(" ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Jersey   Player Name               Runs      Wickets");
			System.out.println("-----------------------------------------------------");
			for (String obj : ipl_2026_db.keySet()) {
				for (Player playerDetails : ipl_2026_db.get(obj))
					if (playerDetails.getJerseyNo() == jerseyNo) {
						System.out.println(playerDetails);
					}

			}

		} else {
			System.out.println("-----------------------------------------------------");
			System.out.println("No data available!");
			System.out.println("-----------------------------------------------------");

		}


	}

	private void highestRunScorer() {
		
		if (!ipl_2026_db.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Highest Run Scorer");
			System.out.println("-----------------------------------------------------");
			
			long currentRun = 0;
			for(String obj : ipl_2026_db.keySet()) {
					for(Player playerDetails : ipl_2026_db.get(obj)) {
						long nextRun = playerDetails.getRuns();
						if(currentRun < nextRun) {
							currentRun = nextRun;
						}
						
					}
					
				}
			System.out.println(" ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Highest Runs :" + currentRun);
			System.out.println("-----------------------------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("Jersey   Player Name               Runs      Wickets");
			System.out.println("-----------------------------------------------------");
			for(String objNew : ipl_2026_db.keySet())
			for(Player playerDetails : ipl_2026_db.get(objNew)) {
				if(playerDetails.getRuns() == currentRun) {
					System.out.println(playerDetails);
				}
				
			}
			
			
		} else {
			System.out.println("-----------------------------------------------------");
			System.out.println("No data available!");
			System.out.println("-----------------------------------------------------");
		}

	}

	private void highestWicket() {
		if (!ipl_2026_db.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("              Highest Wicket Taker");
			System.out.println("-----------------------------------------------------");
			
			long currentWicket = 0;
			for(String obj : ipl_2026_db.keySet()) {
					for(Player playerDetails : ipl_2026_db.get(obj)) {
						long nextWicket = playerDetails.getWickets();
						if(currentWicket < nextWicket) {
							currentWicket = nextWicket;
						}
						
					}
					
				}
			
			System.out.println(" ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Highest Wickets :" + currentWicket);
			System.out.println("-----------------------------------------------------");
			System.out.println("-----------------------------------------------------");
			System.out.println("Jersey   Player Name               Runs      Wickets");
			System.out.println("-----------------------------------------------------");
			for(String objNew : ipl_2026_db.keySet())
			for(Player playerDetails : ipl_2026_db.get(objNew)) {
				if(playerDetails.getWickets() == currentWicket) {
					System.out.println(playerDetails);
				}
				
			}
			
			
		} else {
			System.out.println("-----------------------------------------------------");
			System.out.println("No data available!");
			System.out.println("-----------------------------------------------------");
		}

	}

	private void exit() {
		System.out.println("-----------------------------------------------------");
		System.out.println("System Exits...");
		System.out.println("-----------------------------------------------------");

	}

}
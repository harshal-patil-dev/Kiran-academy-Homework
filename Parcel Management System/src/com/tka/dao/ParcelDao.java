package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tka.entity.Parcel;

public class ParcelDao {

	int choice = 0;
	Scanner scanner = new Scanner(System.in);
	Parcel parcel = new Parcel();

	private String diver_path = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/parcel_db";
	private String insQuery = null;
	private String disQuery = "SELECT * FROM parcel";
	private String username = "root";
	private String password = "root";

	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	List<Parcel> allParcels = null;
	Parcel obj = null;

	public void menu() {

		System.out.println("========= Parcel Management System =========" + "\n");
		System.out.println("1. Add Parcel\r\n" + "2. Display All Parcels\r\n" + "3. Exit");
		System.out.println("============================================");
		System.out.println("Enter choice: ");
		choice = scanner.nextInt();
		while (choice >= 4) {
			System.out.println("Invalid choice!");
			System.out.println("Enter choice: ");
			choice = scanner.nextInt();
		}

		switch (choice) {
		case 1:
			AddParcel();
			break;
		case 2:
			DisplayAllParcel();
			break;
		case 3:
			Exit();
		}

	}

	private List<Parcel> AddParcel() {

		System.out.println("============================================");
		System.out.println("                Add Parcel");
		System.out.println("============================================");

		System.out.println("Enter Parcel ID :");
		int pid = scanner.nextInt();

		System.out.println("--------------------------------");
		System.out.println("Enter Sender Name :");
		String senderName = scanner.nextLine();

		scanner.nextLine();

		System.out.println("--------------------------------");
		System.out.println("Enter Receiver Name :");
		String receiverName = scanner.nextLine();

		System.out.println("--------------------------------");
		System.out.println("Enter City :");
		String city = scanner.nextLine();

		System.out.println("--------------------------------");
		System.out.println("Enter Weight Name :");
		double weight = scanner.nextDouble();

		System.out.println("--------------------------------");
		System.out.println("Enter Price Name :");
		double price = scanner.nextDouble();

		try {

			Class.forName(diver_path);

			con = DriverManager.getConnection(url, username, password);

			st = con.createStatement();

			insQuery = "INSERT INTO parcel VALUES('" + pid + "', '" + senderName + "', '" + receiverName + "', '" + city
					+ "', " + weight + ", " + price + ")";

			st.executeUpdate(insQuery);
			System.out.println("--------------------------------");
			System.out.println("Parcel Added Succesfully...");
			System.out.println("--------------------------------");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private List<Parcel> DisplayAllParcel() {

		System.out.println("============================================");
		System.out.println("           Display All Parcels");
		System.out.println("============================================");

		try {

			Class.forName(diver_path);

			con = DriverManager.getConnection(url, username, password);

			st = con.createStatement();

			rs = st.executeQuery(disQuery);

			allParcels = new ArrayList<>();

			while (rs.next()) {
				obj = new Parcel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6));
				allParcels.add(obj);
				System.out.println("============================================" + "\n");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allParcels;
	}

	private void Exit() {
		System.out.println("---------------");
		System.out.println("System Exit...");
	}

	public void start() {

		do {
			menu();
		} while (choice < 3);
	}

}

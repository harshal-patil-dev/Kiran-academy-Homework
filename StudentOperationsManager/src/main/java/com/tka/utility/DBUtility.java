package com.tka.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	private static String path_diver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/batch433_db";
	private static String username = "root";
	private static String password = "root";

	private static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(path_diver);
		con = DriverManager.getConnection(url, username, password);

		return con;
	}
	
	public static void loading() {
		try {
			System.out.println("Please wait...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
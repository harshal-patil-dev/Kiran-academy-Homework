package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tka.entity.Student;

public class StudentDao {

	private String path_diver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/batch433_db";
	private String quary = "SELECT * FROM Student";
	private String username = "root";
	private String password = "root";
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	public List<Student> getAllStudent() {

		try {
			
			Class.forName(path_diver);
			// System.out.println("Diver load succesfully");
			
			con = DriverManager.getConnection (url,username,password);
			// System.out.println("DadaBase connected succesfully");
			
			st = con.createStatement();
			// System.out.println("Statement create succesfully");
			
			rs = st.executeQuery(quary);
			// System.out.println("Query execute succesfully");
			
			while(rs.next()) {
				
				int rollNo = rs.getInt(1);
				String name = rs.getString(2);
				int marks = rs.getInt(3);
				
				System.out.println("Roll = " + rollNo + ", Name = " + name + ", Marks = " + marks);
			}
			
			rs.close();
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}

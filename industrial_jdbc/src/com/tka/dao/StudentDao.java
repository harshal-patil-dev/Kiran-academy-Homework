package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Student;
import com.tka.utility.StudentUtility;

public class StudentDao {

	private static String selectQuary = "SELECT * FROM Student";
	private static String insertQuary = "INSERT INTO Student VALUES(?,?,?)";
	private static String updateQuary = "UPDATE Student SET marks = ?, name = ? WHERE rollNo = ?";
	private static String deleteQuary = "DELETE FROM Student WHERE rollNo = ?";

	private static PreparedStatement ps = null;
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private List<Student> allStudents = null;
	private Student obj = null;

	public List<Student> getAllStudent() {

		try {

			con = StudentUtility.getConnection();

			st = con.createStatement();

			rs = st.executeQuery(selectQuary);

			allStudents = new ArrayList<Student>();

			while (rs.next()) {

				obj = new Student();
				obj.setRollNo(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setMarks(rs.getInt(3));

				allStudents.add(obj);
			}

			con.close();
			st.close();
			rs.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allStudents;
	}

	public static boolean addStudents(Student s1) {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(insertQuary);

			ps.setInt(1, s1.getRollNo());
			ps.setString(2, s1.getName());
			ps.setInt(3, s1.getMarks());

			int student_ack = ps.executeUpdate();
			if (student_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean updateStudents(Student s1) {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(updateQuary);

			ps.setInt(1, s1.getMarks());
			ps.setString(2, s1.getName());
			ps.setInt(3, s1.getRollNo());

			int student_ack = ps.executeUpdate();
			if (student_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteStudents(Student s1, Connection con) {

		try {

			ps = con.prepareStatement(deleteQuary);

			ps.setInt(1, s1.getRollNo());

			int student_ack = ps.executeUpdate();
			if (student_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}

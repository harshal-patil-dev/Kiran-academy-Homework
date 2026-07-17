package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Leaves;
import com.tka.entity.Student;
import com.tka.utility.StudentUtility;

public class LeaveDao {

	private static String selectQuary = "SELECT * FROM leave_student";
	private static String addQuery = "INSERT INTO leave_student VALUES(?,?,?,?,?)";
	private static String updateQuery = "UPDATE leave_student SET l_id = ?, start = ?, end = ?, reason = ? WHERE rollNo = ?";
	private static String deleteQuary = "DELETE FROM leave_student WHERE rollNo = ?";

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Leaves obj = null;
	private List<Leaves> allLeaves = null;

	public List<Leaves> getAllLeaves() {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(selectQuary);

			rs = ps.executeQuery();

			allLeaves = new ArrayList();

			while (rs.next()) {

				obj = new Leaves(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

				allLeaves.add(obj);

			}

			con.close();
			ps.close();
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return allLeaves;
	}

	public boolean addLeaves(Leaves l1) {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(addQuery);

			ps.setInt(1, l1.getL_id());
			ps.setString(2, l1.getStart());
			ps.setString(3, l1.getEnd());
			ps.setString(4, l1.getReason());
			ps.setInt(5, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateLeaves(Leaves l1) {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(updateQuery);

			ps.setInt(1, l1.getL_id());
			ps.setString(2, l1.getStart());
			ps.setString(3, l1.getEnd());
			ps.setString(4, l1.getReason());
			ps.setInt(5, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteLeaves(Leaves l1) {

		try {

			con = StudentUtility.getConnection();

			ps = con.prepareStatement(deleteQuary);

			ps.setInt(1, l1.getRollNo());

			int leave_ack = ps.executeUpdate();
			if (leave_ack > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteLeaves(Student s1, Connection con) {

		try {

			ps = con.prepareStatement(deleteQuary);

			ps.setInt(1, s1.getRollNo());

			int leave_ack = ps.executeUpdate();

			if (leave_ack > 0) {
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

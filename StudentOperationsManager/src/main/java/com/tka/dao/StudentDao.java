package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Student;
import com.tka.utility.DBUtility;

public class StudentDao {

	private String selectQuery = "SELECT * FROM Student";
	private String insertQuery = "INSERT INTO Student VALUES(?,?,?)";
	private String updateQuery = "UPDATE Student SET marks = ?, name = ? WHERE rollNo = ?";
	private String deleteQuery = "DELETE FROM Student WHERE rollNo = ?";
	private String findQuery = "SELECT * FROM Student WHERE rollNo = ?";

	private PreparedStatement ps = null;
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	private List<Student> allStudents = null;
	private List<Student> findStudents = null;
	private Student obj = null;

	public List<Student> getAllStudent() {

		try {

			con = DBUtility.getConnection();

			st = con.createStatement();

			rs = st.executeQuery(selectQuery);

			allStudents = new ArrayList<Student>();

			while (rs.next()) {

				obj = new Student();
				obj.setRollNo(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setMarks(rs.getInt(3));

				allStudents.add(obj);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return allStudents;
	}

	public boolean addStudents(Student s1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(insertQuery);

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
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public boolean updateStudents(Student s1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(updateQuery);

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
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public boolean deleteStudents(Student s1, Connection con) {

		try {

			ps = con.prepareStatement(deleteQuery);

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
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Student> findStudents(Student s1) {

		try {

			con = DBUtility.getConnection();

			ps = con.prepareStatement(findQuery);

			ps.setInt(1, s1.getRollNo());

			rs = ps.executeQuery();

			findStudents = new ArrayList<Student>();

			while (rs.next()) {

				obj = new Student();
				obj.setRollNo(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setMarks(rs.getInt(3));

				findStudents.add(obj);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return findStudents;
	}

}

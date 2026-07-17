package com.tka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.tka.dao.LeaveDao;
import com.tka.dao.StudentDao;
import com.tka.entity.Student;
import com.tka.utility.StudentUtility;

public class StudentService {

	static StudentDao studentDao = null;
	static LeaveDao leaveDao = null;
	private static PreparedStatement ps = null;
	private static Connection con = null;

	public List<Student> getAllStudent() {

		studentDao = new StudentDao();
		List<Student> allStudents = studentDao.getAllStudent();
		return allStudents;

	}

	public static boolean addStudents(Student s1) {

		studentDao = new StudentDao();
		if (s1.getRollNo() < 0 || s1.getRollNo() > 500 || s1.getMarks() < 0 || s1.getMarks() > 100) {
			return false;
		} else {
			boolean student_ack = StudentDao.addStudents(s1);
			return student_ack;
		}

	}

	public static boolean updateStudents(Student s1) {

		studentDao = new StudentDao();
		if (s1.getRollNo() < 0 || s1.getRollNo() > 500 || s1.getMarks() < 0 || s1.getMarks() > 100) {
			return false;
		} else {
			boolean student_ack = StudentDao.updateStudents(s1);
			return student_ack;
		}

	}

	public static boolean deleteStudents(Student s1) {

		studentDao = new StudentDao();

		leaveDao = new LeaveDao();

		try {

			con = StudentUtility.getConnection();

			con.setAutoCommit(false);

			if (s1.getRollNo() < 0 || s1.getRollNo() > 500) {
				return false;
			} else {
				boolean leave_ack = leaveDao.deleteLeaves(s1, con);
				boolean student_ack = studentDao.deleteStudents(s1, con);
				if (leave_ack && student_ack) {
					con.commit();
					return true;
				} else {
					con.rollback();
					return false;
				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

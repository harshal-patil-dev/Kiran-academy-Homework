package com.tka.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.tka.dao.LeaveDao;
import com.tka.dao.StudentDao;
import com.tka.entity.Student;
import com.tka.utility.DBUtility;

public class StudentService {

	private StudentDao studentDao = new StudentDao();
	private LeaveDao leaveDao = null;
	private Connection con = null;

	public List<Student> getAllStudent() {

		List<Student> allStudents = studentDao.getAllStudent();
		return allStudents;

	}

	public boolean addStudents(Student s1) {

		if (s1.getRollNo() < 0 || s1.getRollNo() > 500 || s1.getMarks() < 0 || s1.getMarks() > 100) {
			return false;
		} else {
			boolean student_ack = studentDao.addStudents(s1);
			return student_ack;
		}

	}

	public boolean updateStudents(Student s1) {

		if (s1.getRollNo() < 0 || s1.getRollNo() > 500 || s1.getMarks() < 0 || s1.getMarks() > 100) {
			return false;
		} else {
			boolean student_ack = studentDao.updateStudents(s1);
			return student_ack;
		}

	}

	public boolean deleteStudents(Student s1) {

		leaveDao = new LeaveDao();

		try {

			con = DBUtility.getConnection();

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
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public List<Student> findStudents(Student s1) {
		
			List<Student> findStudent = studentDao.findStudents(s1);
			return findStudent;
	}

}
package com.tka.service;

import java.util.List;

import com.tka.dao.StudentDao;
import com.tka.entity.Student;

public class StudentService {

	public List<Student> getAllStudent() {
		
		StudentDao studentDao = new StudentDao();
		List<Student> allStudent = studentDao.getAllStudent();
		
		return allStudent;
	}

}

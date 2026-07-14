package com.tka.controller;

import com.tka.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		
		StudentService studentService = new StudentService();
        studentService.getAllStudent();
	}

}

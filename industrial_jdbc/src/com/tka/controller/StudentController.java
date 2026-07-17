package com.tka.controller;

import java.util.List;
import com.tka.entity.Student;
import com.tka.service.StudentService;

public class StudentController {

	StudentService studentService = null;

	public List<Student> getAllStudent() {

		studentService = new StudentService();
		List<Student> allStudents = studentService.getAllStudent();
		return allStudents;
	}

	public boolean addStudents() {
	    	
		studentService = new StudentService();
		Student s1 = new Student();
		int rollNo = 3;
		String name = "Pravin patil";
		int marks = 70;
		
		s1.setRollNo(rollNo);
		s1.setName(name);
		s1.setMarks(marks);
		
		boolean student_ack = studentService.addStudents(s1);
		if(student_ack) {
			System.out.println("Student Added Succesfully");
		} else {
			System.out.println("invalid data Please Try Again");
		}
		return false;
	}

	public boolean updateStudents() {
		
		studentService = new StudentService();
		Student s1 = new Student();
		
		int rollNo = 6;
		String name = "Pravin patil";
		int marks = 85;
		
		s1.setRollNo(rollNo);
		s1.setName(name);
		s1.setMarks(marks);
		
		boolean student_ack = studentService.updateStudents(s1);
		if(student_ack) {
		System.out.println("Data Updated Succesfully");
	    } else {
		System.out.println("invalid data Please Try Again");
	     }
		return false;
}

	public boolean deleteStudents() {
		    
		    studentService = new StudentService();
		    
			Student s1 = new Student();
	
			int rollNo = 3;
			s1.setRollNo(rollNo);
			
			boolean student_ack = studentService.deleteStudents(s1);
			if(student_ack) {
				System.out.println("Student Deleted Succesfully With Leaves...");
			} else {
				System.out.println("Please Try Again!");
			}
		
		return false;
	}

}

package com.tka.controller;

import java.util.List;
import java.util.Scanner;
import com.tka.entity.Student;
import com.tka.service.StudentService;
import com.tka.utility.DBUtility;

public class StudentController {

	private StudentService studentService = new StudentService();
	Scanner scanner = new Scanner(System.in);

	public List<Student> getAllStudent() {

		List<Student> allStudents = studentService.getAllStudent();
		if (!allStudents.isEmpty()) {
			System.out.println("====================================");
			System.out.println("         STUDENT DETAILS");
			System.out.println("====================================");
			return allStudents;
		} else {
			System.out.println("Student not exists...");
			return null;
		}

	}

	public boolean addStudents() {

		System.out.println("====================================");
		System.out.println("          ADD NEW STUDENT");
		System.out.println("====================================\r\n");

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();

		DBUtility.loading();

		Student s1 = new Student();
		s1.setRollNo(rollNo);

		List<Student> findStudent = studentService.findStudents(s1);

		while (!findStudent.isEmpty()) {

			System.out.println("----------------------------");
			System.out.println("Student is Exists!");
			System.out.println("----------------------------");
			System.out.println(findStudent);

			System.out.println("Enter Roll Number :");
			rollNo = scanner.nextInt();

			DBUtility.loading();

			s1.setRollNo(rollNo);

			findStudent = studentService.findStudents(s1);

		}

		System.out.println("----------------------------");

		scanner.nextLine();
		System.out.println("Enter Name :");
		String name = scanner.nextLine();

		System.out.println("----------------------------");

		System.out.println("Enter Marks :");
		int marks = scanner.nextInt();

		DBUtility.loading();

		s1.setRollNo(rollNo);
		s1.setName(name);
		s1.setMarks(marks);

		boolean student_ack = studentService.addStudents(s1);
		if (student_ack) {
			System.out.println("------------------------------------");
			System.out.println("Student Added Successfully");
			System.out.println("------------------------------------");
		} else {
			System.out.println("------------------------------------");
			System.out.println("Something went wrong!\r\n" + "Added Failed.");
			System.out.println("------------------------------------");
		}
		return student_ack;
	}

	public boolean updateStudents() {

		System.out.println("====================================");
		System.out.println("         UPDATE STUDENT");
		System.out.println("====================================\r\n");

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();

		DBUtility.loading();

		Student s1 = new Student();
		s1.setRollNo(rollNo);

		List<Student> findStudent = studentService.findStudents(s1);

		if (!findStudent.isEmpty()) {
			System.out.println("Current Details");
			System.out.println("----------------------------");
			System.out.println(findStudent);

			scanner.nextLine();

			System.out.println("Enter New Name :");
			String name = scanner.nextLine();

			System.out.println("----------------------------");

			System.out.println("Enter New Marks :");
			int marks = scanner.nextInt();

			s1.setName(name);
			s1.setMarks(marks);

			boolean student_ack = studentService.updateStudents(s1);
			if (student_ack) {
				System.out.println("------------------------------------");
				System.out.println("Student Updated Successfully");
				System.out.println("------------------------------------");
			} else {
				System.out.println("------------------------------------");
				System.out.println("Something went wrong!\r\n" + "Update Failed.");
				System.out.println("------------------------------------");
			}

			return student_ack;

		} else {
			System.out.println("------------------------------------");
			System.out.println("Student Not Exits!");
			System.out.println("------------------------------------");
			return false;
		}

	}

	public boolean deleteStudents() {

		System.out.println("====================================");
		System.out.println("         DELETE STUDENT");
		System.out.println("====================================\r\n");

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();
		
		Student s1 = new Student();
		s1.setRollNo(rollNo);
		
		List<Student> findStudent = studentService.findStudents(s1);
		
		if(!findStudent.isEmpty()) {
			
			boolean student_ack = studentService.deleteStudents(s1);

			if (student_ack) {
				System.out.println("------------------------------------");
				System.out.println("Student Deleted Successfully\r\n" 
				+ "with Leave Records!");
				System.out.println("------------------------------------");
				return true;
			} else {
				System.out.println("------------------------------------");
				System.out.println("Please Try Again!");
				System.out.println("------------------------------------");
				return false;
			}
			
		} else {
			System.out.println("------------------------------------");
			System.out.println("Student Not Exits!");
			System.out.println("------------------------------------");
			return false;
		}

	}

}

package com.tka.client;

import java.util.Scanner;
import com.tka.controller.LeaveController;
import com.tka.controller.StudentController;
import com.tka.utility.DBUtility;

public class StudentTest {

	int choice = 0;
	private StudentController studentController = new StudentController();
	private LeaveController leaveController = new LeaveController();

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		StudentTest t1 = new StudentTest();
		t1.start();

	}

	public void start() {

		do {
			this.menu();
		} while (choice <= 8 && choice > 0);

	}

	public void menu() {

		System.out.println("====================================\r\n"
				+ " STUDENT & LEAVE MANAGEMENT SYSTEM\r\n"
				+ "====================================\r\n"
				+ "\r\n"
				+ "1 -> Display Students\r\n"
				+ "2 -> Add Student\r\n"
				+ "3 -> Update Student\r\n"
				+ "4 -> Delete Student\r\n"
				+ "\r\n"
				+ "5 -> Display Leaves\r\n"
				+ "6 -> Apply Leave\r\n"
				+ "7 -> Update Leave\r\n"
				+ "8 -> Cancel Leave\r\n"
				+ "\r\n"
				+ "0 -> Exit\r\n"
				+ "\r\n"
				+ "====================================");

		System.out.println("Enter Choice :");
		choice = scanner.nextInt();
		while (choice > 8) {
			System.out.println("Invalid Choice!");
			System.out.println("----------------");
			System.out.println("Enter Choice :");
			choice = scanner.nextInt();
		}

		switch (choice) {
		case 1:
			DBUtility.loading();
			System.out.println(studentController.getAllStudent());
			break;
		case 2:
			DBUtility.loading();
			studentController.addStudents();
			break;
		case 3:
			DBUtility.loading();
			studentController.updateStudents();
			break;
		case 4:
			DBUtility.loading();
			studentController.deleteStudents();
			break;
		case 5:
			DBUtility.loading();
			System.out.println(leaveController.getAllLeaves());
			break;
		case 6:
			DBUtility.loading();
			leaveController.addLeaves();
			break;
		case 7:
			DBUtility.loading();
			leaveController.updateLeaves();
			break;
		case 8:
			DBUtility.loading();
			leaveController.deleteLeaves();
			break;
		case 0:
			exit();
			break;
		}

	}

	private void exit() {
		System.out.println("===========================================================\r\n"
				+ "\r\n"
				+ "Thank You For Using\r\n"
				+ "Industrial Student Management System\r\n"
				+ "Have a Nice Day..\r\n"
				+ "\r\n"
				+ "===========================================================");
	}

}

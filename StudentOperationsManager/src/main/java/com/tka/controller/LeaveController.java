package com.tka.controller;

import java.util.List;
import java.util.Scanner;
import com.tka.entity.Leaves;
import com.tka.entity.Student;
import com.tka.service.LeaveService;
import com.tka.service.StudentService;
import com.tka.utility.DBUtility;

public class LeaveController {

	Scanner scanner = new Scanner(System.in);

	private LeaveService leaveService = new LeaveService();
	private StudentService studentService = new StudentService();

	public List<Leaves> getAllLeaves() {

		List<Leaves> allLeaves = leaveService.getAllLeaves();

		if (!allLeaves.isEmpty()) {
			System.out.println("====================================");
			System.out.println("         Leaves DETAILS");
			System.out.println("====================================");
			return allLeaves;
		} else {
			System.out.println("Leaves not exits...");
			return null;
		}
	}

	public boolean addLeaves() {

		System.out.println("====================================");
		System.out.println("          ADD NEW LEAVE");
		System.out.println("====================================\r\n");

		boolean leave_ack = false;

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();

		DBUtility.loading();

		Leaves l1 = new Leaves();
		l1.setRollNo(rollNo);

		Student s1 = new Student();
		s1.setRollNo(rollNo);

		List<Student> findStudent = studentService.findStudents(s1);
		List<Leaves> findLeaves = leaveService.findLeaves(l1);

		if (!findStudent.isEmpty()) {

			if (!findLeaves.isEmpty()) {

				System.out.println("----------------------------");
				System.out.println("Leave is Exists!");
				System.out.println("----------------------------");
				System.out.println(findLeaves);

			}

			if (findLeaves.isEmpty()) {

				System.out.println("----------------------------");

				System.out.println("Enter Leave Id Number :");
				int l_id = scanner.nextInt();

				System.out.println("----------------------------");

				scanner.nextLine();
				System.out.println("Enter Start Date :");
				System.out.println("Ex : 2026-7-18!");
				String start = scanner.nextLine();

				System.out.println("----------------------------");

				System.out.println("Enter End Date :");
				System.out.println("Ex : 2026-7-18!");
				String end = scanner.nextLine();

				System.out.println("----------------------------");

				System.out.println("Enter Reason :");
				String reason = scanner.nextLine();

				DBUtility.loading();

				l1.setL_id(l_id);
				l1.setStart(start);
				l1.setEnd(end);
				l1.setReason(reason);
				l1.setRollNo(rollNo);

				leave_ack = leaveService.addLeaves(l1);
				if (leave_ack) {
					System.out.println("------------------------------------");
					System.out.println("Leave Apply Successfully");
					System.out.println("------------------------------------");
				} else {
					System.out.println("------------------------------------");
					System.out.println("Something went wrong!\r\n" + "Apply Failed.");
					System.out.println("------------------------------------");
				}
			}

		} else {
			System.out.println("------------------------------------");
			System.out.println("Student Not Found!");
			System.out.println("------------------------------------");
			return false;
		}
		
		return leave_ack;
	}

	public boolean updateLeaves() {

		System.out.println("====================================");
		System.out.println("         UPDATE LEAVES");
		System.out.println("====================================\r\n");

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();

		DBUtility.loading();

		Leaves l1 = new Leaves();
		l1.setRollNo(rollNo);

		Student s1 = new Student();
		s1.setRollNo(rollNo);

		List<Student> findStudent = studentService.findStudents(s1);
		List<Leaves> findLeaves = leaveService.findLeaves(l1);

		if (!findStudent.isEmpty()) {

			if (!findLeaves.isEmpty()) {
				System.out.println("Current Details");
				System.out.println("----------------------------");
				System.out.println(findLeaves);

				System.out.println("Enter New Leave Id Number :");
				int l_id = scanner.nextInt();

				System.out.println("----------------------------");

				scanner.nextLine();
				System.out.println("Enter New Start Date :");
				System.out.println("Ex : 2026-7-18!");
				String start = scanner.nextLine();

				System.out.println("----------------------------");

				System.out.println("Enter New End Date :");
				System.out.println("Ex : 2026-7-18!");
				String end = scanner.nextLine();

				System.out.println("----------------------------");

				System.out.println("Enter Reason :");
				String reason = scanner.nextLine();

				DBUtility.loading();

				l1.setL_id(l_id);
				l1.setStart(start);
				l1.setEnd(end);
				l1.setReason(reason);
				l1.setRollNo(rollNo);

				boolean student_ack = leaveService.updateLeaves(l1);
				if (student_ack) {
					System.out.println("------------------------------------");
					System.out.println("Leaves Updated Successfully");
					System.out.println("------------------------------------");
				} else {
					System.out.println("------------------------------------");
					System.out.println("Something went wrong!\r\n" + "Update Failed.");
					System.out.println("------------------------------------");
				}

				return student_ack;

			} else {
				System.out.println("------------------------------------");
				System.out.println("No Leave Record Found!");
				System.out.println("------------------------------------");
				return false;
			}

		} else {
			System.out.println("------------------------------------");
			System.out.println("Student Not Found!");
			System.out.println("------------------------------------");
			return false;
		}

	}

	public boolean deleteLeaves() {

		System.out.println("====================================");
		System.out.println("         APPLY FOR LEAVE");
		System.out.println("====================================\r\n");

		System.out.println("Enter Roll Number :");
		int rollNo = scanner.nextInt();

		DBUtility.loading();
		
		Leaves l1 = new Leaves();
		l1.setRollNo(rollNo);
		
		Student s1 = new Student();
		s1.setRollNo(rollNo);

		List<Student> findStudent = studentService.findStudents(s1);
		List<Leaves> findLeaves = leaveService.findLeaves(l1);
		
		if (!findStudent.isEmpty()) {
			
			if (!findLeaves.isEmpty()) {

				boolean leave_ack = leaveService.deleteLeaves(l1);
				if (leave_ack) {
					System.out.println("------------------------------------");
					System.out.println("Leaves Canceled Successfully");
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
				System.out.println("No Leave Record Found!");
				System.out.println("------------------------------------");
				return false;
			}
			
		} else {
			System.out.println("------------------------------------");
			System.out.println("Student Not Found!");
			System.out.println("------------------------------------");
			return false;
		}

	}
}

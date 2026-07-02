package com.harsh.july1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Student_Operations {
	
	int choice = 0;
	
	Scanner scanner = new Scanner(System.in);
	
	List<Student> data = new ArrayList<>();
	
	public void start() {		
		
		System.out.println("--------------------------------");
		System.out.println("   Student Management System");
		System.out.println("--------------------------------");
		
		System.out.println("\n"
				+ "1. Add Student\n"
				+ "2. Display Students\n"
				+ "3. Search Student by Roll No\n"
				+ "4. Update Marks\n"
				+ "5. Topper Student\n"
				+ "6. Average Marks\n"
				+ "7. Remove Student\n"
				+ "8. Exit"
				+ "\n");
		
		System.out.println("--------------------------------");
		System.out.println("Enter choice :");
		choice = scanner.nextInt();	
		
		switch(choice){
		case 1:
			this.addStudent();
			break;
		case 2:
			this.displayStudent();
			break;
		case 3:
			this.searchStudent();
			break;
		case 4:
			this.updateMarks();
			break;
		case 5:
			this.findTopper();
			break;
		case 6:
			this.averageMarks();
			break;
		case 7:
			this.removeStudent();
			break;
		case 8:
			this.exitOperations();
			break;
		}
		
	}
	
	private void addStudent() {
		
		System.out.println("--------------------------------");
		System.out.println("Add Student Details");
		System.out.println("--------------------------------"
				+ "\n");
		
		System.out.println("Enter Student Roll :");
		int roll = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.println("Enter Student Name :");
		String name = scanner.nextLine();
		
		System.out.println("Enter Student Marks :");
		double marks = scanner.nextDouble();
		
		scanner.nextLine();
		
		System.out.println("Enter Student Course :");
		String course = scanner.nextLine();
		
		data.add(new Student(roll, name, marks, course));
		
		System.out.println("--------------------------------");
		System.out.println("Student Add Successfully");
		System.out.println("--------------------------------");
		
	}

	private void displayStudent() {
		
		if(!data.isEmpty()) {
			System.out.println(data);
		} else {
		System.out.println("--------------------------------");
		System.out.println("Student is not found...");
		System.out.println("--------------------------------");
		}
		
	}

	private void searchStudent() {
		
		boolean found = false;
		
		System.out.println("--------------------------------");
		System.out.println("Search Student by roll");
		System.out.println("--------------------------------");
		
		System.out.println("Enter Student Roll :");
		int roll = scanner.nextInt();
		
		int findRoll;
		for(Student obj : data) {
			findRoll = obj.getRollNo();
			
			if(roll == findRoll) {
				found = true;
				System.out.println(obj);		
				}
		}
		
		if(!found) {
			System.out.println("--------------------------------");
			System.out.println("Student is not found...");
			System.out.println("--------------------------------");
		}
		
	}

	private void updateMarks() {
		
	boolean found = false;
		
		System.out.println("--------------------------------");
		System.out.println("Update Student marks");
		System.out.println("--------------------------------");
		
		System.out.println("Enter Student Roll :");
		int roll = scanner.nextInt();
		
		for(Student obj : data) {
			if(obj.getRollNo() == roll) {
				found = true;
				System.out.println("Current Marks :" + obj.getMarks());
				System.out.println("Enter New Marks :");
				double marks = scanner.nextDouble();
				
				if(marks <= 100) {
					obj.setMarks(marks);
					System.out.println("--------------------------------");
					System.out.println("Marks Updated Successfully");
					System.out.println("--------------------------------");
				} else {
					System.out.println("--------------------------------");
					System.out.println("Marks must be set under 100!");
					System.out.println("--------------------------------");
				}
			
			}
			
		}
		
		if(!found) {
			System.out.println("--------------------------------");
			System.out.println("Student is not found...");
			System.out.println("--------------------------------");
		}
		
	}

	private void findTopper() {
		
		if(!data.isEmpty()) {
		double current = data.get(0).getMarks();
		double nextMarks;
        for(Student obj : data) {
			nextMarks = obj.getMarks();
			if(current < nextMarks) {
				current = nextMarks;
			}
		
		}
		
        for(Student obj : data) {
        	if(obj.getMarks() == current) {
        		System.out.println("--------------------------------");
        		System.out.println("Toper Student Is : " + obj.getName());
        		System.out.println("--------------------------------");
        		System.out.println(obj);
        	}
        }
        
	} else {
		System.out.println("--------------------------------");
		System.out.println("Student is not found!");
		System.out.println("--------------------------------");
	}
		
		
	}

	private void averageMarks() {
		
		if(!data.isEmpty()) {
		System.out.println("--------------------------------");
		System.out.println("Average Marks Details");
		System.out.println("--------------------------------");
		
		double Average;
		double TotalMarks = 0;
		int NumberOfStudents = data.size();
		for(Student obj : data) {
			TotalMarks += obj.getMarks();
		}
		
		Average = TotalMarks / NumberOfStudents;
		
		System.out.println("Average Marks = "+ Average);
		System.out.println("--------------------------------");
	} else {
		System.out.println("--------------------------------");
		System.out.println("Student is not found so no average marks!");
		System.out.println("--------------------------------");
	}
}

	private void removeStudent() {
		
		boolean found = false;
		System.out.println("Enter Student Roll :");
		int roll = scanner.nextInt();
		
		Iterator<Student> selectRoll = data.iterator();
		
		while(selectRoll.hasNext()) {
			int currentRoll = selectRoll.next().getRollNo();
			if(currentRoll == roll) {
				found = true;
				selectRoll.remove();
			}
		}
		
		if(found) {
			System.out.println("--------------------------------");
			System.out.println("Student Removed Successfully");
			System.out.println("--------------------------------");
		} else {
			System.out.println("--------------------------------");
			System.out.println("Student not found!");
			System.out.println("--------------------------------");
		}
		
	}

	private void exitOperations() {
		System.out.println("--------------------------------");
		System.out.println("System Exits...");
		System.out.println("--------------------------------");
		
	}

	public void main() {
		
		do {
			this.start();
			
		} while(choice < 8);
		
		if(choice != 8) {
			this.start();
		}
		
	}
	

}

package com.harsh.july2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeOperations {

	int choice = 0;
	boolean continueMenu = false;
	Scanner scanner = new Scanner(System.in);
	
	Set<Employee> emp = new TreeSet<Employee>();
	List<Employee> IT = new ArrayList<>();
	List<Employee> HR = new ArrayList<>();
	List<Employee> Testing = new ArrayList<>();
	Map<String, List<Employee>> department = new TreeMap<>();

	public void start() {

		System.out.println("----------------------------------");
		System.out.println("   Employee Management System");
		System.out.println("----------------------------------");

		System.out.println("\n" + "1. Add Employee\r\n" + "2. Display Employees\r\n" + "3. Search by ID\r\n"
				+ "4. Update Salary\r\n" + "5. Delete Employee\r\n" + "6. Highest Salary Employee\r\n"
				+ "7. Department Wise Employees\r\n" + "8. Average Salary\r\n" + "9. Exit" + "\n");

		System.out.println("----------------------------------");
		System.out.println("Enter choice :");
		choice = scanner.nextInt();
		while (choice >= 10) {
			System.out.println("----------------------------------");
			System.out.println("Wrong choice!");
			System.out.println("----------------------------------");
			System.out.println("Enter choice :");
			choice = scanner.nextInt();
		}
		
		switch (choice) {
		case 1:
			this.addEmp();
			continueMenu = true;
			break;
		case 2:
			this.displayEmp();
			continueMenu = true;
			break;
		case 3:
			this.searchEmp();
			continueMenu = true;
			break;
		case 4:
			this.updateSalary();
			continueMenu = true;
			break;
		case 5:
			this.deleteEmp();
			continueMenu = true;
			break;
		case 6:
			this.highestSalaryEmp();
			continueMenu = true;
			break;
		case 7:
			this.departmentEmp();
			continueMenu = true;
			break;
		case 8:
			this.averageSalary();
			continueMenu = true;
			break;
		case 9:
			this.exit();
			continueMenu = false;
			break;
		}

	}

	private void addEmp() {
		System.out.println("----------------------------------");
		System.out.println("Add Employee Details");
		System.out.println("----------------------------------");

		System.out.println("Enter Employee Id :");
		int id = scanner.nextInt();
		boolean duplicateFind = false;

		int i = 0;
		while (i < 1) {

			duplicateFind = false;

			for (Employee obj : emp) {
				if (obj.getId() == id) {
					duplicateFind = true;
					System.out.println("----------------------------------");
					System.out.println("Id Exit!");
					System.out.println("----------------------------------");
					System.out.println("Enter Employee Id :");
					id = scanner.nextInt();
					break;
				}
			}

			if (!duplicateFind) {
				i++;
			}
		}

		System.out.println("----------------------------------");

		scanner.nextLine();

		System.out.println("Enter Employee Name :");
		String name = scanner.nextLine();
		System.out.println("----------------------------------");

		System.out.println("Enter Employee Department :");
		String depart = scanner.nextLine();
		System.out.println("----------------------------------");

		System.out.println("Enter Employee Salary :");
		double salary = scanner.nextDouble();
		boolean wrongSalary = false;

		int j = 0;
		while (j < 1) {

			wrongSalary = false;

			if (salary < 10000) {
				wrongSalary = true;
				System.out.println("---------------------------------------------------");
				System.out.println("Company rule: Employee salary must exceed 10,000...");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter Employee Salary :");
				salary = scanner.nextDouble();
			}

			if (!wrongSalary) {
				j++;
			}

		}

		emp.add(new Employee(id, name, depart, salary));

		System.out.println("----------------------------------");
		System.out.println("Employee Add Successfully...");
		System.out.println("----------------------------------");
	}

	private void displayEmp() {

		if (!emp.isEmpty()) {
			System.out.println("----------------------------------");
			System.out.println("Display Employee Details");
			System.out.println("----------------------------------");

			do {
				System.out.println("1. Direct Display" + "\n" + "2. Display using Department" + "\n" + "3. Exit");
				System.out.println("----------------------------------");
				System.out.println("Enter choice :");
				int choice = scanner.nextInt();

				while (choice >= 4) {
					System.out.println("----------------------------------");
					System.out.println("Wrong choice!");
					System.out.println("----------------------------------");
					System.out.println("Enter choice :");
					choice = scanner.nextInt();
				}

				switch (choice) {
				case 1:
					this.directDisplay();
					continueMenu = true;
					break;
				case 2:
					this.displayDepartment();
					continueMenu = true;
					break;
				case 3:
					continueMenu = false;
					break;
				}

			} while (continueMenu);

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Not Found!");
			System.out.println("----------------------------------");
		}

	}

	private void directDisplay() {

		System.out.println("-----------------------------");
		System.out.println("Direct Display");
		System.out.println("-----------------------------");
		System.out.println(emp);
	}

	private void displayDepartment() {

		boolean found = false;

		System.out.println("-----------------------------");
		System.out.println("Display Using Department");
		System.out.println("-----------------------------");

		scanner.nextLine();

		System.out.println("Enter Department :");
		String department = scanner.nextLine();

		for (Employee obj : emp) {
			if (obj.getDepartment().equalsIgnoreCase(department)) {
				found = true;
				System.out.println(obj);
			}

		}

		if (!found) {
			System.out.println("-----------------------------");
			System.out.println("Department Not Found!");
			System.out.println("-----------------------------");
		}

	}

	private void searchEmp() {

		boolean found = false;
		if (!emp.isEmpty()) {

			System.out.println("-----------------------------");
			System.out.println("Employee Search by ID");
			System.out.println("-----------------------------");

			System.out.println("Enter Employee Id :");
			int id = scanner.nextInt();

			for (Employee obj : emp) {

				if (obj.getId() == id) {
					found = true;
					System.out.println(obj);
				}

			}

			if (!found) {
				System.out.println("----------------------------------");
				System.out.println("This employee does not exist!");
				System.out.println("----------------------------------");
			}

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");
		}

	}

	private void updateSalary() {

		boolean idFound = false;

		if (!emp.isEmpty()) {

			System.out.println("----------------------------------");
			System.out.println("Update Employee Salary");
			System.out.println("----------------------------------");

			System.out.println("Enter Employee Id :");
			int id = scanner.nextInt();

			for (Employee obj : emp) {

				idFound = false;

				if (obj.getId() == id) {
					idFound = true;
					System.out.println("Current Salary Is : " + obj.getSalary());
					System.out.println("----------------------------------");
					System.out.println("Enter updated salary : ");
					double salary = scanner.nextDouble();
					boolean wrongSalary = false;

					int j = 0;
					while (j < 1) {

						wrongSalary = false;

						if (salary < 10000) {
							wrongSalary = true;
							System.out.println("---------------------------------------------------");
							System.out.println("Company rule: Employee salary must exceed 10,000...");
							System.out.println("---------------------------------------------------");
							System.out.println("Enter Employee Salary :");
							salary = scanner.nextDouble();
						}

						if (!wrongSalary) {
							j++;
						}

					}

					obj.setSalary(salary);
					System.out.println("----------------------------------");
					System.out.println("Employee Salary Update Successfully...");
					System.out.println("----------------------------------");

				}

			}

			if (!idFound) {
				System.out.println("----------------------------------");
				System.out.println("This employee ID is incorrect!");
				System.out.println("----------------------------------");
			}

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");

		}

	}

	private void deleteEmp() {

		boolean idFound = false;

		Iterator<Employee> Iterator_emp = emp.iterator();

		if (!emp.isEmpty()) {

			System.out.println("----------------------------------");
			System.out.println("Delete Employee Using Id");
			System.out.println("----------------------------------");

			System.out.println("Enter Employee Id :");
			int id = scanner.nextInt();

			idFound = false;

			while (Iterator_emp.hasNext()) {
				int nextId = Iterator_emp.next().getId();
				if (nextId == id) {
					idFound = true;
					Iterator_emp.remove();
					System.out.println("----------------------------------");
					System.out.println("Employee Delete Successfully...");
					System.out.println("----------------------------------");

				}

			}

			if (!idFound) {
				System.out.println("----------------------------------");
				System.out.println("This employee ID Is Incorrect!");
				System.out.println("----------------------------------");

			}

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");

		}

	}

	private void highestSalaryEmp() {
		
		if (!emp.isEmpty()) {
			System.out.println("----------------------------------");
			System.out.println("Highest Salary Employee");
			System.out.println("----------------------------------");

			Employee current = emp.iterator().next();
			double currentSalary = current.getSalary();
			double highestSalary;
			for (Employee obj1 : emp) {
				highestSalary = obj1.getSalary();
				if (currentSalary < highestSalary) {
					currentSalary = highestSalary;
				}
			}

			for (Employee obj2 : emp) {
				if (currentSalary == obj2.getSalary()) {
					System.out.println(obj2);
				}
			}

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");

		}

	}

	private void departmentEmp() {
		if (!emp.isEmpty()) {

			System.out.println("----------------------------------");
			System.out.println("Department Wise Employees");
			System.out.println("----------------------------------");

			for(Employee obj : emp) {
				if(obj.getDepartment().equalsIgnoreCase("IT")) {
					IT.add(obj);
					
				} else if(obj.getDepartment().equalsIgnoreCase("HR")) {
					HR.add(obj);
					
				} else if(obj.getDepartment().equalsIgnoreCase("Testing")) {
					Testing.add(obj);
				}
			}
			
			department.put("IT", IT);
			department.put("HR", HR);
			department.put("Testing", Testing);
			System.out.println("--------------------------");
			System.out.println("Department :" + department);
			System.out.println("--------------------------");
			
		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");

		}

	}

	private void averageSalary() {

		if (!emp.isEmpty()) {

			System.out.println("----------------------------------");
			System.out.println("Average Salary Of Company");
			System.out.println("----------------------------------");

			double average = 0;
			double totalSalary = 0;
			for (Employee obj : emp) {
				totalSalary += obj.getSalary();
			}
			
			average = totalSalary / emp.size();
			System.out.println("Average Salary Is : " + average);

		} else {
			System.out.println("----------------------------------");
			System.out.println("Employee Data Not Exit!");
			System.out.println("----------------------------------");

		}

	}

	private void exit() {
		System.out.println("----------------------------------");
		System.out.println("System Exits...");
		System.out.println("----------------------------------");

	}

	public void main() {

		do {
			this.start();
		} while (continueMenu);

		if (choice != 9) {
			this.start();
		}

	}

}

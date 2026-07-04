package com.harsh.july2;

public class Employee implements Comparable<Employee>{

	private int id;
	private String name;
	private String department;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String department, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\n----------------------------------\n" + "Employee Details:\n" + "ID         : " + id + "\n"
				+ "Name       : " + name + "\n" + "Department : " + department + "\n" + "Salary     : " + salary + "\n"
				+ "----------------------------------";
	}

	@Override
	public int compareTo(Employee e) {
		return this.id - e.id;
	}

}

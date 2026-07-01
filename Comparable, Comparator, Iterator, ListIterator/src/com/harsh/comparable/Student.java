package com.harsh.comparable;

public class Student implements Comparable<Student>{
	
	private int roll;
	private String name;
	
	public Student() {
		super();
		
	}

	public Student(int roll, String name) {
		super();
		this.roll = roll;
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.getRoll() - o.getRoll();
	}
	
	/* @Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	} */

}

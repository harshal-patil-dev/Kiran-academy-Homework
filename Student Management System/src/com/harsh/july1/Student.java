package com.harsh.july1;

public class Student {
	
	private int rollNo;
	private String name;
	private double marks;
	private String course;
	
	public Student() {
		super();
	}

	public Student(int rollNo, String name, double marks, String course) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.course = course;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
	    return "Student " + "\n"
	    	    + "--------------------------------\n" +
	           "  rollNo = " + rollNo + "\n" +
	           "  name = " + name + "\n" +
	           "  marks = " + marks + "\n" +
	           "  course = " + course + "\n"
	           	+ "--------------------------------" + "\n";
	}


}

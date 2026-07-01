package com.harsh.comparable;

import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		Set<String> db = new TreeSet<>();
		
		Set<Student> div_a = new TreeSet<Student>();
		
		db.add("Harshal");
		db.add("Yash");
		db.add("Aarti");
		db.add("Mahesh");
		
		System.out.println("Manual sorting using TreeSet:");
		System.out.println(db);
		
		div_a.add(new Student(1, "Harshal"));
		div_a.add(new Student(2, "Yash"));
		div_a.add(new Student(3, "Aarti"));
		div_a.add(new Student(4, "Mahesh"));
		
		System.out.println("");
		
		System.out.println("Sorting by roll number using Comparable:");
		System.out.println(div_a);
		
		System.out.println("");
		
		/* System.out.println("Sorting by name using Comparable:\r\n");
		System.out.println(div_a); */
		
	}

}
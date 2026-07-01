package com.harsh.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Student> db = new ArrayList<>();

		db.add(new Student(1, "Harshal", 88));
		db.add(new Student(4, "Gopal", 56));
		db.add(new Student(3, "Yash", 67));
		db.add(new Student(2, "Harish", 78));

		System.out.println("Comparator sorting using roll number:");
		Collections.sort(db, new Rollcomparator());
		System.out.print(db);

		System.out.println("\n"+
				"");

		System.out.println("Comparator sorting using name:");
		Collections.sort(db, new Namecomparator());
		System.out.print(db);

		System.out.println("\n"+
				"");

		System.out.println("Comparator sorting using marks:");
		Collections.sort(db, new Markscomparator());
		System.out.print(db);

	}

}

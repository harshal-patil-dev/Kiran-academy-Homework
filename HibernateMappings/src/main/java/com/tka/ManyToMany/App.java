package com.tka.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tka.utility.ConfigurationDB;

public class App {

	public static void main(String[] args) {
		
		Session session = ConfigurationDB.getConnection();
		
		Transaction txn = session.beginTransaction();
		
		Course course1 = new Course();
		Course course2 = new Course();
		
		Student student1 = new Student();
		Student student2 = new Student();
		
		List<Course> c1 = new ArrayList<>();
		c1.add(course1);
		c1.add(course2);
		
		List<Student> s1 = new ArrayList<>();
		
		student1.setName("Om dhangar");
		student1.setCourse(c1);
		
		student2.setName("Gopal patil");
		student2.setCourse(c1);
		
		s1.add(student1);
		s1.add(student2);
		
		course1.setName("Java");
		course1.setStudent(s1);
		
		course2.setName("Testing");
		course2.setStudent(s1);
		
		c1.add(course1);
		c1.add(course2);
		
		session.save(student1);
		session.save(student2);
		txn.commit();
		session.close();
		
	}

}

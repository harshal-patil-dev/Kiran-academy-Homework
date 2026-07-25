package com.tka.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.tka.ManyToMany.Course;
import com.tka.ManyToMany.Student;
import com.tka.ManyToOne.DepartmentOne;
import com.tka.ManyToOne.EmployeeMany;
import com.tka.OneToMany.Department;
import com.tka.OneToMany.Employee;
import com.tka.OneToOne.Passport;
import com.tka.OneToOne.Person;

public class ConfigurationDB {
	
	public static Session getConnection() {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("mysqlHibernate.cfg.xml");
		
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Passport.class);
		
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Employee.class);
		
		cfg.addAnnotatedClass(DepartmentOne.class);
		cfg.addAnnotatedClass(EmployeeMany.class);
		
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Course.class);
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
		
	}

}

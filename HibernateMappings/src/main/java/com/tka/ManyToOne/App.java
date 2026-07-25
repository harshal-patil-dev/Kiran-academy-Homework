package com.tka.ManyToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tka.utility.ConfigurationDB;

public class App {
	
	public static void main(String[] args) {
		
		Session session = ConfigurationDB.getConnection();
		
		Transaction txn = session.beginTransaction();
		
		DepartmentOne department = new DepartmentOne();
		department.setDname("IT");
		
		EmployeeMany employee = new EmployeeMany();
		employee.setDepartment(department);
		employee.setEname("Harshal patil");
		employee.setSalary(55000);
		
		session.save(employee);
		System.out.println("Employee + department saved successfully");
		txn.commit();
		session.close();
		
	}

}

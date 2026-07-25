package com.tka.OneToMany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tka.utility.ConfigurationDB;

public class App {

	public static void main(String[] args) {
		
		Session session = ConfigurationDB.getConnection();
		
		Transaction txn = session.beginTransaction();
		
		Employee employee1 = new Employee();
		employee1.setName("Yash patil");
		employee1.setSalary(15000);
		
		Employee employee2 = new Employee();
		employee2.setName("Rakesh sharma");
		employee2.setSalary(12000);
		
		Employee employee3 = new Employee();
		employee3.setName("Mahesh varma");
		employee3.setSalary(25000);
		
		List<Employee> allEmp = new ArrayList();
		allEmp.add(employee1);
		allEmp.add(employee2);
		allEmp.add(employee3);
		
		Department department = new Department();
		department.setAllEmp(allEmp);
		department.setName("IT");
		
		session.save(department);
		System.out.println("Employee with department saved successfully");
		txn.commit();
		session.close();
		
	}

}

package com.tka.OneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tka.utility.ConfigurationDB;

public class App {

	public static void main(String[] args) {
		
		Session session = ConfigurationDB.getConnection();
		
		Transaction txn = session.beginTransaction();
		
		Passport passport = new Passport();
		passport.setPassportNo("INDIA123Harshal");
		
		Person person = new Person();
		person.setPassport_id(passport);
		person.setPname("Harshal patil");
		
		session.save(person);
		System.out.println("Person and passport details saved successfully.");
		txn.commit();
		session.close();
		
	}

}

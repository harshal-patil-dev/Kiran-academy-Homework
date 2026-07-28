package com.tka.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.tka.entity.Product;

public class ProductDB {
	
	private Configuration cfg = null;
	private SessionFactory sessionFactory = null;
    private	Session session = null;
	
	public static Session getConnection() {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("mysqlHibernate.cfg.xml");
		
//		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		return session;
		
	}
	
	public static void loading() {
		try {
			System.out.println("Please wait...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

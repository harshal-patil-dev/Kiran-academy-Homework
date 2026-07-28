package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tka.entity.Product;
import com.tka.utility.ProductDB;

public class ProductDao {
   
	private Criteria criteria = null;
	private List<Product> findProduct = null;
	private Session session = null;

	public List<Product> getAllProducts() {

		session = ProductDB.getConnection();
		
		criteria = session.createCriteria(Product.class);
		
//		criteria.setProjection(Projections.property("pname"));
		
//		criteria.add(Restrictions.gt("price",50000));
		
		List<Product> allProducts = criteria.list();

		return allProducts;
	}

	public boolean addProducts(Product p1) {

		session = ProductDB.getConnection();

		Transaction txn = session.beginTransaction();

		session.save(p1);
		
		if (p1.getId() > 0) {
		    txn.commit();
		    return true;
		} else {
		    txn.rollback();
		    return false;
		}

	}

	public boolean findProduct(Product p1) {
		
		session = ProductDB.getConnection();
		
		Criteria criteria = session.createCriteria(Product.class);
		
		criteria.add(Restrictions.eq("id", p1.getId()));
		
		List<Product> allProducts = criteria.list();

		
//		String hql = "FROM Product WHERE id = "+ p1.getId() +"";
//		
//		Query<Product> query = session.createQuery(hql);
//		
//		List<Product> list = query.getResultList();
		
		if (allProducts.isEmpty()) {
		    return false;
		} else {
		    return true;
		}
		
	}
}

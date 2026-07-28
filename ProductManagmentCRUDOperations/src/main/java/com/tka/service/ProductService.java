package com.tka.service;

import java.util.List;
import com.tka.dao.ProductDao;
import com.tka.entity.Product;

public class ProductService {
	
	private ProductDao productDao = new ProductDao();

	public List<Product> getAllProducts() {
		List<Product> allProducts = productDao.getAllProducts();
		return allProducts;
	}

	public boolean addProducts(Product p1) {
		
		if(p1.getId() < 0 || p1.getId() > 100) {
			return false;
		} else {
			boolean addProducts = productDao.addProducts(p1);
			return addProducts;
		}
	}

	public boolean findProduct(Product p1) {
		if(p1.getId() < 0 || p1.getId() > 100) {
			return false;
		} else {
			boolean findProduct = productDao.findProduct(p1);
			return findProduct;
		}
	}

}

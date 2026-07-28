package com.tka.controller;

import java.util.List;
import java.util.Scanner;
import com.tka.entity.Product;
import com.tka.service.ProductService;
import com.tka.utility.ProductDB;

public class ProductController {
	
	Scanner scanner = new Scanner(System.in);
	private ProductService productService = new ProductService();

	public List<Product> getAllProducts() {
	
		List<Product> allProducts = productService.getAllProducts();
		
		if(!allProducts.isEmpty()) {
			System.out.println("=================================");
			System.out.println("          Product Details        ");
			System.out.println("=================================\r\n");
			System.out.println(allProducts);
		} else {
			System.out.println("=================================");
			System.out.println("        Product Not Faound!      ");
			System.out.println("=================================");
		}
		
		return allProducts;
	}

	public List<Product> addProducts() {
		
		System.out.println("=================================");
		System.out.println("          Product Details        ");
		System.out.println("=================================\r\n");
		
		System.out.println("Enter Product Id :");
		int id = scanner.nextInt();	
		ProductDB.loading();
		
        Product p1 = new Product();
		p1.setId(id);
		
		boolean findProduct = productService.findProduct(p1);
		while(findProduct) {
			
			System.out.println("Product Is Exists!");
			System.out.println("Enter New Product Id :");
			id = scanner.nextInt();
			
			p1 = new Product();
			
			p1.setId(id);
			
			findProduct = productService.findProduct(p1);
			
		}
		
		System.out.println("---------------------------------");
		
		scanner.nextLine();
		System.out.println("Enter Product Name :");
		String name = scanner.nextLine();	
		
        System.out.println("---------------------------------");
		
		System.out.println("Enter Product Category :");
		String category  = scanner.nextLine();
		
        System.out.println("---------------------------------");
		
		System.out.println("Enter Product Price :");
		int price = scanner.nextInt();	
		
		p1.setName(name);
		p1.setCategory(category);
		p1.setPrice(price);
		
		boolean addProducts = productService.addProducts(p1);
		if(addProducts) {
			System.out.println("=================================");
			System.out.println("    Product Added Successfully   ");
			System.out.println("=================================");
		} else {
			System.out.println("=================================");
			System.out.println("       Somthing went wrong!      ");
			System.out.println("=================================");
		}
		return null;
		
	}

}

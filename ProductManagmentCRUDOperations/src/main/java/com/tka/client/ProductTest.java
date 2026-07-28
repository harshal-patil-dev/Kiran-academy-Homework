package com.tka.client;

import java.util.List;
import java.util.Scanner;
import com.tka.controller.ProductController;
import com.tka.entity.Product;
import com.tka.utility.ProductDB;

public class ProductTest {
	
	int choice = 0;
	Scanner scanner = new Scanner(System.in);
	private ProductController productController = new ProductController();

	public static void main(String[] args) {
		
		ProductTest pt = new ProductTest();
		pt.start();

	}

	private void start() {
		do {
			menu();
		} while(choice < 5);
		
	}

	private void menu() {
		
		System.out.println("=================================");
		System.out.println("    PRODUCT OPERATIONS SYSTEM    ");
		System.out.println("=================================");
		
		System.out.println("\r\n"
				+ "1. Display Products\r\n"
				+ "2. Add Products\r\n"
				+ "3. Update Products\r\n"
				+ "4. Delete Products\r\n"
				+ "5. Exits System\r\n"
				+ "---------------------------------\r\n");
		
		System.out.println("Enter Choice :");
		choice = scanner.nextInt();
		
		while(choice > 5) {
			
			System.out.println("Invalid Choice!");
			System.out.println("---------------------------------");
			System.out.println("Enter Choice :");
			choice = scanner.nextInt();
			
		}
		
		switch(choice) {
		case 1:
			ProductDB.loading();
			productController.getAllProducts();
			break;
		case 2:
			ProductDB.loading();
			productController.addProducts();
		    break;
		case 5:
			ProductDB.loading();
			System.out.println("=================================");
			System.out.println("          SYSTEM Exists....      ");
			System.out.println("=================================");
		    break;
		}
	}

}

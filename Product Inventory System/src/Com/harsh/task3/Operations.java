package Com.harsh.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations {

	int choice;

	Scanner scanner = new Scanner(System.in);

	List<Product> inventory = new ArrayList<>();

	public void start() {

		do {
			this.op();
		} while (choice < 7);

		if (choice != 7) {
			this.op();
		}

	}

	public void op() {

		System.out.println("-----------------------------------");
		System.out.println("     Product Inventory System      ");
		System.out.println("-----------------------------------\n"
		                   + "\n" 
				           +"1 Add Product\r\n" 
		                   + "2 Display Products\r\n"
						   + "3 Search Product\r\n"
		                   + "4 Update Quantity\r\n" 
						   + "5 Most Expensive Product\r\n"
						   + "6 Inventory Value\r\n" 
						   + "7 Exit\r\n" 
						   + "\n" 
						   + "-----------------------------------");

		System.out.println("Enter Choice: ");
		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			this.addProduct();
			break;
		case 2:
			this.display();
			break;
		case 3:
			this.search();
			break;
		case 4:
			this.update();
			break;
		case 5:
			this.expensive();
			break;
		case 6:
			this.inventory();
			break;
		case 7:
			this.exit();
			break;
		default:
			System.out.println("Invalid operation");
		}

	}

	private void exit() {
		System.out.println("-----------------------------------");
		System.out.println("             System Exit...");
		System.out.println("-----------------------------------");
	}

	private void inventory() {

		int i = 0;
		long totalValue = 0;
		for (Product obj1 : inventory) {

			long productValue = obj1.getPrice() * obj1.getQuantity();
			totalValue += productValue;

		}

		System.out.println("-----------------------------------");
		System.out.println("Total Inventory Value = " + totalValue);
		System.out.println("-----------------------------------");
	}

	private void expensive() {

		if (!inventory.isEmpty()) {

			int i = 0;
			int dataSize = inventory.size();
			long expensivePrice = inventory.get(i).getPrice();

			while (i < dataSize) {
				long expensivePriceNext = inventory.get(i).getPrice();

				if (expensivePrice < expensivePriceNext) {

					expensivePrice = expensivePriceNext;

				}

				i++;
			}

			for (Product obj1 : inventory) {

				if (obj1.getPrice() == expensivePrice) {

					System.out.println("\n" + "Most Expensive Product");
					System.out.println(obj1);

				}

			}

		} else {

			System.out.println("-----------------------------------");
			System.out.println("No products available...");
			System.out.println("-----------------------------------");

		}
	}

	private void update() {

		boolean found = false;

		System.out.println("-----------------------------------");
		System.out.println("      Update Product Quantity");
		System.out.println("-----------------------------------");

		System.out.println("Enter Product Id :");
		int search = scanner.nextInt();

		for (Product obj1 : inventory) {

			if (obj1.getId() == search) {

				found = true;
				System.out.println("\n" + "Product Found");
				System.out.println(obj1);

				System.out.println("Enter New Quantity :");
				int newQuantity = scanner.nextInt();

				obj1.setQuantity(newQuantity);

				System.out.println("-----------------------------------");
				System.out.println("Product Quantity Updated Successfully...");
				System.out.println("-----------------------------------");
				break;

			}
		}

		if (!found) {
			System.out.println("-----------------------------------");
			System.out.println("Product is not found");
			System.out.println("-----------------------------------");
		}

	}

	private void search() {

		boolean found = false;

		System.out.println("-----------------------------------");
		System.out.println("Search Product By Id");
		System.out.println("-----------------------------------");

		System.out.println("Enter Product Id :");
		int search = scanner.nextInt();

		for (Product obj1 : inventory) {

			if (obj1.getId() == search) {

				found = true;
				System.out.println("\n" + "Searched Product");
				System.out.println(obj1);
				break;

			}
		}

		if (!found) {
			System.out.println("-----------------------------------");
			System.out.println("Product is not available");
			System.out.println("-----------------------------------");
		}

	}

	private void display() {

		if (inventory.isEmpty()) {

			System.out.println("-----------------------------------");
			System.out.println("No Products Available");
			System.out.println("-----------------------------------");

		} else {
			System.out.println("-----------------------------------");
			System.out.println("Display Products");
			System.out.println(inventory);
		}
	}

	private void addProduct() {

		System.out.println("-----------------------------------");
		System.out.println("Enter Product Details");
		System.out.println("-----------------------------------");

		System.out.println("Enter Product ID :");
		int id = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter Product Name :");
		String name = scanner.nextLine();

		System.out.println("Enter Product Price :");
		int price = scanner.nextInt();

		System.out.println("Enter Product Quantity :");
		int quantity = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter Product Category :");
		String category = scanner.nextLine();

		inventory.add(new Product(id, name, price, quantity, category));

		System.out.println("-----------------------------------");
		System.out.println("Product Added Successfully...");
		System.out.println("-----------------------------------");
	}

}

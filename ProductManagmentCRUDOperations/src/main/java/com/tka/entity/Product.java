package com.tka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product {
	
	@Id
	private int id;
	@Column(name = "pname")
	private String name;
	private String category;
	private int price;
	
	public Product() {
		super();
	}

	public Product(String name, String category, int price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Product(int id, String name, String category, int price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
	    return "\n" +
	           "ID       : " + id + "\n" +
	           "Name     : " + name + "\n" +
	           "Category : " + category + "\n" +
	           "Price    : ₹" + price + "\n" +
	           "---------------------------------";
	}
	

}

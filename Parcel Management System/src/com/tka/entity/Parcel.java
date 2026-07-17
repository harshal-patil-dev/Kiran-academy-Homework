package com.tka.entity;

public class Parcel {
	
	private int pid;
	private String senderName;
	private String receiverName;
	private String city;
	private double weight;
	private double price;
	
	public Parcel() {
		super();
	}

	public Parcel(int pid, String senderName, String receiverName, String city, double weight, double price) {
		super();
		this.pid = pid;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.city = city;
		this.weight = weight;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "parcel [pid=" + pid + ", senderName=" + senderName + ", receiverName=" + receiverName + ", city=" + city
				+ ", weight=" + weight + ", price=" + price + "]";
	}
	
	

}

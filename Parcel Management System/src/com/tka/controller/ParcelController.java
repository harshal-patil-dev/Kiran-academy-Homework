package com.tka.controller;

import com.tka.service.ParcelService;

public class ParcelController {
	
	public static void main(String[] args) {
		
		ParcelService ps = new ParcelService();
		ps.getAllParcel();
		
	}
	
}

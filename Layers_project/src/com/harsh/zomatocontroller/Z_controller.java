package com.harsh.zomatocontroller;

import java.util.ArrayList;
import com.harsh.entity.Z_user;
import com.harsh.zomatoservice.Z_service;

public class Z_controller {
	
	public static void main(String[] args) {
		
		Z_service obj = new Z_service();
		ArrayList<Z_user> parcel = obj.getParcel();
		System.out.println(parcel);
		
	}

}

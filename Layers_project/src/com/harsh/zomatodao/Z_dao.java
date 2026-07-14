package com.harsh.zomatodao;

import java.util.ArrayList;

import com.harsh.entity.Z_user;

public class Z_dao {
	
	public ArrayList<Z_user> getParcel() {
		
		ArrayList<Z_user> parcel = new ArrayList<>();
		parcel.add( new Z_user(1, "Harsh", "harsh@gmail.com"));
		parcel.add( new Z_user(2, "Vivek", "vivek@gmail.com"));
		parcel.add( new Z_user(3, "Rohit", "rohit@gmail.com"));
		parcel.add( new Z_user(4, "Aasha", "aasha@gmail.com"));
		parcel.add( new Z_user(5, "priya", "priya@gmail.com"));
		return parcel;

	}
	
}

package com.harsh.zomatoservice;

import java.util.ArrayList;

import com.harsh.entity.Z_user;
import com.harsh.zomatodao.Z_dao;

public class Z_service {
		
		public ArrayList<Z_user> getParcel() {
			
			 Z_dao obj = new Z_dao();
			 ArrayList<Z_user> parcel = obj.getParcel();
		     return parcel;
		
	}

}

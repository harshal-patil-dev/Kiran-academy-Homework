package com.tka.service;

import com.tka.dao.ParcelDao;

public class ParcelService {
	
	ParcelDao pd = new ParcelDao();
	public void getAllParcel() {
		pd.start();
	}

}

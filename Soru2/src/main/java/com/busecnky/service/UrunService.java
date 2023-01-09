package com.busecnky.service;

import com.busecnky.entity.Urun;
import com.busecnky.repository.UrunDao;

public class UrunService {

	
private UrunDao urunDao;
	
	public UrunService() {
		urunDao = new UrunDao();
	}
	
	
	public void save(Urun urun) {
		urunDao.save(urun);
	}
	
}

package com.busecnky.service;

import com.busecnky.entity.SiparisKalemi;
import com.busecnky.repository.SiparisKalemiDao;

public class SiparisKalemiService {

private SiparisKalemiDao siparisKalemiDao;
	
	public SiparisKalemiService() {
		siparisKalemiDao = new SiparisKalemiDao();
	}
	
	public void save(SiparisKalemi siparisKalemi) {
		siparisKalemiDao.save(siparisKalemi);
	}
}

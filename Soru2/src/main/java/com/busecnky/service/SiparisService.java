package com.busecnky.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.busecnky.entity.Musteri;
import com.busecnky.entity.Siparis;
import com.busecnky.entity.SiparisKalemi;
import com.busecnky.repository.MusteriDao;
import com.busecnky.repository.SiparisDao;

public class SiparisService {

	private SiparisDao siparisDao;
	private MusteriDao musteriDao;

	public SiparisService() {
		siparisDao = new SiparisDao();
		musteriDao = new MusteriDao();
	}

	public void save(Siparis siparis) {
		siparisDao.save(siparis);
	}

	public void siparisToplam() {
		siparisDao.siparisToplam();
	}

	public void siparisGrupla() {
		siparisDao.siparisGrupla();
		
	}

	public void musteriBilgisi() {
		siparisDao.musteriBilgisi();
		
	}

	

}

package com.busecnky.service;

import java.util.List;

import com.busecnky.entity.Musteri;
import com.busecnky.entity.Siparis;
import com.busecnky.entity.SiparisKalemi;
import com.busecnky.repository.MusteriDao;

public class MusteriService {

private MusteriDao musteriDao;
	
	public MusteriService() {
		musteriDao = new MusteriDao();
	}
	
	public void save(Musteri musteri) {
		musteriDao.save(musteri);
	}
	
	
	public void musteriUrunBilgileri() {
		List<Musteri> musteriList = musteriDao.findAll();

		for (Musteri m : musteriList) {
			System.out.println("Müşteri ID: " + m.getId() + " Müşteri Ad: " + m.getIsim() 
			 						+ " Müşteri Soyad: " + m.getSoyisim());
			int harcamaToplam = 0;
			for (Siparis s : m.getSiparis()) {
				System.out.println("\tSipariş ID: " + s.getId());
			
				for (SiparisKalemi skalemi : s.getSiparisKalemi()) {
					System.out.println("\t Ürün: " + skalemi.getUrun().getUrunAdi() + " Fiyat: " + skalemi.getUrun().getUrunFiyati() 
					+ " Ürün: " + skalemi.getAdet());
					harcamaToplam += skalemi.getUrun().getUrunFiyati()*skalemi.getAdet();
			}
			
		}System.out.println("Toplam harcama: " + harcamaToplam + "\n");
		}
	}


	
	
	
	
	
}

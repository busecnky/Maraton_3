package com.busecnky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Urun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String urunAdi;
	
	private int urunFiyati;

	public Urun(String urunAdi, int urunFiyati) {
		super();
		this.urunAdi = urunAdi;
		this.urunFiyati = urunFiyati;
	}
	
	
	public Urun() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUrunAdi() {
		return urunAdi;
	}


	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}


	public int getUrunFiyati() {
		return urunFiyati;
	}


	public void setUrunFiyati(int urunFiyati) {
		this.urunFiyati = urunFiyati;
	}


	@Override
	public String toString() {
		return "Urun [id=" + id + ", urunAdi=" + urunAdi + ", urunFiyati=" + urunFiyati + "]";
	}
	
	
	
}

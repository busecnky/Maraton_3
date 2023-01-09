package com.busecnky.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Musteri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String isim;
	
	private String soyisim;
	
	@OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Siparis> siparis;

	
	
	public Musteri(String isim, String soyisim) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
	}

	public Musteri() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public List<Siparis> getSiparis() {
		return siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}


	
	

}

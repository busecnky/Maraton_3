package com.busecnky.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Siparis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SiparisKalemi> siparisKalemi;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Musteri musteri;

	public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemi) {
		super();
		this.siparisKalemi = siparisKalemi;
		this.musteri = musteri;
	}
	
	public Siparis() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SiparisKalemi> getSiparisKalemi() {
		return siparisKalemi;
	}

	public void setSiparisKalemi(List<SiparisKalemi> siparisKalemleri) {
		this.siparisKalemi = siparisKalemleri;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}
	
	
}

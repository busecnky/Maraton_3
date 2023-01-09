package com.busecnky.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SiparisKalemi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int adet;
	
	@OneToOne
	private Urun urun;




	public SiparisKalemi(Urun urun, int adet) {
		super();
		this.adet = adet;
		this.urun = urun;
	}
	
	
	public SiparisKalemi() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAdet() {
		return adet;
	}


	public void setAdet(int adet) {
		this.adet = adet;
	}


	public Urun getUrun() {
		return urun;
	}


	public void setUrun(Urun urun) {
		this.urun = urun;
	}


	
	
}

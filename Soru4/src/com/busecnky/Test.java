package com.busecnky;

public class Test {

	
	public static void main(String[] args) {
		OtomobilFactory otomobilFactory = Singelton.getOtomobilFactory();
		
		otomobilFactory.arabaUret(EOtomobil.JEEP).arabayiSur();
		otomobilFactory.arabaUret(EOtomobil.SEDAN).arabayiSur();
		otomobilFactory.arabaUret(EOtomobil.HATCHBACK).arabayiSur();
		
		otomobilFactory.arabaUret(EOtomobil.HATCHBACK).benzinDoldur();
		otomobilFactory.arabaUret(EOtomobil.SEDAN).benzinDoldur();
		otomobilFactory.arabaUret(EOtomobil.JEEP).benzinDoldur();
	}
}

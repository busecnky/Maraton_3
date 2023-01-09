package com.busecnky;

public class OtomobilFactory {

	public ICars arabaUret(EOtomobil araba) {

		switch (araba) {
		case JEEP:
			return new JeepOtomobil();
		case HATCHBACK:
			return new HatchbackOtomobil();
		case SEDAN:
			return new SedanOtomobil();
		

		default:
			break;
		}
		return null;
	}
}

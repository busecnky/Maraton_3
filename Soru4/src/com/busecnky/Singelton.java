package com.busecnky;

public class Singelton {
	
	private static OtomobilFactory otomobilFactory;
	
	public static OtomobilFactory getOtomobilFactory() {
		if(otomobilFactory== null) {
			otomobilFactory = new OtomobilFactory();
			
		}
		return otomobilFactory;
	}
	
}

package com.busecnky;

public class MessageSubscriberHaberlesmeci implements ObserverSonar,ObserverYangin {


	@Override
	public void update(MessageSonar m) {
		System.out.println("Haberleşmeci için Sonar Uyarısı : "+m.getMessageContent());
		
		
	}

	@Override
	public void update(MessageYanginSensor m) {
		System.out.println("Haberleşmeci için Yangın Uyarısı  "+m.getMessageContent());
		
	}


}

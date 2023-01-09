package com.busecnky;

public class MessageSubscriberKaptan implements ObserverSonar,ObserverOksijen,ObserverYangin {

	@Override
	public void update(MessageSonar m) {
		System.out.println("Kaptan için Sonar Uyarısı : " + m.getMessageContent());
		
	}
	@Override
	public void update(MessageOksijenSensor m) {
		System.out.println("Kaptan için Oksijen Uyarısı  : "+ m.getMessageContent());
		
	}
	
	@Override
	public void update(MessageYanginSensor m) {
		System.out.println("Kaptan için Yangın Uyarısı : "+ m.getMessageContent());
		
	}
}

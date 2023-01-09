package com.busecnky;

public class Main {

	
	public static void main(String[] args) {
		
		
		MessageSubscriberKaptan s1 = new MessageSubscriberKaptan();
		MessageSubscriberHaberlesmeci s2 = new MessageSubscriberHaberlesmeci();
		MessageSubscriberTorpidoMerkezi s3 = new MessageSubscriberTorpidoMerkezi();
		
		
		
		MessagePublisherOksijen p = new MessagePublisherOksijen();
		p.attach(s1);
		
		p.notifyUpdate(new MessageOksijenSensor("Düşük oksijen seviyesi!", 20, "Silah Binası"));
		
		System.out.println("\n ********* \n");
		
		MessagePublisherYangin p2 = new MessagePublisherYangin();
		p2.attach(s1);
		p2.attach(s2);
		
		p2.notifyUpdate(new MessageYanginSensor("Yangın alarmı aktif", 45, 70));
		
		
		System.out.println("\n ********* \n");
		
		
		MessagePublisherSonar p3 = new MessagePublisherSonar();
		p3.attach(s1);
		p3.attach(s2);
		p3.attach(s3);
		
		p3.notifyUpdate(new MessageSonar("Bilinmeyen denizaltı yaklaşıyor", "214 TN", 100, 60, 45));
	
	}

}

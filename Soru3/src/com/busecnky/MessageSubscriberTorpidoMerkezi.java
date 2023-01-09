package com.busecnky;

public class MessageSubscriberTorpidoMerkezi implements ObserverSonar {

	@Override
	public void update(MessageSonar m) {
		System.out.println("Torpido Merkezi için Sonar Uyarısı : "+m.getMessageContent());
		
		
	}


}

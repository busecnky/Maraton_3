package com.busecnky;

public class MessageOksijenSensor {

	final String messageContent;
	final int yuzdeOksijenSeviyesi;
	final String oksijenLokasyonu;
	
	
	public MessageOksijenSensor(String messageContent, int yuzdeOksijenSeviyesi, String oksijenLokasyonu) {
		super();
		this.messageContent = messageContent;
		this.yuzdeOksijenSeviyesi = yuzdeOksijenSeviyesi;
		this.oksijenLokasyonu = oksijenLokasyonu;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public int getYuzdeOksijenSeviyesi() {
		return yuzdeOksijenSeviyesi;
	}


	public String getOksijenLokasyonu() {
		return oksijenLokasyonu;
	}


	@Override
	public String toString() {
		return "MessageOksijenSensor [messageContent=" + messageContent + ", yuzdeOksijenSeviyesi="
				+ yuzdeOksijenSeviyesi + ", oksijenLokasyonu=" + oksijenLokasyonu + "]";
	}
	

	
}

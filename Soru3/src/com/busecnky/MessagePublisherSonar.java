package com.busecnky;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisherSonar implements SubjectSonar {

	
		
		private List<ObserverSonar> observers = new ArrayList<>();
		
		@Override
		public void attach(ObserverSonar o) {
			if(!observers.contains(o)) {
				observers.add(o);
			}
			
		}
	
		@Override
		public void detach(ObserverSonar o) {
			if(observers.contains(o)) {
				observers.remove(o);
			}
			
		}
	
		@Override
		public void notifyUpdate(MessageSonar m) {
		for (ObserverSonar o : observers) {
			o.update(m);
		}
			
	}


}

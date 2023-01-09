package com.busecnky;

public interface SubjectYangin {

	void attach(ObserverYangin o);

    void detach(ObserverYangin o);

    void notifyUpdate(MessageYanginSensor m);
	
}

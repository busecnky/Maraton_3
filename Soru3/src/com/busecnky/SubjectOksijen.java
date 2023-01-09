package com.busecnky;

public interface SubjectOksijen {

	void attach(ObserverOksijen o);

    void detach(ObserverOksijen o);

    void notifyUpdate(MessageOksijenSensor m);
	
}

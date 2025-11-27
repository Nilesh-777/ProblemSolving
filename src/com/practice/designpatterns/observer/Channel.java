package com.practice.designpatterns.observer;

public interface Channel {
	void subscribe(Subscriber s);
	void unsubscribe(Subscriber s);
	void notifySubscribers(String s);
}

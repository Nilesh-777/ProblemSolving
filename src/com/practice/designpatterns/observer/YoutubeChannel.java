package com.practice.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel {
	
	private String name;

	public YoutubeChannel(String name) {
		this.name = name;
	}

	private final List<Subscriber> subscribers = new ArrayList<>();

	@Override
	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}

	@Override
	public void unsubscribe(Subscriber s) {
		subscribers.remove(s);
	}

	@Override
	public void notifySubscribers(String s) {
		String enrichedMsg = this.name + " " + s;
		subscribers.forEach(subscriber -> subscriber.notification(enrichedMsg));
	}

}

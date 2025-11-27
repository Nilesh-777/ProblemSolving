package com.practice.designpatterns.observer;

public class StatefulSubscriber implements Subscriber {
	
	private String name;
	
	public StatefulSubscriber(String name) {
		this.name = name;
	}
	
	@Override
	public void notification(String s) {
		System.out.println("Hi %s, %s".formatted(name, s));
	}

}

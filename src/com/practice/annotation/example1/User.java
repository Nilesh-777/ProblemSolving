package com.practice.annotation.example1;

public class User {

	private static final NotNullProcessor notNullProcessor = new NotNullProcessor();

	
	@NotNull
	private String name;

	public User(String name) {
		this.name = name;
		notNullProcessor.process(this);
	}

}

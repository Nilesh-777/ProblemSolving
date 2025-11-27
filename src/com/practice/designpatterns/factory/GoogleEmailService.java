package com.practice.designpatterns.factory;

public class GoogleEmailService implements EmailService {

	@Override
	public void send() {
		System.out.println("Sending email via google.");
	}

}

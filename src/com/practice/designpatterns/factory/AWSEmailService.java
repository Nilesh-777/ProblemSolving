package com.practice.designpatterns.factory;

public class AWSEmailService implements EmailService {

	@Override
	public void send() {
		System.out.println("Sending email via AWS.");
	}

}

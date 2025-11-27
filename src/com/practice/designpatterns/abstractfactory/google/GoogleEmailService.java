package com.practice.designpatterns.abstractfactory.google;

import com.practice.designpatterns.abstractfactory.EmailService;

public class GoogleEmailService implements EmailService {

	@Override
	public void send() {
		System.out.println("Sending email via google.");
	}

}

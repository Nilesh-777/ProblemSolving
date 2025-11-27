package com.practice.designpatterns.abstractfactory.aws;

import com.practice.designpatterns.abstractfactory.EmailService;

public class AWSEmailService implements EmailService {

	@Override
	public void send() {
		System.out.println("Sending email via AWS.");
	}

}

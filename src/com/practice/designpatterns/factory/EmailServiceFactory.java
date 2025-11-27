package com.practice.designpatterns.factory;

public class EmailServiceFactory {

	public EmailService getEmailServiceBean(final String mode) {
		if ("aws".equals(mode)) {
			return new AWSEmailService();
		} else if ("google".equals(mode)) {
			return new GoogleEmailService();
		} else {
			throw new IllegalArgumentException();
		}
	}

}

package com.practice.designpatterns.factory;

public class MainLogic {
	
	public static void main(String[] args) {
		EmailServiceFactory factory = new EmailServiceFactory();
		factory.getEmailServiceBean("aws").send();
		factory.getEmailServiceBean("google").send();
		factory.getEmailServiceBean("sendgrid1").send();
	}

}

package com.practice.designpatterns.abstractfactory;

public class Application {
	
	private EmailService emailService;
	private StorageService storageService;
	
	public Application(CloudServiceFactory cloudServiceFactory) {
		this.emailService = cloudServiceFactory.constructEmailService();
		this.storageService = cloudServiceFactory.constructStorageService();
	}
	
	public void run() {
		this.emailService.send();
		this.storageService.store();
	}

}

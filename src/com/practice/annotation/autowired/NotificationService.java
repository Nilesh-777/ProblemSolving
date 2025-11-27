package com.practice.annotation.autowired;

public class NotificationService {
	
	@MyAutowire
	private EmailService emailService;
	
	@MyAutowire
	private SMSService smsService;
	
	public void notifyUser() {
		this.emailService.sendEmail();
		this.smsService.send();
	}
	
}

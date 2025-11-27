package com.practice.designpatterns.abstractfactory.google;

import com.practice.designpatterns.abstractfactory.CloudServiceFactory;
import com.practice.designpatterns.abstractfactory.EmailService;
import com.practice.designpatterns.abstractfactory.StorageService;

public class GoogleCloudServiceFactory implements CloudServiceFactory {

	@Override
	public EmailService constructEmailService() {
		// TODO Auto-generated method stub
		return new GoogleEmailService();
	}

	@Override
	public StorageService constructStorageService() {
		// TODO Auto-generated method stub
		return new GoogleStorageService();
	}

}

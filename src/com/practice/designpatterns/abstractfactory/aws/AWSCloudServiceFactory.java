package com.practice.designpatterns.abstractfactory.aws;

import com.practice.designpatterns.abstractfactory.CloudServiceFactory;
import com.practice.designpatterns.abstractfactory.EmailService;
import com.practice.designpatterns.abstractfactory.StorageService;

public class AWSCloudServiceFactory implements CloudServiceFactory {

	@Override
	public EmailService constructEmailService() {
		// TODO Auto-generated method stub
		return new AWSEmailService();
	}

	@Override
	public StorageService constructStorageService() {
		// TODO Auto-generated method stub
		return new AWSStorageService();
	}

}

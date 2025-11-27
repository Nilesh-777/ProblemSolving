package com.practice.designpatterns.abstractfactory;

import com.practice.designpatterns.abstractfactory.aws.AWSEmailService;
import com.practice.designpatterns.abstractfactory.google.GoogleEmailService;

public interface CloudServiceFactory {

	EmailService constructEmailService();

	StorageService constructStorageService();

}

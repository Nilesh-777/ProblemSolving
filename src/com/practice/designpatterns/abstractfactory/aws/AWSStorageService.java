package com.practice.designpatterns.abstractfactory.aws;

import com.practice.designpatterns.abstractfactory.EmailService;
import com.practice.designpatterns.abstractfactory.StorageService;

public class AWSStorageService implements StorageService {

	@Override
	public void store() {
		System.out.println("Storing via AWS.");
	}

}

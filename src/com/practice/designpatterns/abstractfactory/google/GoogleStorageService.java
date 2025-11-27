package com.practice.designpatterns.abstractfactory.google;

import com.practice.designpatterns.abstractfactory.EmailService;
import com.practice.designpatterns.abstractfactory.StorageService;

public class GoogleStorageService implements StorageService {

	@Override
	public void store() {
		System.out.println("Storing via google.");
	}

}

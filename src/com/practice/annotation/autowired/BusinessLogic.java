package com.practice.annotation.autowired;

import java.lang.reflect.InvocationTargetException;

public class BusinessLogic {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
		MyAutowiredAnnotationProcessor maap = new MyAutowiredAnnotationProcessor();

		NotificationService nontificationService = new NotificationService();
		maap.process(nontificationService);
			
		nontificationService.notifyUser();
	}
}

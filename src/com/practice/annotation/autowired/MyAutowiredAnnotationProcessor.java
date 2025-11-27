package com.practice.annotation.autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyAutowiredAnnotationProcessor {

	public void process(final Object object) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<? extends Object> class1 = object.getClass();

		for (final Field field : class1.getDeclaredFields()) {
			field.setAccessible(true);

			if (field.isAnnotationPresent(MyAutowire.class)) {
					System.out.println("Injecting EmailService instance...");
					field.set(object, field.getType().getDeclaredConstructor().newInstance());
				}
		}
	}

}

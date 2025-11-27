package com.practice.annotation.example1;

import java.lang.reflect.Field;

import com.practice.java11.NonNull;

public class NotNullProcessor {

	public void process(final Object object) {
		Class<? extends Object> classVar = object.getClass();

		for (final Field field : classVar.getDeclaredFields()) {
			boolean annotationPresent = field.isAnnotationPresent(NotNull.class);
//			System.out.println("Name: %s, annotaionPresent: %s".formatted(field.getName(), annotationPresent));
			if (annotationPresent) {
				field.setAccessible(true);
				try {
					Object value = field.get(object);
					if (value == null) {
						throw new RuntimeException();
					}

				} catch (final Exception e) {
					NotNull nonNull = field.getAnnotation(NotNull.class);
					throw new RuntimeException(nonNull.message().formatted(field.getName()));
				}

			}
		}

	}

}

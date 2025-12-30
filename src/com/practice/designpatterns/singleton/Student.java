package com.practice.designpatterns.singleton;

/**
 * Here we see eager initialization. It is thread safe by default. Thus we don't
 * need synchronized keyword for getInstance method.
 */
public class Student {

	private static final Student s = new Student();

	private Student() {
	}

	public static Student getInstance() {
		return s;
	}

}

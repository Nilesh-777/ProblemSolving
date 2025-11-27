package com.practice.designpatterns.singleton;

public class Student {

	private static final Student s = new Student();
	
	private Student() {}
	
	public static synchronized Student getInstance() {
		return s;
	}

}

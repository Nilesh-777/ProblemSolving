package com.practice.designpatterns.singleton;

/**
 * Implement threadsafe lazy iniitialization using lock.
 */
public class Student2 {

	private static volatile Student2 s;

	private Student2() {
	}

	public static Student2 getInstance() {
		synchronized (Student2.class) {
			if (s == null) {
				s = new Student2();
			}
			return s;

		}
	}

}

package com.practice.designpatterns.singleton;

/**
 * Implement threadsafe lazy iniitialization using lock.
 * JVM: 
 * - A class is loaded & initialized only when it is 1st actively used.
 * - When getInstance is called then holder is loaded during which Student3 object is created
 * - JVM ensures class initialization is synchronized, thus Student3 creation happens only once.
 */
public class Student3 {

	private static class Holder {
		private static final Student3 INSTANCE = new Student3();
	}

	private Student3() {

	}

	public static Student3 getInstance() {
		return Holder.INSTANCE;
	}

}

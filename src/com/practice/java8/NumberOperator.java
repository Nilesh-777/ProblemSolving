package com.practice.java8;

@FunctionalInterface
public interface NumberOperator {

	int apply(int a, int b);

	default void defaultPrint() {
		System.out.println("Default print Method");
	}

	static void staticPrint() {
		System.out.println("Static print Method");
	}

}

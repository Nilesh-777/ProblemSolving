package com.practice.java8;

@FunctionalInterface
interface Addition {
	int add(int a, int b);
}

public class Adder {
	public static void main(String[] args) {

		// Normal
		Addition addition = new Addition() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};

		System.out.println(addition.add(5, 7));

		// Lambda
		Addition addition1 = (a, b) -> {
			System.out.println("Doing addition");
			return a + b;
		};
		System.out.print(addition1.add(8, 5));

	}
}

package com.practice.exception;

// What would be output?
public class StatementExecutionSequence1 {

	public static void main(String[] args) {
		method1();
		method2();
	}

	private static void method2() {
		System.out.println("method2");
	}

	private static void method1() {
		try {
			System.out.println("try");
			throw new RuntimeException("try");
		} catch (final Exception e) {
			System.out.println("Catch");
			throw new RuntimeException("catch");
		} finally {
			System.out.println("finally");
			throw new RuntimeException("finally");
		}
	}

}

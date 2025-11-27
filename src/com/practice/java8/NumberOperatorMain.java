package com.practice.java8;

public class NumberOperatorMain {

	public static void main(String[] args) {
		NumberOperator addition = (a, b) -> a + b;
		NumberOperator multiplication = (a, b) -> a * b;
		
		System.out.println(addition.apply(3, 4));
		System.out.println(multiplication.apply(3, 4));
		addition.defaultPrint();
		NumberOperator.staticPrint();
	}

}

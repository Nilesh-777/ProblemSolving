package com.practice.java8;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
}

public class MainClass {
	public static void main(String[] args) {
		// normal way
		Calculator calculator = new Summer();
		int sum = calculator.add(5, 7);
		out.println(sum);

		// Anonymous usage
		Calculator calculator2 = new Calculator() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		int sum2 = calculator.add(5, 7);
		out.println(sum2);

		// Lambda functions
		Calculator calculator3 = (x, y) -> x + y;
		int sum3 = calculator.add(5, 7);
		out.println(sum3);

		// ?
		List<? extends Number> list = new ArrayList<>();
	

	}
}

package com.practice.java8;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SqrtOf10Prime {
	public static void main(String[] args) {
		// loop till 10 prime numbers
		// for each prime number adding to list
		int pointer = 1;
		int num = 2;

		final List<Double> list = new ArrayList<>();
		final DecimalFormat format = new DecimalFormat("0.00");

		while (pointer <= 10) {
			if (isPrime(num)) {
				list.add(Double.valueOf(format.format(Math.sqrt(num))));
				pointer++;
			}
			num++;
		}

		list.forEach(n -> System.out.println(n));

		// Java8
		System.out.println("Java 8 Code");
		Stream.iterate(2, i -> i + 1).filter(SqrtOf10Prime::isPrime).map(Math::sqrt).map(format::format)
				.map(Double::valueOf).limit(10).forEach(s -> System.out.println(s));

	}

	private static boolean isPrime(int num) {
		return IntStream.range(2, num - 1).noneMatch(n -> num % n == 0);
	}

}

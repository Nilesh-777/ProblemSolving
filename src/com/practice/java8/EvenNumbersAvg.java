package com.practice.java8;

import java.util.List;
import java.util.OptionalDouble;

public class EvenNumbersAvg {
	public static void main(String[] args) {
		double avg = List.of(1, 2, 3, 4, 5, 6)
			.stream()
			.filter(num -> num%2 == 0)
			.mapToInt(Integer::valueOf)
			.average()
			.orElse(0d);
		
		System.out.println(avg);
	}
}

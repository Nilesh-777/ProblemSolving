package com.practice.java8;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		String s = null;

		Optional.ofNullable(s).ifPresent(str -> System.out.println(str.length()));

		// more readable
		Optional.ofNullable(s).map(String::length).ifPresent(System.out::println);

		int len = Optional.ofNullable(s).map(String::length).orElseThrow();

	}
}

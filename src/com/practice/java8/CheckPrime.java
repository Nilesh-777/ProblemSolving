package com.practice.java8;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CheckPrime {
	public static void main(String[] args) {
		do {
			System.out.println("put a number");
			final Scanner input = new Scanner(System.in);
			final int num = input.nextInt();

			if (num == 1) {
				System.out.println("1 is neither prime nor composite");
				continue;
			}

			final boolean isPrime = IntStream.range(2, num - 1).noneMatch(n -> num % n == 0);

			final String result = isPrime ? num + " is prime" : num + " is not prime";

			System.out.println(result);
		} while (true);

	}

}

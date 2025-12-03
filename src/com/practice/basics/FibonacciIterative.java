package com.practice.basics;

// Input: 8
// Answer: 0, 1, 1, 2, 3, 5, 8, 13
public class FibonacciIterative {

	public static void main(String[] args) {
		fibonacci(8);
	}

	private static void fibonacci(final int num) {
		if (num <= 0) {
			System.out.println("Invalid input");
			return;
		}

		if (num == 1) {
			System.out.println("0");
			return;
		}

		if (num == 2) {
			System.out.println("0 1");
			return;
		}

		int prev = 0;
		int next = 1;

		String s = "0 1 ";
		for (int i = 3; i <= num; i++) {
			int res = prev + next;
			s = s + res + " ";
			
			prev = next;
			next = res;
		}
		
		System.out.println(s.trim());
	}

}

package com.practice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Input: 8
// Answer: 0, 1, 1, 2, 3, 5, 8, 13
public class FibonacciRecursive {

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

		List<Integer> al = new ArrayList<Integer>();
		al.add(0);
		al.add(1);
		fibonacci(al, num);

		String res = al.stream().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(res);
	}

	private static void fibonacci(final List<Integer> list, final int num) {
		if (list.size() == num) {
			return;
		}

		list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
		fibonacci(list, num);
	}

}

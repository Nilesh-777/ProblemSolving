package com.practice.numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

// Input: 1, 2, 3, 4, 5  Output: 4
// Input: 2, 2, 2        Output: None
// Input: 2, 2, 3, 3     Output: 2
public class SecondLargestNumbers {

	public static void main(String[] args) {
		{
			String s = secondLargestNumber3(new int[] { 1, 2, 3, 4, 5 });
			System.out.println("Second Largest Number: " + s);
		}

		{
			String s = secondLargestNumber3(new int[] { 2, 2, 2 });
			System.out.println("Second Largest Number: " + s);
		}

		{
			String s = secondLargestNumber3(new int[] { 2, 2, 3, 3 });
			System.out.println("Second Largest Number: " + s);
		}
	}

	private static String secondLargestNumber(int[] arr) {
		Integer max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);

		Integer secondMax = Arrays.stream(arr).filter(num -> num < max).max().orElse(Integer.MIN_VALUE);

		return Optional.ofNullable(secondMax).filter(num -> num != Integer.MIN_VALUE).map(String::valueOf)
				.orElse("None");
	}

	private static String secondLargestNumber2(int[] arr) {
		Integer secondMax = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.orElse(null);
		return Optional.ofNullable(secondMax).map(String::valueOf).orElse("None");
	}

	private static String secondLargestNumber3(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num == max) {
				continue;
			} else if (num > max) {
				secondMax = max;
				max = num;
			} else if (num > secondMax) {
				secondMax = num;
			}
		}

		return isValidSecondMax(max, secondMax) ? String.valueOf(secondMax) : "None";
	}

	private static boolean isValidSecondMax(int max, int secondMax) {
		return secondMax != Integer.MIN_VALUE && secondMax != max;
	}
}

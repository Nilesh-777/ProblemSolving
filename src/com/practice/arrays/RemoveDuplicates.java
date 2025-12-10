package com.practice.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 2, 3, 3, 3 };

		Arrays.stream(arr)
				.distinct()
				.forEach(System.out::print);
	}

}

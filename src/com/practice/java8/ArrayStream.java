package com.practice.java8;

import java.util.Arrays;

public class ArrayStream {
	
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4};
		Arrays.stream(arr)
			.forEach(System.out::println);
		
		String s = "my name is nilesh";
		Arrays.stream(s.split(" "))
		.forEach(System.out::println);
	}

}

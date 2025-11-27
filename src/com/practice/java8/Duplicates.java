package com.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Duplicates {
	public static void main(String[] args) {
		// grouping by
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 5, 6);
		Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(i -> i * i));
		System.out.println(map);

		// multiply
		BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
		System.out.println(biFunction.apply(10, 15));

		// limit
		List<Integer> list2 = list.stream().skip(2).limit(3).toList();
		System.out.println(list2);

		String str = "Welcome to pune, pune is city";
		String str2 = str.replaceAll(",", "");
		// list of words
		// map -> word & count
		// print
		Map<String, List<String>> map2 = Arrays.stream(str2.split(" ")).collect(Collectors.groupingBy(i -> i));
		System.out.println(map2);
	}

}

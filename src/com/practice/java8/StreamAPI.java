package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {
		// list of 10 numbers
		// get even numbers & print them
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.stream().filter(num -> num % 2 == 0).collect(Collectors.toMap(num -> num, num -> num * num))
				.forEach((key, value) -> System.out.println(key + ":" + value));

		List<Integer> list2 = Arrays.asList(11, 12);

		List<List<Integer>> list3 = new ArrayList<>();
		list3.add(list);
		list3.add(list2);

		int sum = list3.stream().flatMap(List::stream).collect(Collectors.summingInt(x -> 2 * x));
		System.out.println(sum);

		// even ?, odd ?
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(x -> {

			if (x % 2 == 0)
				return "even";
			else
				return "odd";

		}, Collectors.counting()));
		System.out.println(map);

	}
}

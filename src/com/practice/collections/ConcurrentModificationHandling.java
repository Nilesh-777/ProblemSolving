package com.practice.collections;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentModificationHandling {
	public static void main(String[] args) {
		out.println("We will learn how to deal with concurrent modification exception");

		final List<Integer> list = new ArrayList<>();

		list.add(2);
		list.add(5);
		list.add(10);

		// Replace 1 number with another
		list.replaceAll(n -> n * n);

		// Adding numbers to certain index
		out.println("Before Adding number 30 to index 1");
		list.forEach(n -> out.print(n + " "));

		out.println("\nAfter Adding number 30 to index 1");
		list.add(1, 30);
		list.forEach(n -> out.print(n + " "));

		out.println("\nAfter adding another list: [34,35] at index 1");
		list.addAll(1, new ArrayList<>(List.of(34, 35)));
		list.forEach(n -> out.print(n + " "));

		/**
		 * // Concurrent Modification ka solution for (int a : list) { if (a == 30) {
		 * list.add(list.indexOf(30), 40); } }
		 */
		// List Modified after iteration
		out.println("\nModifying list: Adding 40 after 30");
		final ListIterator<Integer> listIterator = list.listIterator();

		while (listIterator.hasNext()) {
			final int currNum = listIterator.next();

			if (currNum == 30) {
				// list.add(list.indexOf(30), 40);
				listIterator.remove();
				listIterator.add(40);
				listIterator.previous();
			}
		}

		list.forEach(n -> out.print(n + " "));
		
		
	}
}

package com.practice.basics;

import java.util.stream.IntStream;

public class PascalNumericalTriangle {

	public static void main(String[] args) {
		pascalTriangleHeight(8);
	}

	private static void pascalTriangleHeight(int height) {
		int h = height;
		for (int i = 1; i <= height; i++) {
			addSpaces(h);
			addStars(i);
			addSpaces(h - 1);
			System.out.println();
			
			h = h - 1;
		}
	}

	private static void addStars(int num) {
		if (num <= 0) {
			return;
		}

		for (int i = 1; i <= num; i++) {
			System.out.print("* ");
		}
	}

	private static void addSpaces(int num) {
		if (num <= 0) {
			return;
		}

		for (int i = 1; i <= num; i++) {
			System.out.print(" ");
		}
	}

}

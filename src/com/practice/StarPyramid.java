package com.practice;

import java.util.Scanner;

public class StarPyramid {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Shikhar ka size kya hai");
		Scanner input = new Scanner(System.in);

		int a = input.nextInt();

		for (int i = a; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

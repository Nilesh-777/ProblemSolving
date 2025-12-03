package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeNumber {

	public static void main(String[] args) {
		// Input: 121, Output: Given (121), Reverse (121), Palindrome
		// Output: 123, Output: Given (121), Reverse (321), Not a Palindrome

		{
			int num = 1;
			checkPalindrome(num);
		}

		{
			int num = 121;
			checkPalindrome(num);
		}

		{
			int num = 123;
			checkPalindrome(num);
		}

	}

	private static void checkPalindrome(int num) {
		if (num / 10 == 0) {
			outputString(num, num, true);
			return;
		}

		int revnum = reverseNumber(num);

		if (num == revnum) {
			outputString(num, revnum, true);
		} else {
			outputString(num, revnum, false);
		}
	}
	
	private static int reverseNumber2(int num) {
		int revNum = 0;
		
		do {
			int rem = num % 10;
			num = num / 10;
			revNum = revNum * 10 + rem;
		} while (num != 0);
		return revNum;
	}

	private static int reverseNumber(int num) {
		int revNum = 0;
		List<Integer> remList = new ArrayList<>();
		do {
			int rem = num % 10;
			num = num / 10;
			remList.add(rem);
		} while (num != 0);
		return constructRevNum(remList);
	}

	private static int constructRevNum(List<Integer> remList) {
		String revNum = remList.stream().map(String::valueOf).collect(Collectors.joining(""));
		return Integer.parseInt(revNum);
	}

	private static void outputString(int num, int num2, boolean isPalindrome) {
		String palStr = isPalindrome ? "Palindrome" : "Not a Palindrome";
		System.out.println("Given (" + num + "), Reverse (" + num2 + "), " + palStr);
	}
}

package com.practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindrome {

	public static void main(String[] args) {
		// Input: abccba Output: Palindrome
		// Input: abcd Output: Not a Palindrome
		{
			String s = "abccba";
			checkPalindrome(s);
		}

		{
			String s = "racecar";
			checkPalindrome(s);
		}

		{
			String s = "abcd";
			checkPalindrome(s);
		}

	}

	private static void checkPalindrome(final String str) {
		String revStr = reverse1(str);
		if (revStr.equals(str)) {
			System.out.println(str + " : Palindrome");
		} else {
			System.out.println(str + " : Not a Palindrome");
		}
	}

	private static String reverse(String str) {
		List<String> list = Arrays.asList(str.split(""));
		Collections.reverse(list);
		return String.join("", list);
	}
	
	private static String reverse1(String str) {
		return new StringBuilder(str).reverse().toString();
	}


}

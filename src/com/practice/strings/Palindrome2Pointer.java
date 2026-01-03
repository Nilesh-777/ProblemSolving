package com.practice.strings;

/**
 * https://neetcode.io/problems/is-palindrome/question?list=blind75
 */
public class Palindrome2Pointer {

	public static void main(String[] args) {
		{
			String s = "Was it a car or a cat I saw?";
			System.out.println(s + ":");
			System.out.println(isPalindrome(s) ? "Palindrome" : "Not a Palindrom");
		}

		{
			String s = "Was it a car or a cat I sa?";
			System.out.println(s + ":");
			System.out.println(isPalindrome(s) ? "Palindrome" : "Not a Palindrom");
		}
	}

	// Remove all non-alphanumeric characters with empty space
	// check if is palindrom via 2 pointer approach
	public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}

		if (s.length() == 1) {
			return false;
		}

		String scopy = "";
		char[] sarr = s.toCharArray();
		// Remove all alphanumerics
		for (char elem : sarr) {
			if (isAlphaNumeric(elem)) {
				scopy = scopy + elem;
			}
		}

		char[] scopyarr = scopy.toLowerCase().toCharArray();
		int li = scopy.length() - 1;
		int si = 0;

		boolean isPalindrome = true;
		while (si < li) {
			if (scopyarr[si] != scopyarr[li]) {
				isPalindrome = false;
			}

			si++;
			li--;
		}

		return isPalindrome;
	}

	private static boolean isAlphaNumeric(char elem) {
		if (elem >= 'A' && elem <= 'Z') {
			return true;
		}

		if (elem >= 'a' && elem <= 'z') {
			return true;
		}

		if (elem >= '0' && elem <= '9') {
			return true;
		}

		return false;
	}

}

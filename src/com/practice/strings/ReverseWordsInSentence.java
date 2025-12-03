package com.practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// Input: My Name is Nilesh
		// Output: Nilesh is Name My

		String s = "My Name is Nilesh";

		{
			String reversedString = reverseString(s);
			System.out.println(reversedString);
		}

		{
			String reversedString = reverseString1(s);
			System.out.println(reversedString);
		}

	}

	private static String reverseString1(final String str) {
		if (str == null) {
			return str;
		}

		if (str.trim().equals("")) {
			return str;
		}

		List<String> wordArr = Arrays.asList(str.split(" "));
		Collections.reverse(wordArr);
		return wordArr.stream().collect(Collectors.joining(" "));
	}

	private static String reverseString(final String str) {
		if (str == null) {
			return str;
		}

		if (str.trim().equals("")) {
			return str;
		}

		String res = "";

		String[] wordArr = str.split(" ");
		for (int i = wordArr.length - 1; i >= 0; i--) {
			res += wordArr[i] + " ";
		}

		return res.stripTrailing();
	}

}

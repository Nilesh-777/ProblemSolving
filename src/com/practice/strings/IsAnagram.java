package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Same characters in both strings. Then both strings are called anagrams.
 */
public class IsAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("car", "acr"));
	}

	public static boolean isAnagram(final String s, final String t) {
		if (s == null && t == null) {
			return false;
		}

		if (s == null && t != null) {
			return false;
		}

		if (s != null && t == null) {
			return false;
		}

		String sListStr = characterListStr(s);
		String tListStr = characterListStr(t);

		return sListStr.equals(tListStr);
	}

	private static String characterListStr(String s) {
		List<Character> list = new ArrayList<Character>();
		char[] sArr = s.toCharArray();
		for (int i = 0; i <= sArr.length - 1; i++) {
			list.add(sArr[i]);
		}

		return list.stream().map(String::valueOf).sorted().collect(Collectors.joining(""));
	}

}

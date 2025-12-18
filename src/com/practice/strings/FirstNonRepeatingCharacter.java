package com.practice.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// Input: racecar Output: e
// Input: aabbcc  Output: None
// Input: abc     Output: a
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		{
			String s = firstNonRepeatingCharacter("racecar");
			System.out.println(s);
		}

		{
			String s = firstNonRepeatingCharacter("aabbcc");
			System.out.println(s);
		}

		{
			String s = firstNonRepeatingCharacter("abc");
			System.out.println(s);
		}
		
		{
			String s = firstNonRepeatingCharacter("r");
			System.out.println(s);
		}
		
		{
			String s = firstNonRepeatingCharacter("");
			System.out.println(s);
		}


	}

	private static String firstNonRepeatingCharacter(final String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		// populate map
		for (Character c : str.toCharArray()) {
			Integer val = map.getOrDefault(c, 0);
			map.put(c, val + 1);
		}		

		// find entry with value 1
		return map.entrySet().stream()
				.filter(entry -> entry.getValue() == 1)
				.findFirst()
				.map(entry -> entry.getKey())
				.map(String::valueOf)
				.orElse("None");
	}

}

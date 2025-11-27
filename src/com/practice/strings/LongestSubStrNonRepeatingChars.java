package com.practice.strings;

// Given a string s, return the length of the longest substring without repeating characters.
// input: "abccdab" -> 4 (cdab)
//input: "abccdaab" -> 4 (cdab)
public class LongestSubStrNonRepeatingChars {

	public static void main(String[] args) {
		// Have 1 variable, ls (longest substring)
		// prev = null
		// sim = "";
		// iterate over fields one by one
		// curr == prev ? updateLs() : str = str + curr

		String input = "bbaccddxxy";

		String ls = "";
		String sim = "";
		String prev = "";
		for (String curr : input.split("")) {
			if (curr.equals(prev)) {
				if (sim.length() >= ls.length()) {
					ls = sim;
					sim = curr;
				}
				
			} else {
				sim = sim + curr;
			}
			
			prev = curr;
		}
		
		if (sim.length() >= ls.length()) {
			ls = sim;
		}
		
		System.out.println(ls);
	}

}

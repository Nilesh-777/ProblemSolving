package com.practice.strings;

// Problem: All possible palindrome permutations of string.
//Input:  s = aabcb
//Output: { abcba, bacab }
//Explanation: "abcba" and "bacab" are possible strings that are palindrome.

//Input: abc
//Output: { }
//Explanation: No possible palindromic string can be formed.

// Pseudo Code:
// Get all permutation of string
// For each permutation check if it is palindrome
// if yes -> put it into set.
// print the set

// ab: ab, ba

// abc: abc, acb, bac, bca, cab, cba: 3 X 2 = 6
// a[perm(bc)] b[perm(ac)], c[perm(ab)]

// [abcd] 4 X 3 X 2 = 24
// abcd: a[perm(bcd)], b[perm(acd)], c[perm(abd)], d[perm(abc)]


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllPossiblePalindromes {

    public static void main(String[] args) {
        String input = "cbbc";
        final Set<String> uniquePalindromes = perm(input).stream()
                .distinct()
                .filter(AllPossiblePalindromes::isPalindrome)
                .collect(Collectors.toSet());
        System.out.println(uniquePalindromes);
    }

    private static boolean isPalindrome(final String str) {
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr = reverseStr + str.substring(i, i + 1);
        }
        return str.equals(reverseStr);
    }

    private static List<String> perm(final String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        if (input.length() == 1) {
            return List.of(input);
        }

        if (input.length() == 2) {
            return permOfLength2(input);
        }

        if (input.length() == 3) {
            return permOfLength3(input);
        }

        if (input.length() == 4) {
            return permOfLength4(input);
        }

        return null;
    }

    private static List<String> permOfLength4(final String input) {
        final List<String> finalResult = new ArrayList<String>();

        final List<String> stringifiedCharList = charStringifiedList(input);

        for (final String str : stringifiedCharList) {
            final List<String> sclCopy = copy(stringifiedCharList);
            // remove ith element from list
            sclCopy.remove(str);
            // get perm of remaining
            final List<String> result = permOfLength3(sclCopy.stream().collect(Collectors.joining("")));
            // add ith element at start & append to list
            result.stream()
                    .map(resultSetStr -> str + resultSetStr)
                    .forEach(finalResult::add);
        }

        return finalResult;
    }

    private static List<String> permOfLength3(final String input) {
        final List<String> finalResult = new ArrayList<String>();

        final List<String> stringifiedCharList = charStringifiedList(input);

        for (final String str : stringifiedCharList) {
            final List<String> sclCopy = copy(stringifiedCharList);
            // remove ith element from list
            sclCopy.remove(str);
            // get perm of remaining
            final List<String> result = permOfLength2(sclCopy.stream().collect(Collectors.joining("")));
            // add ith element at start & append to list
            result.stream()
                    .map(resultSetStr -> str + resultSetStr)
                    .forEach(finalResult::add);
        }

        return finalResult;
    }

    private static List<String> copy(final List<String> list) {
        return new ArrayList<String>(list);
    }

    private static List<String> charStringifiedList(String input) {
        final List<String> charList = new ArrayList<String>();
        for (final char c : input.toCharArray()) {
            charList.add("" + c);
        }
        return charList;
    }

    private static List<String> permOfLength2(final String input) {
        final char[] charArr = input.toCharArray();
        return List.of(input, "" + charArr[1] + charArr[0]);
    }

}

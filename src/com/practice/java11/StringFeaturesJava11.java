package com.practice.java11;

public class StringFeaturesJava11 {
	public static void main(String[] args) {
		System.out.println("   ".isBlank()); // true
		"a\nb".lines().forEach(str -> System.out.println(str));
		System.out.println("  abc  ".strip()); // "abc"
		System.out.println("  abc  ".stripLeading()); // "abc "
		System.out.println("  abc  ".stripTrailing()); // " abc"
		System.out.println("ha".repeat(3)); // "hahaha"
	}
}

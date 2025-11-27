package com.practice.java17;

public class SwitchUsage {
	public static void main(String[] args) {
		String s = "a";
		String result = switch (s) {
		case "a" -> "aa";
		default -> "default";
		};
	}

}

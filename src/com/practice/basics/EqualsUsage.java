package com.practice.basics;

public class EqualsUsage {

	/**
	 * Always use equals instead of == as, equals does the comparison of actual
	 * values.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		{
			Integer a = Integer.valueOf(128);
			Integer b = Integer.valueOf(128);
			System.out.println(a == b);
			System.out.println(a.equals(b));
		}

		{
			Integer a = 128;
			Integer b = 128;
			System.out.println(a == b);
			System.out.println(a.equals(b));
		}

	}

}

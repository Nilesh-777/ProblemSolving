package com.practice.java17;

public class RecordUsage {

	public static void main(String[] args) {
		Customer c = new Customer("moje moje");
		System.out.println(c);
	}

	public record Customer(String name) {}

}

package com.practice.staticblocks;

public class StaticBlock {
	
	static {
		System.out.println("Static block 1");
	}

	static {
		System.out.println("Static block 2");
	}
	
	public static void main(String[] args) {
		System.out.println("Executing main class...");
	}

	
}

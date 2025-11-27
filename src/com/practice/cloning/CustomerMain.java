package com.practice.cloning;

public class CustomerMain {
	public static void main(String[] args) {
		Customer c1 = new Customer("1", "nilesh");
		System.out.println("c1 : " + c1);
		
		Customer c2 = c1.clone();
		Customer c3 = c1; 
		
		c2.setName("Nilesh c2");
		c3.setName("Name: Nilesh c3");
		
		System.out.println("Customer c1: " + c1);
		System.out.println("Customer c2: " + c2);
		System.out.println("Customer c3: " + c3);
	}

}

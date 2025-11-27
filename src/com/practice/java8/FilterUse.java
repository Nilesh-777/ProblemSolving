package com.practice.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class FilterUse {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17f));
		list.add(new Product(3, "Iphone 6S", 17f));

		Double priceSum = list.stream().collect(Collectors.summingDouble(p -> p.price));
		System.out.println(priceSum);

	}
}

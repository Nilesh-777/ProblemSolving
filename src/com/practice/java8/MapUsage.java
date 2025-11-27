package com.practice.java8;

import java.util.HashMap;
import java.util.Map;

public class MapUsage {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		
		map.forEach((k,v) -> System.out.println("key: " + k + " value: " + v));
	}

}

package com.practice.compare;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapUse {

	public static void main(String[] args) {
		Map<Employee, String> map = new TreeMap<Employee, String>(new NameComparator());
		map.put(new Employee(1, "nilesh"), "1");
		map.put(new Employee(5, "madan"), "5");
		map.put(new Employee(2, "ankit"), "2");
		System.out.println(map);
	}

}

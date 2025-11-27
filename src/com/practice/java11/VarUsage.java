package com.practice.java11;

import java.util.List;

public class VarUsage {
	
	public static void main(String[] args) {
		List<String> list = List.of("a", "b", "c");
		list.forEach((@NonNull var name) -> System.out.println(name));
	}

}

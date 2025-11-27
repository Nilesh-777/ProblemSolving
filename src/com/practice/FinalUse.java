package com.practice;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Student {
	private final int id;
	private final String name;
	private final List<String> optionals;

	public Student(int id, String name, List<String> optionals) {
		super();
		this.id = id;
		this.name = name;
		this.optionals = optionals;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getOptionals() {
		List<String> list = new ArrayList<String>();
		list.addAll(optionals);
		return list;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", optionals=" + optionals + "]";
	}

}

public class FinalUse {
	public static void main(String[] args) {
		final int a = 10;

		final Student s1 = new Student(10, "Mahesh", new ArrayList<>(Arrays.asList("PSIR", "Agri Engg")));
		final List<String> optionals = s1.getOptionals();
		out.println(s1);

		optionals.add("Forestry");
		out.print(s1);

	}
}

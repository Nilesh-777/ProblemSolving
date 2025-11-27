package com.practice.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		Student s1 = new Student("ankit", 12);
		Student s2 = new Student("zoya", 10);
		Student s3 = new Student("Tara", 18);

		List<Student> list = new LinkedList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);

		Collections.sort(list, new AgeComparator());

		for (Student s : list) {
			System.out.println(s);
		}

	}
}

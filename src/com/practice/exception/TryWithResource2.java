package com.practice.exception;

import java.io.Closeable;
import java.io.IOException;

public class TryWithResource2 {
	public static void main(String[] args) {
		try (Student s = new Student()) {
			System.out.println("try");
			throw new RuntimeException("try");
		} catch (final Exception e) {
			System.out.println("catch");
			throw new RuntimeException("catch");
		}
	}
}

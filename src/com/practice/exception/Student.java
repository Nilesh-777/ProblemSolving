package com.practice.exception;

import java.io.Closeable;

class Student implements Closeable {

	public void print() {
		System.out.println("Student...");
	}

	@Override
	public void close() {
		System.out.println("Student Closed.");
	}

}
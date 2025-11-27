package com.practice.java11;

public @interface NonNull {
	String message() default "%s should not be null";
}

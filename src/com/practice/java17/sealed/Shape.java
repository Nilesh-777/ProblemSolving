package com.practice.java17.sealed;

public sealed interface Shape permits Circle, Square {

	void draw();

}

package com.practice.inheritance;

import java.util.Objects;

public class Car {
	String name;
	int mileage;

	Car(String name) {
		this.name = name;
	}

	void avg() {
		System.out.println("Normal Average");
	}

	@Override
	public int hashCode() {
		return Objects.hash(mileage, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return mileage == other.mileage && Objects.equals(name, other.name);
	}

}

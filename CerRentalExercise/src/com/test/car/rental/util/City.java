package com.test.car.rental.util;

public enum City {
	
	PM(200), PB(1000), PD(2050), PC(1234.5);
	
	private double distance;

	private City(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}

}

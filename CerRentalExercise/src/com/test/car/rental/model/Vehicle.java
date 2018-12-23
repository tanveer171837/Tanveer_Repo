package com.test.car.rental.model;

import com.test.car.rental.exception.InvalidDataException;


public abstract class Vehicle {

	private int capacity;

	private String fuelType;

	private String ambiance;

	public Vehicle(int capacity, String fuelType, String ambiance) {
		this.capacity = capacity;
		this.fuelType = fuelType;
		this.ambiance = ambiance;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getAmbiance() {
		return ambiance;
	}

	public void setAmbiance(String ambiance) {
		this.ambiance = ambiance;
	}

	public abstract double acceptBooking(Booking booking) throws InvalidDataException;

}

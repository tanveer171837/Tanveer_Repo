package com.test.car.rental.model;

public class Booking {
	
	private String name;
	
	private String source;
	
	private String destination;
	
	private int numOfTrips;
	
	private int numOfPassengers;
	
	private String vehicleType;
	
	private String fuelType;
	
	private String ambiance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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

	public int getNumOfTrips() {
		return numOfTrips;
	}

	public void setNumOfTrips(int numOfTrips) {
		this.numOfTrips = numOfTrips;
	}

	@Override
	public String toString() {
		return "Booking [name=" + name + ", source=" + source
				+ ", destination=" + destination + ", numOfTrips=" + numOfTrips
				+ ", numOfPassengers=" + numOfPassengers + ", vehicleType="
				+ vehicleType + ", fuelType=" + fuelType + ", ambiance="
				+ ambiance + "]";
	}

}

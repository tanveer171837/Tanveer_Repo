package com.test.car.rental.model;

import com.test.car.rental.constant.Constants;
import com.test.car.rental.exception.InvalidDataException;
import com.test.car.rental.util.City;

public class Bus extends Vehicle{
	
	private String number;

	private String model;
		
	public Bus(String model, String number, int capacity, String ambiance, String fuelType) {
		super(capacity, fuelType, ambiance);
		this.number = number;
		this.model = model;
	}

	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public double acceptBooking(Booking booking) {
		double distance = 0;
		double rent = Constants.STANDARD_RATE -1 ;
		if(Constants.AC.equalsIgnoreCase(booking.getAmbiance())){
			rent =  rent + Constants.AC_CHARGE;
		}
		if(booking.getNumOfPassengers() > this.getCapacity()){
			int diff = booking.getNumOfPassengers() - this.getCapacity();
			rent = rent + (diff * Constants.ADDITIONAL_CHARGE);
		}
		StringBuilder code = new StringBuilder("").append(booking.getSource().charAt(0)).append(booking.getDestination().charAt(0));
		
		try{
			distance = City.valueOf(code.toString()).getDistance();
		}catch(Exception e){
			throw new InvalidDataException("2");
		}
		
		if(booking.getNumOfTrips() > 1){
			distance = distance*2;
		}
		rent = rent * distance;
		double discount = rent*Constants.DISCOUNT;
		rent = rent - discount;
		return rent;
	}

}

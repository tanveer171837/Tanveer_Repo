package com.test.car.rental.main;

import java.util.Scanner;

import com.test.car.rental.constant.Constants;
import com.test.car.rental.exception.InvalidDataException;
import com.test.car.rental.model.Booking;
import com.test.car.rental.model.Bus;
import com.test.car.rental.model.Car;
import com.test.car.rental.model.SUV;
import com.test.car.rental.model.Van;
import com.test.car.rental.model.Vehicle;
import com.test.car.rental.util.Util;

public class Main {

	public static void main(String args[]) {

		Booking bookingReq = new Booking();

		Scanner customerInput = new Scanner(System.in);

		System.out.println("Customer Name :");
		bookingReq.setName(customerInput.next());

		System.out.println("Source City Name [PUNE]:");
		bookingReq.setSource(customerInput.next().toUpperCase());

		System.out.println("Destination City Name [Please Select- Mumbai, Bangalore, Delhi, Chennai]:");
		bookingReq.setDestination(customerInput.next().toUpperCase());

		System.out.println("One-Way/Round-Trip [Select 1 OR 2] :");

		bookingReq.setNumOfTrips(customerInput.next().equalsIgnoreCase("1") ? 1 : 2);

		System.out.println("Vehicle Preference [CAR, SUV, VAN, BUS] :");
		bookingReq.setVehicleType(customerInput.next().toUpperCase());

		System.out.println("Number Of Passengers :");
		bookingReq.setNumOfPassengers(Integer.parseInt(customerInput.next()));

		System.out.println("Fuel Option [SELECT 1- PATROL OR 2- DIESEL] :");
		bookingReq.setFuelType(customerInput.next().equalsIgnoreCase("1") ? Constants.PATROL : Constants.DIESEL);

		System.out.println("Do you want A/C vehicle [YES/NO] :");
		bookingReq.setAmbiance(customerInput.next().equalsIgnoreCase("yes") ? Constants.AC : Constants.NONAC);

		try {
			Vehicle vehicle = Util.searchVehicle(bookingReq);

			String model = null;
			String number = null;

			switch (bookingReq.getVehicleType()) {
			
			case "CAR":
				model = ((Car) vehicle).getModel();
				number = ((Car) vehicle).getNumber();
				break;
		
			case "SUV":
				model = ((SUV) vehicle).getModel();
				number = ((SUV) vehicle).getNumber();
				break;

			case "VAN":
				model = ((Van) vehicle).getModel();
				number = ((Van) vehicle).getNumber();
				break;

			case "BUS":
				model = ((Bus) vehicle).getModel();
				number = ((Bus) vehicle).getNumber();
				break;
			}

			double rent = vehicle.acceptBooking(bookingReq);

			System.out.println("***** Booking Invoice *****");

			System.out.println("Booking Id - " + (int) (Math.random() * 50 + 1));

			System.out.println("Booking Status - " + "CONFIRMED");

			System.out.println("Customer Name - " + bookingReq.getName().toUpperCase());

			System.out.println("Trip 1- From " + bookingReq.getSource().toUpperCase() + " To " + bookingReq.getDestination().toUpperCase());

			if (bookingReq.getNumOfTrips() > 1) {
				System.out.println("Trip 2- From " + bookingReq.getDestination().toUpperCase() + " To " + bookingReq.getSource().toUpperCase());
			}

			System.out.println("Vehicle Preference - " + bookingReq.getVehicleType().toUpperCase());

			System.out.println("Model - " + model);

			System.out.println("Number - " + number);

			System.out.println("AC/Non-AC - " + bookingReq.getAmbiance());

			System.out.println("Total Passengers - " + bookingReq.getNumOfPassengers());

			System.out.println("Total Rent - " + rent);
		} catch (InvalidDataException e) {
			if(Constants.INVALID_VEHICLE_EXP.equals(e.getMessage())){
				System.out.println(" :: Please correct the Vehicle choice and Book again ::");
			}else if(Constants.INVALID_SRC_DEST_EXP.equals(e.getMessage())){
				System.out.println(" :: Please correct the Source/Destination city and Book again ::");
			}
		}finally{
			customerInput.close();
		}
	}
}

package com.test.car.rental.util;

import com.test.car.rental.model.Booking;
import com.test.car.rental.model.Bus;
import com.test.car.rental.model.Car;
import com.test.car.rental.model.SUV;
import com.test.car.rental.model.Van;
import com.test.car.rental.model.Vehicle;
import com.test.car.rental.constant.Constants;
import com.test.car.rental.exception.InvalidDataException;

public class Util {
	
	public static Vehicle[] populateVehicles(){
		Vehicle[] vehicles = new Vehicle[12];
		vehicles[0] = new Car("MARUTI-SWIFT", "MH-14 9999", 4, Constants.AC, "P");
		vehicles[1] = new Car("FORD-FIGO", "MH-14 8888", 4, Constants.AC, "P");
		vehicles[2] = new Car("TATA-TIAGO", "MH-14 7777", 4, Constants.NONAC, "D");
		vehicles[3] = new Car("FIAT-LINEA", "MH-14 6666", 4, Constants.AC, "D");
		vehicles[4] = new Car("TOYOTA-ETIOS", "MH-14 5555", 4, Constants.AC, "D");
		vehicles[5] = new Car("NISSAN-SUNNY", "MH-14 4444", 4, Constants.NONAC, "P");
		vehicles[6] = new SUV("MAHINDRA-MARAZZO", "MH-14 3333", 8, Constants.AC, "D");
		vehicles[7] = new SUV("MAZDA-5", "MH-14 2222", 8, Constants.AC, "D");
		vehicles[8] = new Van("MAHINDRA-SUPRO", "MH-14 1111", 8, Constants.AC, "D");
		vehicles[9] = new Van("MARUTI-OMNI", "MH-14 1000", 8, Constants.NONAC, "D");
		vehicles[10] = new Bus("ASHOK-LEYLAND", "MH-14 1200", 80, Constants.NONAC, "D");
		vehicles[11] = new Bus("VOLVO", "MH-14 1300", 100, Constants.AC, "D");
		return vehicles;
	}
	
	public static Vehicle searchVehicle(Booking bookingReq) throws InvalidDataException{
		String className = null; Vehicle availableVehicle = null;
		Vehicle[] vehicles = Util.populateVehicles();
		switch(bookingReq.getVehicleType()){
		case "CAR" :
			className = "Car";
			break;
		case "SUV" :
			className = "SUV";
			break;
		case "VAN" :
			className = "Van";
			break;
		case "BUS" :
			className = "Bus";
			break;
		}
		if (null == className) {
			throw new InvalidDataException("1");
		}
		
		if(!bookingReq.getVehicleType().equalsIgnoreCase("CAR")){
			bookingReq.setFuelType(Constants.DIESEL);
		}
		
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getClass().getSimpleName()
					.equalsIgnoreCase(className)
					&& bookingReq.getFuelType().equalsIgnoreCase(
							vehicle.getFuelType())
					&& bookingReq.getAmbiance().equalsIgnoreCase(
							vehicle.getAmbiance())) {
				availableVehicle = vehicle;
				break;
			}
		}
		return availableVehicle;
	}
}

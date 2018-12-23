package com.test.car.rental.exception;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDataException(String msg) {
		super(msg);
	}

	public InvalidDataException(String msg, Throwable t) {
		super(msg, t);
	}
}

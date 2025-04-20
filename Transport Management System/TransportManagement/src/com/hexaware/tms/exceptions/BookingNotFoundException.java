package com.hexaware.tms.exceptions;

public class BookingNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookingNotFoundException(String message) {
		super(message);
	}
}

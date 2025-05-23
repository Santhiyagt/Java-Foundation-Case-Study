package com.hexaware.tms.entity;

import java.time.LocalDateTime;
/*
 * @Authors: Priya, Santhiya
 * Date: 12-Apr-2025
 * desc: creating entity class for Bookings
 */

public class Bookings {
	private int bookingId;
	private int tripId;
	private int passengerId;
	private LocalDateTime bookingDate;
	private String status;

	public Bookings() {
	}

	public Bookings(int bookingId, int tripId, int passengerId, LocalDateTime bookingDate, String status) {
		this.bookingId = bookingId;
		this.tripId = tripId;
		this.passengerId = passengerId;
		this.bookingDate = bookingDate;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [ID=" + bookingId + ", TripID=" + tripId + ", PassengerID=" + passengerId + ", BookingDate="
				+ bookingDate + ", Status=" + status + "]";
	}
}

package com.hexaware.tms.service;

import java.util.List;

import com.hexaware.tms.entity.*;
/*
 * @Authors: Priya, Santhiya
 * Date: 17-Apr-2025
 * desc: Service Interface
 */

public interface ITransportService {

	boolean addVehicle(Vehicles vehicle);

	boolean updateVehicle(Vehicles vehicle);

	boolean deleteVehicle(int vehicleId);

	boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate);

	boolean cancelTrip(int tripId);

	boolean bookTrip(int tripId, int passengerId, String bookingDate);

	boolean cancelBooking(int bookingId);

	boolean allocateDriver(int tripId, int driverId);

	boolean deallocateDriver(int tripId);

	List<Bookings> getBookingsByPassenger(int passengerId);

	List<Bookings> getBookingsByTrip(int tripId);

	List<Drivers> getAvailableDrivers();
}

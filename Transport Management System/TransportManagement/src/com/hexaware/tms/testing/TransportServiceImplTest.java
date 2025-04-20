package com.hexaware.tms.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.tms.entity.Bookings;
import com.hexaware.tms.entity.Drivers;
import com.hexaware.tms.entity.Vehicles;
import com.hexaware.tms.service.ITransportService;
import com.hexaware.tms.service.TransportServiceImpl;
/*
 * @Authors: Priya, Santhiya
 * Date: 18-Apr-2025
 * desc: Testing for Service
 */

class TransportServiceImplTest {

	static ITransportService service;

	@BeforeAll
	static void setUpBeforeClass() {
		service = new TransportServiceImpl();
	}

	@Test
	void testAddVehicle() {
		Vehicles vehicle = new Vehicles(0, "Force Traveller", 2200, "Van", "Available");
		assertTrue(service.addVehicle(vehicle));
	}

	@Test
	void testUpdateVehicle() {
		Vehicles vehicle = new Vehicles(1, "Tata Ace Updated", 800, "Truck", "Maintenance"); // VehicleID 1 exists
		assertTrue(service.updateVehicle(vehicle));
	}

	@Test
	void testScheduleTrip() {
		String dep = "2025-05-10T08:00";
		String arr = "2025-05-10T16:00";
		assertTrue(service.scheduleTrip(7, 4, dep, arr)); // VehicleID 7, RouteID 4 both exist
	}

	@Test
	void testCancelTrip() {
		assertTrue(service.cancelTrip(10)); // TripID 10 exists
	}

	@Test
	void testBookTrip() {
		String bookingDate = "2025-04-21T10:00";
		assertTrue(service.bookTrip(3, 1, bookingDate)); // TripID 3 and PassengerID 1 exist
	}

	@Test
	void testCancelBooking() {
		assertTrue(service.cancelBooking(5)); // BookingID 5 exists
	}

	@Test
	void testAllocateDriver() {
		assertTrue(service.allocateDriver(8, 101)); // TripID 8 exists, DriverID 101 is available
	}

	@Test
	void testGetBookingsByPassenger() {
		List<Bookings> bookings = service.getBookingsByPassenger(2); // PassengerID 2 exists
		assertNotNull(bookings);
		assertFalse(bookings.isEmpty());
	}

	@Test
	void testGetBookingsByTrip() {
		List<Bookings> bookings = service.getBookingsByTrip(2); // TripID 2 exists
		assertNotNull(bookings);
		assertFalse(bookings.isEmpty());
	}

	@Test
	void testGetAvailableDrivers() {
		List<Drivers> drivers = service.getAvailableDrivers();
		assertNotNull(drivers);
		assertFalse(drivers.isEmpty());
	}
}

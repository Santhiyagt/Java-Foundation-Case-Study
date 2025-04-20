package com.hexaware.tms.testing;

import com.hexaware.tms.dao.TransportManagementDaoImpl;
import com.hexaware.tms.entity.Bookings;
import com.hexaware.tms.entity.Drivers;
import com.hexaware.tms.entity.Vehicles;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
 * @Authors: Priya, Santhiya
 * Date: 18-Apr-2025
 * desc: Testing for Dao
 */

public class TransportManagementDaoImplTest {

	static TransportManagementDaoImpl dao;

	@BeforeAll
	static void setUpBeforeClass() {
		dao = new TransportManagementDaoImpl();
	}

	@Test
	public void testAddVehicle() throws SQLException {
		Vehicles v = new Vehicles(0, "ModelX", 30, "Truck", "Available");
		assertTrue(dao.addVehicle(v));
	}

	@Test
	public void testUpdateVehicle() throws SQLException {
		Vehicles v = new Vehicles(1, "UpdatedModel", 40, "Bus", "Unavailable");
		assertTrue(dao.updateVehicle(v));
	}

	@Test
	public void testScheduleTrip() throws SQLException {
		assertTrue(dao.scheduleTrip(1, 1, "2025-04-22", "2025-04-23"));
	}

	@Test
	public void testCancelTrip() throws SQLException {
		assertTrue(dao.cancelTrip(1)); // Ensure trip with ID 1 exists
	}

	@Test
	public void testBookTrip() throws SQLException {
		assertTrue(dao.bookTrip(1, 1, "2025-04-20")); // Ensure trip & passenger IDs exist
	}

	@Test
	public void testCancelBooking() throws SQLException {
		assertTrue(dao.cancelBooking(1)); // Ensure booking ID 1 exists
	}

	@Test
	public void testGetAvailableDrivers() throws SQLException {
		List<Drivers> drivers = dao.getAvailableDrivers();
		assertNotNull(drivers);
	}

	@Test
	public void testGetBookingsByPassenger() throws SQLException {
		List<Bookings> bookings = dao.getBookingsByPassenger(1);
		assertNotNull(bookings);
	}

	@Test
	public void testGetBookingsByTrip() throws SQLException {
		List<Bookings> bookings = dao.getBookingsByTrip(1);
		assertNotNull(bookings);
	}
}
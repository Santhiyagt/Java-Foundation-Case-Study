package com.hexaware.tms.service;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.tms.dao.ITransportManagementDao;
import com.hexaware.tms.dao.TransportManagementDaoImpl;
import com.hexaware.tms.entity.Bookings;
import com.hexaware.tms.entity.Drivers;
import com.hexaware.tms.entity.Vehicles;
/*
 * @Authors: Priya, Santhiya
 * Date: 17-Apr-2025
 * desc: Service Implementation
 */

public class TransportServiceImpl implements ITransportService {

	ITransportManagementDao dao = new TransportManagementDaoImpl();

	@Override
	public boolean addVehicle(Vehicles vehicle) {
		try {
			return dao.addVehicle(vehicle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateVehicle(Vehicles vehicle) {
		try {
			return dao.updateVehicle(vehicle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteVehicle(int vehicleId) {
		try {
			return dao.deleteVehicle(vehicleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate) {
		try {
			return dao.scheduleTrip(vehicleId, routeId, departureDate, arrivalDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cancelTrip(int tripId) {
		try {
			return dao.cancelTrip(tripId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean bookTrip(int tripId, int passengerId, String bookingDate) {
		try {
			return dao.bookTrip(tripId, passengerId, bookingDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		try {
			return dao.cancelBooking(bookingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean allocateDriver(int tripId, int driverId) {
		try {
			return dao.allocateDriver(tripId, driverId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deallocateDriver(int tripId) {
		try {
			return dao.deallocateDriver(tripId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Bookings> getBookingsByPassenger(int passengerId) {
		try {
			return dao.getBookingsByPassenger(passengerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bookings> getBookingsByTrip(int tripId) {
		try {
			return dao.getBookingsByTrip(tripId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Drivers> getAvailableDrivers() {
		try {
			return dao.getAvailableDrivers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.hexaware.tms.dao;

import java.sql.SQLException;
import java.util.List;
import com.hexaware.tms.entity.*;

public interface ITransportManagementService {
    
    // Vehicle Operations
    boolean addVehicle(Vehicles vehicle) throws SQLException;
    boolean updateVehicle(Vehicles vehicle) throws SQLException;
    boolean deleteVehicle(int vehicleId) throws SQLException;

    // Trip Operations
    boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate) throws SQLException;
    boolean cancelTrip(int tripId) throws SQLException;

    // Booking Operations
    boolean bookTrip(int tripId, int passengerId, String bookingDate) throws SQLException;
    boolean cancelBooking(int bookingId) throws SQLException;

    // Driver Allocation
    boolean allocateDriver(int tripId, int driverId) throws SQLException;
    boolean deallocateDriver(int tripId) throws SQLException;

    // Booking Retrieval
    List<Bookings> getBookingsByPassenger(int passengerId) throws SQLException;
    List<Bookings> getBookingsByTrip(int tripId) throws SQLException;

    // Driver Retrieval
    List<Drivers> getAvailableDrivers() throws SQLException;
}


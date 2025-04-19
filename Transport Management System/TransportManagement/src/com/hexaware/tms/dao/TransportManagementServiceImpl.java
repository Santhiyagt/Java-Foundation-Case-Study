package com.hexaware.tms.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import com.hexaware.tms.entity.*;
import com.hexaware.tms.util.*;

public class TransportManagementServiceImpl implements ITransportManagementService {

	 Connection conn;

	    public TransportManagementServiceImpl() {
	        try {
	            conn = DbUtil.getDBConnection();
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    }



    // VEHICLE OPERATIONS
    @Override
    public boolean addVehicle(Vehicles vehicle) throws SQLException {
        String sql = "INSERT INTO vehicles (Model, Capacity, Type, Status) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vehicle.getModel());
        ps.setDouble(2, vehicle.getCapacity());
        ps.setString(3, vehicle.getType());
        ps.setString(4, vehicle.getStatus());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean updateVehicle(Vehicles vehicle) throws SQLException {
        String sql = "UPDATE vehicles SET Model=?, Capacity=?, Type=?, Status=? WHERE VehicleID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vehicle.getModel());
        ps.setDouble(2, vehicle.getCapacity());
        ps.setString(3, vehicle.getType());
        ps.setString(4, vehicle.getStatus());
        ps.setInt(5, vehicle.getVehicleId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean deleteVehicle(int vehicleId) throws SQLException {
        String sql = "DELETE FROM vehicles WHERE VehicleID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, vehicleId);
        return ps.executeUpdate() > 0;
    }

    // TRIP OPERATIONS
    @Override
    public boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate) throws SQLException {
        String sql = "INSERT INTO trips (VehicleID, RouteID, DepartureDate, ArrivalDate, Status, TripType, MaxPassengers) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, vehicleId);
        ps.setInt(2, routeId);
        ps.setString(3, departureDate);
        ps.setString(4, arrivalDate);
        ps.setString(5, "Scheduled");
        ps.setString(6, "Freight");
        ps.setInt(7, 0);  // default for freight
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean cancelTrip(int tripId) throws SQLException {
        String sql = "UPDATE trips SET Status='Cancelled' WHERE TripID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tripId);
        return ps.executeUpdate() > 0;
    }

    // BOOKING OPERATIONS
    @Override
    public boolean bookTrip(int tripId, int passengerId, String bookingDate) throws SQLException {
        String sql = "INSERT INTO bookings (TripID, PassengerID, BookingDate, Status) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tripId);
        ps.setInt(2, passengerId);
        ps.setString(3, bookingDate);
        ps.setString(4, "Confirmed");
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean cancelBooking(int bookingId) throws SQLException {
        String sql = "UPDATE bookings SET Status='Cancelled' WHERE BookingID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bookingId);
        return ps.executeUpdate() > 0;
    }

    // DRIVER ALLOCATION
    @Override
    public boolean allocateDriver(int tripId, int driverId) throws SQLException {
        String sql = "INSERT INTO driverallocation (TripID, DriverID) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tripId);
        ps.setInt(2, driverId);
        boolean success = ps.executeUpdate() > 0;

        if (success) {
            PreparedStatement updateStatus = conn.prepareStatement("UPDATE drivers SET Status='Allocated' WHERE DriverID=?");
            updateStatus.setInt(1, driverId);
            updateStatus.executeUpdate();
        }
        return success;
    }

    @Override
    public boolean deallocateDriver(int tripId) throws SQLException {
        int driverId = -1;
        PreparedStatement fetch = conn.prepareStatement("SELECT DriverID FROM driverallocation WHERE TripID=?");
        fetch.setInt(1, tripId);
        ResultSet rs = fetch.executeQuery();
        if (rs.next()) {
            driverId = rs.getInt("DriverID");
        }

        String sql = "DELETE FROM driverallocation WHERE TripID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tripId);
        boolean success = ps.executeUpdate() > 0;

        if (success && driverId != -1) {
            PreparedStatement update = conn.prepareStatement("UPDATE drivers SET Status='Available' WHERE DriverID=?");
            update.setInt(1, driverId);
            update.executeUpdate();
        }

        return success;
    }

    // BOOKINGS RETRIEVAL
    @Override
    public List<Bookings> getBookingsByPassenger(int passengerId) throws SQLException {
        String sql = "SELECT * FROM bookings WHERE PassengerID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, passengerId);
        ResultSet rs = ps.executeQuery();

        List<Bookings> list = new ArrayList<>();
        while (rs.next()) {
            Bookings booking = new Bookings(
                rs.getInt("BookingID"),
                rs.getInt("TripID"),
                rs.getInt("PassengerID"),
                rs.getTimestamp("BookingDate").toLocalDateTime(),
                rs.getString("Status")
            );
            list.add(booking);
        }
        return list;
    }

    @Override
    public List<Bookings> getBookingsByTrip(int tripId) throws SQLException {
        String sql = "SELECT * FROM bookings WHERE TripID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, tripId);
        ResultSet rs = ps.executeQuery();

        List<Bookings> list = new ArrayList<>();
        while (rs.next()) {
            Bookings booking = new Bookings(
                rs.getInt("BookingID"),
                rs.getInt("TripID"),
                rs.getInt("PassengerID"),
                rs.getTimestamp("BookingDate").toLocalDateTime(),
                rs.getString("Status")
            );
            list.add(booking);
        }
        return list;
    }

    // AVAILABLE DRIVERS
    @Override
    public List<Drivers> getAvailableDrivers() throws SQLException {
        String sql = "SELECT * FROM drivers WHERE Status='Available'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Drivers> list = new ArrayList<>();
        while (rs.next()) {
            Drivers driver = new Drivers(
                rs.getInt("DriverID"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("LicenseNumber"),
                rs.getString("Status")
            );
            list.add(driver);
        }
        return list;
    }
}


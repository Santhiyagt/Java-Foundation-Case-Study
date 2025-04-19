package com.hexaware.tms.main;


import java.util.List;
import java.util.Scanner;

import com.hexaware.tms.dao.*;

import com.hexaware.tms.entity.*;
import com.hexaware.tms.exceptions.*; 


public class TransportManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ITransportManagementService service = new TransportManagementServiceImpl();

        while (true) {
            System.out.println("\n--- TRANSPORT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Update Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Schedule Trip");
            System.out.println("5. Cancel Trip");
            System.out.println("6. Book Trip");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Allocate Driver");
            System.out.println("9. Deallocate Driver");
            System.out.println("10. Get Bookings By Passenger");
            System.out.println("11. Get Bookings By Trip");
            System.out.println("12. Get Available Drivers");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Model: ");
                        String model = sc.nextLine();
                        System.out.print("Capacity: ");
                        double cap = Double.parseDouble(sc.nextLine());
                        System.out.print("Type: ");
                        String type = sc.nextLine();
                        System.out.print("Status: ");
                        String status = sc.nextLine();
                        Vehicles vehicle = new Vehicles(0, model, cap, type, status);
                        System.out.println(service.addVehicle(vehicle) ? "Vehicle added." : "Failed to add vehicle.");
                        break;

                    case 2:
                        System.out.print("Vehicle ID: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        System.out.print("Model: ");
                        String upModel = sc.nextLine();
                        System.out.print("Capacity: ");
                        double upCap = Double.parseDouble(sc.nextLine());
                        System.out.print("Type: ");
                        String upType = sc.nextLine();
                        System.out.print("Status: ");
                        String upStatus = sc.nextLine();
                        Vehicles updatedVehicle = new Vehicles(updateId, upModel, upCap, upType, upStatus);
                        System.out.println(service.updateVehicle(updatedVehicle) ? "Vehicle updated." : "Update failed.");
                        break;

                    case 3:
                        System.out.print("Vehicle ID to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        if (service.deleteVehicle(deleteId)) {
                            System.out.println("Vehicle deleted.");
                        } else {
                            throw new VehicleNotFoundException("Vehicle with ID " + deleteId + " not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Vehicle ID: ");
                        int vId = Integer.parseInt(sc.nextLine());
                        System.out.print("Route ID: ");
                        int rId = Integer.parseInt(sc.nextLine());
                        System.out.print("Departure (yyyy-mm-dd hh:mm:ss): ");
                        String dep = sc.nextLine();
                        System.out.print("Arrival (yyyy-mm-dd hh:mm:ss): ");
                        String arr = sc.nextLine();
                        System.out.println(service.scheduleTrip(vId, rId, dep, arr) ? "Trip scheduled." : "Failed to schedule trip.");
                        break;

                    case 5:
                        System.out.print("Trip ID to cancel: ");
                        int cancelTid = Integer.parseInt(sc.nextLine());
                        System.out.println(service.cancelTrip(cancelTid) ? "Trip cancelled." : "Cancellation failed.");
                        break;

                    case 6:
                        System.out.print("Trip ID: ");
                        int tId = Integer.parseInt(sc.nextLine());
                        System.out.print("Passenger ID: ");
                        int pId = Integer.parseInt(sc.nextLine());
                        System.out.print("Booking Date (yyyy-mm-dd hh:mm:ss): ");
                        String bDate = sc.nextLine();
                        System.out.println(service.bookTrip(tId, pId, bDate) ? "Booking successful." : "Booking failed.");
                        break;

                    case 7:
                        System.out.print("Booking ID to cancel: ");
                        int bid = Integer.parseInt(sc.nextLine());
                        System.out.println(service.cancelBooking(bid) ? "Booking cancelled." : "Cancellation failed.");
                        break;

                    case 8:
                        System.out.print("Trip ID: ");
                        int tripAllocId = Integer.parseInt(sc.nextLine());
                        System.out.print("Driver ID: ");
                        int driverId = Integer.parseInt(sc.nextLine());
                        System.out.println(service.allocateDriver(tripAllocId, driverId) ? "Driver allocated." : "Allocation failed.");
                        break;

                    case 9:
                        System.out.print("Trip ID to deallocate driver: ");
                        int deallocId = Integer.parseInt(sc.nextLine());
                        System.out.println(service.deallocateDriver(deallocId) ? "Driver deallocated." : "Deallocation failed.");
                        break;

                    case 10:
                        System.out.print("Passenger ID: ");
                        int passId = Integer.parseInt(sc.nextLine());
                        List<Bookings> bookingsByPassenger = service.getBookingsByPassenger(passId);
                        if (bookingsByPassenger.isEmpty()) {
                            throw new BookingNotFoundException("No bookings for passenger ID " + passId);
                        }
                        bookingsByPassenger.forEach(System.out::println);
                        break;

                    case 11:
                        System.out.print("Trip ID: ");
                        int bTripId = Integer.parseInt(sc.nextLine());
                        List<Bookings> bookingsByTrip = service.getBookingsByTrip(bTripId);
                        if (bookingsByTrip.isEmpty()) {
                            throw new BookingNotFoundException("No bookings for trip ID " + bTripId);
                        }
                        bookingsByTrip.forEach(System.out::println);
                        break;

                    case 12:
                        List<Drivers> availableDrivers = service.getAvailableDrivers();
                        if (availableDrivers.isEmpty()) {
                            System.out.println("No available drivers.");
                        } else {
                            availableDrivers.forEach(System.out::println);
                        }
                        break;

                    case 0:
                        System.out.println("Thank You");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }

            } catch (VehicleNotFoundException | BookingNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

package com.hexaware.tms.entity;


public class Drivers {
    private int driverId;
    private String firstName;
    private String lastName;
    private String licenseNumber;
    private String status;

    public Drivers() {}

    public Drivers(int driverId, String firstName, String lastName, String licenseNumber, String status) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Driver [ID=" + driverId + ", Name=" + firstName + " " + lastName + ", License=" + licenseNumber + ", Status=" + status + "]";
    }
}

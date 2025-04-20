package com.hexaware.tms.entity;
/*
 * @Authors: Priya, Santhiya
 * Date: 12-Apr-2025
 * desc: creating entity class for DriverAllocation
 */

public class DriverAllocation {
	private int allocationId;
	private int tripId;
	private int driverId;

	public DriverAllocation() {
	}

	public DriverAllocation(int allocationId, int tripId, int driverId) {
		this.allocationId = allocationId;
		this.tripId = tripId;
		this.driverId = driverId;
	}

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "DriverAllocation [AllocationID=" + allocationId + ", TripID=" + tripId + ", DriverID=" + driverId + "]";
	}
}

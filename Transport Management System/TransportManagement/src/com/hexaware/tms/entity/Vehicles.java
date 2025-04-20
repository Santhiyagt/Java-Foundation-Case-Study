package com.hexaware.tms.entity;
/*
 * @Authors: Priya, Santhiya
 * Date: 13-Apr-2025
 * desc: creating entity class for Vehicles
 */

public class Vehicles {
	private int vehicleId;
	private String model;
	private double capacity;
	private String type;
	private String status;

	public Vehicles() {
	}

	public Vehicles(int vehicleId, String model, double capacity, String type, String status) {
		this.vehicleId = vehicleId;
		this.model = model;
		this.capacity = capacity;
		this.type = type;
		this.status = status;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vehicle [ID=" + vehicleId + ", Model=" + model + ", Capacity=" + capacity + ", Type=" + type
				+ ", Status=" + status + "]";
	}
}

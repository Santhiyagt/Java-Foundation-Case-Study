package com.hexaware.tms.entity;
/*
 * @Authors: Priya, Santhiya
 * Date: 12-Apr-2025
 * desc: creating entity class for Passengers
 */

public class Passengers {
	private int passengerId;
	private String firstName;
	private String gender;
	private int age;
	private String email;
	private String phoneNumber;

	public Passengers() {
	}

	public Passengers(int passengerId, String firstName, String gender, int age, String email, String phoneNumber) {
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Passenger [ID=" + passengerId + ", Name=" + firstName + ", Gender=" + gender + ", Age=" + age
				+ ", Email=" + email + ", Phone=" + phoneNumber + "]";
	}
}

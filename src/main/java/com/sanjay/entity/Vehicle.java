package com.sanjay.entity;

import com.sanjay.dto.VehicleTypeAndStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Vehicle {
	
	private String vehicleNo;
	private String vehicleName;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private VehicleTypeAndStatus bookingStatus;
	@Enumerated(EnumType.STRING)
	private VehicleTypeAndStatus vehicleType;
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public VehicleTypeAndStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(VehicleTypeAndStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public VehicleTypeAndStatus getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleTypeAndStatus vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}

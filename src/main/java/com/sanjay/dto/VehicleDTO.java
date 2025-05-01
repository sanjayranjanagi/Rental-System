package com.sanjay.dto;

public class VehicleDTO {
	
	private String vehicleNo;
	private String vehicleName;
	private Integer price;
	private String bookingStatus;
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
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public VehicleTypeAndStatus getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleTypeAndStatus vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}

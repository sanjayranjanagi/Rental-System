package com.sanjay.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RentalHistory {
	
	private Integer id;
	private LocalDate pickUpDate;
	private LocalDate dropOffDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_no")
	private Vehicle vehicle;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public LocalDate getDropOffDate() {
		return dropOffDate;
	}
	public void setDropOffDate(LocalDate dropOffDate) {
		this.dropOffDate = dropOffDate;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}

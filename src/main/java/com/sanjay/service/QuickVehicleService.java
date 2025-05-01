package com.sanjay.service;

import com.sanjay.dto.CustomerDTO;
import com.sanjay.exception.QuickRentalException;

public interface QuickVehicleService {
	
	public CustomerDTO viewRentalHistory(Integer customerId) throws QuickRentalException;
	
	public String deleteCustomer(CustomerDTO customerDTo) throws QuickRentalException;
}

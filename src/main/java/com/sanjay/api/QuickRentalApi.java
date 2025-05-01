package com.sanjay.api;

import org.hibernate.annotations.AnyDiscriminator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.dto.CustomerDTO;
import com.sanjay.exception.QuickRentalException;
import com.sanjay.service.QuickVehicleService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping(value="/quick-rent")
@Validated
public class QuickRentalApi {
	
	@Autowired
	private QuickVehicleService quickVehicleService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value="/rent-history/{customerId}")
	public ResponseEntity<CustomerDTO>getCustomer(@Valid @PathVariable
			@Min(value=1000,message= "{customer.id.invalid}")Integer customerId) throws QuickRentalException{
		CustomerDTO cdto=quickVehicleService.viewRentalHistory(customerId);
		
		return new ResponseEntity<>(cdto,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String>deleteCustomer(@RequestBody CustomerDTO customerDTO) throws QuickRentalException{
		String no=quickVehicleService.deleteCustomer(customerDTO);
		String successMessage=environment.getProperty("QuickRentalApi.CUSTOMER-DELETED")+":"+no;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
}

package com.sanjay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjay.dto.CustomerDTO;
import com.sanjay.dto.RentalHistoryDTO;
import com.sanjay.dto.VehicleDTO;
import com.sanjay.entity.Customer;
import com.sanjay.entity.RentalHistory;
import com.sanjay.exception.QuickRentalException;
import com.sanjay.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service(value="quickVehicleService")
@Transactional
public class QuickVehicleServiceImpl implements QuickVehicleService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerDTO viewRentalHistory(Integer customerId) throws QuickRentalException{
		Optional<Customer>cust=customerRepository.findById(customerId);
		if(cust.isEmpty()) {
			throw new QuickRentalException("QuickVehicleService.CUSTOMER_NOT_FOUND");
		}
		Customer c=cust.get();
		CustomerDTO cdto=new CustomerDTO();
		cdto.setCustomerId(customerId);
		cdto.setCustomerName(c.getCustomerName());
		cdto.setDrivingLicenceNo(c.getDrivingLicenceNo());
		cdto.setAge(c.getAge());
		
		List<RentalHistory>r=new ArrayList<>();
		r=c.getRentalHistory();
		
		List<RentalHistoryDTO>res=new ArrayList<>();
		int i=0;
		for(RentalHistory rr:r) {
			RentalHistoryDTO ren=new RentalHistoryDTO();
			ren.setId(rr.getId());
			ren.setPickUpDate(rr.getPickUpDate());
			ren.setDropOffDate(rr.getDropOffDate());
			
			VehicleDTO v=new VehicleDTO();
			v.setVehicleNo(c.getRentalHistory().get(i).getVehicle().getVehicleNo());
			v.setPrice(c.getRentalHistory().get(i).getVehicle().getPrice());
			v.setVehicleName(c.getRentalHistory().get(i).getVehicle().getVehicleName());
			v.setBookingStatus(c.getRentalHistory().get(i).getVehicle().getBookingStatus().name());
			v.setVehicleType(c.getRentalHistory().get(i).getVehicle().getVehicleType());
			
			ren.setVehicleDTO(v);
			res.add(ren);
		}
		
		cdto.setRentalHistoryDTOs(res);
		List<RentalHistoryDTO>ans=res.stream().sorted((r1,r2)->r1.getDropOffDate().compareTo(r2.getDropOffDate())).collect(Collectors.toList());
		
		
		return cdto;
	}
	
		@Override
		public String deleteCustomer(CustomerDTO customerDTO) throws QuickRentalException{
			Optional<Customer>c=customerRepository.findByDrivingLicenceNo(customerDTO.getDrivingLicenceNo());
			System.out.println("Received Driving Licence No: " + customerDTO.getDrivingLicenceNo());

			if(c.isEmpty()) {
				throw new QuickRentalException("QuickVehicleService.CUSTOMER_NOT_FOUND");
			}
			Customer cust=c.get();
			String no=cust.getDrivingLicenceNo();
			customerRepository.delete(cust);
			
			return no;
		}
		
		@Override
		public String registerCustomer(CustomerDTO customerDTO) throws QuickRentalException {
		    Optional<Customer> existing = customerRepository.findByDrivingLicenceNo(customerDTO.getDrivingLicenceNo());
		    if (existing.isPresent()) {
		        throw new QuickRentalException("QuickVehicleService.CUSTOMER_ALREADY_EXISTS");
		    }

		    Customer c = new Customer();
		    c.setCustomerName(customerDTO.getCustomerName());
		    c.setDrivingLicenceNo(customerDTO.getDrivingLicenceNo());
		    c.setAge(customerDTO.getAge());

		    Customer saved = customerRepository.save(c);
		    return saved.getCustomerName();
		}

}

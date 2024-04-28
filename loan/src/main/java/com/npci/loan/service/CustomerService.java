package com.npci.loan.service;

import org.springframework.data.repository.query.Param;

import com.npci.loan.bean.Customer;

public interface CustomerService {
	
	public Customer store(Customer customer);

	 

    boolean existsByEmailIdAndPassword(String emailId, String password);

    
    public Long findCustomerIdByEmailId(String emailId);


	public Customer findByCustomerId(Long customerId);
		
	

}

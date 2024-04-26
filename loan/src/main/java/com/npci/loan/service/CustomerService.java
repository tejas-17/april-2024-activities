package com.npci.loan.service;

import com.npci.loan.bean.Customer;

public interface CustomerService {
	
	public Customer store(Customer customer);

	 

    boolean existsByEmailIdAndPassword(String emailId, String password);
		
	

}

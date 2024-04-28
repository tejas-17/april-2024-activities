package com.npci.loan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.npci.loan.bean.Customer;
import com.npci.loan.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer store(Customer customer) {
        return customerDao.save(customer);
    }
    
    
 

    @Override
    public boolean existsByEmailIdAndPassword(String emailId, String password) {
        return customerDao.existsByEmailIdAndPassword(emailId, password);
    }




	@Override
	public Customer findByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
        return customerDao.findByCustomerId(customerId);
	}




	@Override
	public Long findCustomerIdByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerIdByEmailId(emailId);
	}



    
}

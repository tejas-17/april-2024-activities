package com.npci.loan.service;

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
}

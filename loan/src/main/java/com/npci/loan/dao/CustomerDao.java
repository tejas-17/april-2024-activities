package com.npci.loan.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.npci.loan.bean.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    boolean existsByEmailIdAndPassword(String emailId, String password);
    
    @Query("SELECT c.customerId FROM Customer c WHERE c.emailId = :emailId")
    Long findCustomerIdByEmailId(@Param("emailId") String emailId);

    @Query("SELECT c FROM Customer c WHERE c.customerId = :customerId")
    Customer findByCustomerId(@Param("customerId") Long customerId);
}

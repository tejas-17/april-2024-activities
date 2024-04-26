package com.npci.loan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.loan.bean.Customer;
import com.npci.loan.service.CustomerService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	private CustomerService customerService;
	
	
	 public CustomerController(CustomerService customerService) {
	        this.customerService = customerService;
	    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Customer customer){
		return ResponseEntity.status(201).body(customerService.store(customer));
	}
	
	
	  @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody Customer customer) {
	        boolean isValid = customerService.existsByEmailIdAndPassword(customer.getEmailId(), customer.getPassword());
	        if (isValid) {
	            return ResponseEntity.ok("Login successful!");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
	        }
	    }

}

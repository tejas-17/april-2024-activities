package com.npci.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.npci.loan.bean.Customer;
import com.npci.loan.bean.Loan;
import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.service.CustomerService;
import com.npci.loan.service.LoanAppService;
import com.npci.loan.service.LoanService;


@CrossOrigin(origins="*")

@RestController
@RequestMapping("/loanapp")
public class LoanAppController {
    
    private final LoanAppService loanAppService;
    private final CustomerService customerService;
    private final LoanService loanService;

    @Autowired
    public LoanAppController(LoanAppService loanAppService, CustomerService customerService, LoanService loanService) {
        this.loanAppService = loanAppService;
        this.customerService = customerService;
        this.loanService = loanService;
    }

    
    
    // Your controller method
    @PostMapping("/getData")
    public LoanAppTable getLoanAppData(@RequestBody String jsonRequest) {
        try {
            // Parse the JSON string to extract the email ID
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonRequest);
            String emailId = rootNode.path("emailId").asText();
            
            System.out.println("Email ID: " + emailId);

            // Call the service method to get loan application info based on email ID
            LoanAppTable loanAppTable = loanAppService.getLoanAppinfo(emailId);
            System.out.println("Get data response: " + loanAppTable);

            return loanAppTable;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or handle the error as required
        }
    }

    
    @PostMapping("/apply")
    public LoanAppTable applyForLoan(@RequestBody LoanAppTable loanAppTable) {
        // Create a new instance of LoanAppTable and set its properties
        LoanAppTable newLoanAppTable = new LoanAppTable();
        
        // Retrieve Customer and Loan objects from their respective services or repositories
        
        String emailId = loanAppTable.getCustomer().getEmailId();
        Long loanId = loanAppTable.getLoan().getLoanId();
        
        Long customerId=customerService.findCustomerIdByEmailId(emailId);
        
        
        Customer customer = customerService.findByCustomerId(customerId);
        Loan loan = loanService.findByLoanId(loanId);
        
        // Set the retrieved Customer and Loan objects
        newLoanAppTable.setCustomer(customer);
        newLoanAppTable.setLoan(loan);
        newLoanAppTable.setStatus(loanAppTable.getStatus());
        
        // Save the LoanAppTable instance using Spring Data JPA repository
        return loanAppService.store(newLoanAppTable);
    }
}

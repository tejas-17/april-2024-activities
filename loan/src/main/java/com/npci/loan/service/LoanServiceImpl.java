package com.npci.loan.service;

import com.npci.loan.bean.Customer;
import com.npci.loan.bean.Loan;
import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.dao.CustomerDao;
import com.npci.loan.dao.LoanAppDao;
import com.npci.loan.dao.LoanDao;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao;
    
    private LoanAppDao appdao;

    
    @Autowired
    private CustomerDao customerDao;

 
    @Autowired
    public LoanServiceImpl(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    public List<String> getAllLoanTypes() {
        // Here you can retrieve all loan types from the database or any other source
        // For simplicity, let's return a hardcoded list
    	
        List<String> loanTypes = loanDao.findAllLoanTypes();
        
        return loanTypes;

    }



    @Override
    public String checkLoanStatus(Long loanId) {
        // Here you can implement the logic to check the status of the loan
        // For simplicity, let's just retrieve the loan from the database and return its status
    	return "";
    }

    @Override
    public Loan save(Loan loan) {
        // Delegate the task of saving the loan to the LoanDao object
    	
    	
        return loanDao.save(loan);
    }

	@Override
	public Loan applyForLoan(Map<String, Object> requestBody) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object applyForLoan(Map<String, Object> requestBody, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	
	 public Long getCustomerIdByEmailId(String emailId) {
	        return customerDao.findCustomerIdByEmailId(emailId);
	    }


	 
	  @Override
	    public Object loanApply(Map<String, Object> requestBody) {
		  System.out.print("333333333333333"+requestBody);
		  String emailId=(String)requestBody.get("emailId");
		  Long customerId = getCustomerIdByEmailId(emailId);
		  System.out.print("########################"+customerId);
		  
		  requestBody.put("customerId", customerId);
		  
		  System.out.println("");

		  System.out.println("########################"+requestBody);
		  
		  

		  
		  
		  return "";
	  }


//@Override
//public Object loanApply(Map<String, Object> requestBody) {
//    System.out.println("Request Body: " + requestBody);
//    
//    // Extract emailId from the request body
//    String emailId = (String) requestBody.get("emailId");
//    
//    // Get customerId from emailId
//    Long customerId = getCustomerIdByEmailId(emailId);
//    System.out.println("Customer ID: " + customerId);
//    
//    // Create a new instance of Customer using customerId
//    Customer customer = new Customer();
//    customer.setCustomerId(customerId);
//    
//    // Create a new instance of Loan using loanId
//    Long loanId = (Long) requestBody.get("loanId");
//    Loan loan = new Loan();
//    loan.setLoanId(loanId);
//    
//    // Create a new instance of LoanAppTable and set its properties
//    LoanAppTable loanAppTable = new LoanAppTable();
//    loanAppTable.setCustomer(customer);
//    loanAppTable.setLoan(loan);
//    loanAppTable.setStatus((String) requestBody.get("status"));
//    
//    // Save the LoanAppTable instance using Spring Data JPA repository
//    LoanAppTable savedLoanAppTable = appdao.save(loanAppTable);
//    
//    System.out.println("Saved Loan Application Table: " + savedLoanAppTable);
//    
//    return savedLoanAppTable; // You can return whatever is appropriate for your application
//}

}
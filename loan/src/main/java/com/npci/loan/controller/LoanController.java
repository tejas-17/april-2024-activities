package com.npci.loan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.npci.loan.bean.Customer;
import com.npci.loan.bean.Loan;
import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.service.LoanAppService;
import com.npci.loan.service.LoanService;
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/loan")
public class LoanController {

	
    private LoanService loanService;
    
    

    
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
        
        
    }

    @GetMapping("/types")
    public ResponseEntity<Object> getAllLoanTypes() {
        return ResponseEntity.ok(loanService.getAllLoanTypes());
    }

   
    
    
//    @PostMapping(value = "/apply", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> applyForLoan(@RequestBody Map<String, ) {
//      
//    	System.out.print("request bodyyyyyyyyyyyyyyyyyyyyyyyyy"+requestBody);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.loanApply(requestBody));
//    }

    @GetMapping("/status/{loanId}")
    public ResponseEntity<Object> checkLoanStatus(@PathVariable Long loanId) {
        String status = loanService.checkLoanStatus(loanId);
        if (status != null) {
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan with ID " + loanId + " not found.");
        }
    }
}

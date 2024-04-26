package com.npci.loan.service;

import com.npci.loan.bean.Loan;

import java.util.List;
import java.util.Map;

public interface LoanService {

    List<String> getAllLoanTypes();


    String checkLoanStatus(Long loanId);
	public Loan save(Loan loan);




}

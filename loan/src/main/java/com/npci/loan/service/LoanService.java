package com.npci.loan.service;

import com.npci.loan.bean.Loan;

import java.util.List;
import java.util.Map;

public interface LoanService {

    List<String> getAllLoanTypes();

    Loan applyForLoan(Map<String, Object> requestBody);

    String checkLoanStatus(Long loanId);
	public Loan save(Loan loan);

	Object applyForLoan(Map<String, Object> requestBody, String customerEmail);

	Object loanApply(Map<String, Object> requestBody);


}

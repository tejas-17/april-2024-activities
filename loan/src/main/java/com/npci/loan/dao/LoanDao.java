package com.npci.loan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.loan.bean.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> { 

	public Loan save(Loan loan);

	
	@Query("SELECT DISTINCT l.loanType FROM Loan l")
	List<String> findAllLoanTypes();
	
	


}

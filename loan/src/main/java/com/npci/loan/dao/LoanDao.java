package com.npci.loan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.npci.loan.bean.Customer;
import com.npci.loan.bean.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> { 

	public Loan save(Loan loan);

	
	@Query("SELECT DISTINCT l.loanType FROM Loan l")
	List<String> findAllLoanTypes();


    @Query("SELECT l FROM Loan l WHERE l.loanId = :loanId")
    Loan findByLoanId(@Param("loanId") Long loanId);

	
	


}

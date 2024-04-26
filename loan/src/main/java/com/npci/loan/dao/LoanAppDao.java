package com.npci.loan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.loan.bean.Loan;
import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.service.LoanAppService;

public interface LoanAppDao extends JpaRepository<LoanAppTable, Integer> {



	
	
	


}

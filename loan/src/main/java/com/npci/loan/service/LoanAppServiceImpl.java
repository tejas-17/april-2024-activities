package com.npci.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.dao.LoanAppDao;

@Service
public class LoanAppServiceImpl implements LoanAppService {

    @Autowired
    private LoanAppDao loanAppDao;

    @Override
    public LoanAppTable store(LoanAppTable loanAppTable) {
        return loanAppDao.save(loanAppTable);
    }

	@Override
	public LoanAppTable getLoanAppinfo(String emailId) {
		return loanAppDao.getApplicationData(emailId);
	}
}

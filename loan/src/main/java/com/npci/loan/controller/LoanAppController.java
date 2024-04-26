package com.npci.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.npci.loan.bean.LoanAppTable;
import com.npci.loan.service.LoanAppService;

@RestController
@RequestMapping("/loanapp")
public class LoanAppController {
    
    private final LoanAppService loanAppService;

    @Autowired
    public LoanAppController(LoanAppService loanAppService) {
        this.loanAppService = loanAppService;
    }

    @PostMapping("/apply")
    public LoanAppTable applyForLoan(@RequestBody LoanAppTable loanAppTable) {
        return loanAppService.store(loanAppTable);
    }
}

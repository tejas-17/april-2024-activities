package com.npci.loan.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_application")
public class LoanAppTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    
    @OneToOne
    private Customer customer;
    
    @OneToOne
    private Loan loan;
    
    private String status;

    // Constructors
    public LoanAppTable() {
    }

    public LoanAppTable(Customer customer, Loan loan, String status) {
        this.customer = customer;
        this.loan = loan;
        this.status = status;
    }

    // Getters and Setters
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method for debugging/logging
    @Override
    public String toString() {
        return "LoanApplication{" +
                "applicationId=" + applicationId +
                ", customerId=" + customer.getCustomerId() +
                ", loanId=" + loan.getLoanId() +
                ", status='" + status + '\'' +
                '}';
    }
}

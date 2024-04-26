package com.npci.loan.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private String loanType;

    // Constructors
    public Loan() {
    }

    public Loan(String loanType) {
        this.loanType = loanType;
    }

    // Getters and Setters
    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    // toString method for debugging/logging
    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanType='" + loanType + '\'' +
                '}';
    }
}

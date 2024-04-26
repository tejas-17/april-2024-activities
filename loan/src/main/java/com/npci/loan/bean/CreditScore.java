package com.npci.loan.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credit_score")
public class CreditScore {
    @Id
    private String pan;
    private int score;

    // Constructors
    public CreditScore() {
    }

    public CreditScore(String pan, int score) {
        this.pan = pan;
        this.score = score;
    }

    // Getters and Setters
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // toString method for debugging/logging
    @Override
    public String toString() {
        return "CreditScore{" +
                "pan='" + pan + '\'' +
                ", score=" + score +
                '}';
    }
}

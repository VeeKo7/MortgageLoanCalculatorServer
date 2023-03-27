package com.example.MortgageLoanCalculator.model;

/**
 * This class represents a result object
 * that contains information related to a loan application.
 * */

public class Result {
    private boolean approved;
    private int amountApproved;
    private int loanPeriod;

    public boolean isApproved () {
        return approved;
    }

    public void setApproved (boolean approved) {
        this.approved = approved;
    }

    public int getAmountApproved () {
        return amountApproved;
    }

    public void setAmountApproved (int amountApproved) {
        this.amountApproved = amountApproved;
    }

    public int getLoanPeriod () {
        return loanPeriod;
    }

    public void setLoanPeriod (int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Result (boolean approved, int amountApproved, int loanPeriod) {
        this.approved = approved;
        this.amountApproved = amountApproved;
        this.loanPeriod = loanPeriod;
    }
}

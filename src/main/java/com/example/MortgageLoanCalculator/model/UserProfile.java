package com.example.MortgageLoanCalculator.model;

import com.example.MortgageLoanCalculator.validation.UserInputValidation;

/**
 * UserProfile represents a user who requires a loan.
 * It holds user's info like:
 * - loan amount required
 * - loan period needed to pay the loan
 * - user's personal code that identifies user's individuality - it's unique in the real world
 *
 * We implement the interface UserInputValidation,
 * because we need to validate the user's information.
 * */

public class UserProfile implements UserInputValidation {

    private final long personalCode;
    private int loanAmount;
    private int loanPeriod;
    private Scenario status;

    public long getPersonalCode() {
        return personalCode;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public Scenario getStatus() {
        return status;
    }

    public UserProfile (long personalCode, int loanAmount, int loanPeriod) {
        this.personalCode = personalCode;
        //we validate the loanAmount and loanPeriod before storing it in the user profile
        validation(loanAmount, loanPeriod);

        //we then determine the status of the user based on the user's personal code
        if (personalCode == Db.debt.personalCode) {
            status = Scenario.DEBT;
        } else if (personalCode == Db.segment1.personalCode) {
            status = Scenario.SCENARIO1;
        } else if (personalCode == Db.segment2.personalCode) {
            status = Scenario.SCENARIO2;
        } else if (personalCode == Db.segment3.personalCode) {
            status = Scenario.SCENARIO3;
        }
    }

    /**
     * Private method that belongs to the class.
     * Purpose is to validate loan amount and period using
     * the default methods inherited from the interface
     * */
    private void validation (int loanAmount, int loanPeriod) {
        //if loan is valid
        if (validateLoan(loanAmount)) {
            //valid, just assign
            this.loanAmount = loanAmount;
        }
        //if not valid to an amount, give min value
        else {
            this.loanAmount = UserInputValidation.MIN_LOAN;
        }

        //if period is valid
        if (validateLoanPeriod(loanPeriod)) {
            //if valid then just assign value
            this.loanPeriod = loanPeriod;
        }
        //if not valid, give min period
        else {
            this.loanPeriod = UserInputValidation.MIN_LOAN_PERIOD;
        }
    }
}


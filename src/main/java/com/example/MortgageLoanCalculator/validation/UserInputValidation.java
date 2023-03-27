package com.example.MortgageLoanCalculator.validation;

/**
 * Performs some validation on user input.
 * We need to check loan amount, loan period.
 * Any fields declared in interfaces are static, public, final by default.
 * */

public interface UserInputValidation {

    int MIN_LOAN = 2000;
    int MAX_LOAN = 10000;
    int MIN_LOAN_PERIOD = 12;
    int MAX_LOAN_PERIOD = 60;

    //if default is removed, cannot create a method body
    default boolean validateLoan(int loanAmount) {
        if (loanAmount >= MIN_LOAN && loanAmount <= MAX_LOAN) {
            return true;
        }
        return false;
    }

    default boolean validateLoanPeriod(int loanPeriod) {
        if (loanPeriod >= MIN_LOAN_PERIOD && loanPeriod <= MAX_LOAN_PERIOD) {
            return true;
        }
        return false;
    }
}

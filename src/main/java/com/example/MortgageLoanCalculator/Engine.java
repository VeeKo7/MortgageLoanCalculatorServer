package com.example.MortgageLoanCalculator;

import com.example.MortgageLoanCalculator.model.Db;
import com.example.MortgageLoanCalculator.model.Result;
import com.example.MortgageLoanCalculator.model.Scenario;
import com.example.MortgageLoanCalculator.model.UserProfile;

/**
 * This is our main class, and it runs
 * all the logic of the program.
 * All the processing is done in the class.
 * */

public class Engine {
    /**
     * Method calculates a credit score first then
     * determines if the calculated credit score
     * is approved.
     *
     * Credit scores that are greater than or equal to 1 are approved,
     * anything else less than 1 is invalid, meaning
     * the person is not meant to take the loan.
     *
     * @param creditModifier - user's credit modifier
     * @param loanAmount - loan amount in euros
     * @param loanPeriod - the period of the loan in months
     * @return - returns true if the credit score is approved,
     * otherwise false
     * */
    private boolean approveScore (int creditModifier, int loanAmount, int loanPeriod) {
        //credit score formula
        double creditScore = ((double) creditModifier / loanAmount) * loanPeriod;

        if (creditScore >= 1) {
            System.out.println("Credit score approved.");
            return true;
        }
        System.out.println("Credit score denied.");
        return false;
    }

    /**
     * This is the main method that starts the loan engine.
     * @param userProfile - requires userProfile for the user requesting a loan
     * */
    public Result engineStart (UserProfile userProfile) {
        //gets credit modifier for the user based on the user's personal code
        int creditModifier = Db.getCreditModifier(userProfile.getPersonalCode());

        if (creditModifier == -1) {
            /*
            * this indicates an error, meaning the user has no credit modifier,
            * this might be due to the fact that the user is in debt
            * or the user's personal code is invalid.
            * */

            //let's check the status of the user to see if they are in debt
            if (userProfile.getStatus() == Scenario.DEBT) {
                /*
                * the user's in debt, so we cannot approve the loan,
                * and print error to the console in red
                * */
                System.err.println("Loan Denied. Reason: You are in debt.");

                /*
                * if the user is in debt, then there is no reason to continue
                * the program so let's end it by a 'return' statement.
                * We don't return anything here,
                * we just want to exit the method at this point.
                * */

                return new Result(false, userProfile.getLoanAmount(), userProfile.getLoanPeriod());
            }
        }

        /*
        *  If program flow reaches this part, means the user is not in debt.
        * Now let's see if we can approve user's loan based on the user's profile.
        * */
        boolean approved = approveScore(creditModifier, userProfile.getLoanAmount(), userProfile.getLoanPeriod());

        if (approved) {
            //the loan has been approved
            System.out.println("Congratulations! Loan of amount EUR" + userProfile.getLoanAmount() + " has been approved");
            System.out.println("Pay up within " + userProfile.getLoanPeriod() + " months");
        } else {
            //the loan has been denied
            System.err.println("Loan request denied");

            int period = userProfile.getLoanPeriod();

            while (true) {
                boolean scoreIsApproved = approveScore(creditModifier, userProfile.getLoanAmount(), period++);
                if (period > 60) {
                    break;
                }

                if (scoreIsApproved) {
                    return new Result(true, userProfile.getLoanAmount(), period);
                }
            }
        }
        return new Result(approved, userProfile.getLoanAmount(), userProfile.getLoanPeriod());
    }
}

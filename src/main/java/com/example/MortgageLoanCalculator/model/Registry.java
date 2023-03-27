package com.example.MortgageLoanCalculator.model;

/**
 * Registry is for 4 different scenarios
 * and the common thing was personal code
 * and 3 of them are different, and we need
 * to extend them.
 *
 * Registry contains a personal code for identifying a scenario.
 * */

public class Registry {
    protected final long personalCode;

    public Registry(long personalCode) {
        this.personalCode = personalCode;
    }

    public long getPersonalCode() {
        return personalCode;
    }
}

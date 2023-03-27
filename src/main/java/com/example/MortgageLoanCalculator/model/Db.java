package com.example.MortgageLoanCalculator.model;

/**
 * Holds hard coded values for our 4 scenarios
 * which is debt and segment 1 to 3.
 * */

public class Db {

    /**
     * Debt has only personal code
     * */
    public static final Registry debt = new Registry(49002010965L);
    public static final Segment segment1 = new Segment(49002010976L, 100);
    public static final Segment segment2 = new Segment(49002010987L, 300);
    public static final Segment segment3 = new Segment(49002010998L, 1000);

    /**
     * Gets a credit modifier for a personal code given.
     *
     * If personal code doesn't match any of segment,
     * an error is printed and -1 is returned to indicate
     * that personal code wasn't found.
     *
     * If personal code equals a debt, -1 is also returned because
     * debt doesn't contain a credit modifier.
     *
     * @param personalCode - user's personal code
     * @return credit modifier for the user
     * */
    public static int getCreditModifier (long personalCode) {
        if (personalCode == Db.segment1.personalCode) {
            //personal code matches segment 1
            return Db.segment1.getCreditModifier();
        } else if (personalCode == Db.segment2.personalCode) {
            //personal code matches segment 2
            return Db.segment2.getCreditModifier();
        } else if (personalCode == Db.segment3.personalCode) {
            //personal code matches segment 3
            return Db.segment3.getCreditModifier();
        } else {
            //personal code doesn't match segment 1, 2 or 3
            System.out.println("Error");
        }
        /*
        * Since the method requires a return of int,
        * so even if credit modifier is not found,
        * we still need to return something. So we chose -1,
        * since there is never a credit modifier that's a negative number.
        * This is to indicate an error which we will check
        * in other classes.
        * */
        return -1;
    }
}

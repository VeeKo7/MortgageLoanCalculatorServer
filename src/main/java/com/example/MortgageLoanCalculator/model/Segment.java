package com.example.MortgageLoanCalculator.model;

public class Segment extends Registry {

    private final int creditModifier; //credit modifier for the segment

    /**
     * We created this constructor because it is required due to the fact that
     * we inherited Registry so this constructor needs to match that of registry.
     * So since we don't need it, we made it private, so it isn't accessible now.
     **/
    private Segment(long personalCode) {
        super(personalCode);
        creditModifier = 0;
    }

    /**
     * We defined our own constructor, that creates or constructs
     * a segment from two values.
     * */
    public Segment(long personalCode, int creditModifier) {
        super(personalCode);
        this.creditModifier = creditModifier;
    }

    public int getCreditModifier() {
        return creditModifier;
    }
}

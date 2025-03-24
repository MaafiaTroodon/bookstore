package ca.dal.cs.csci3130.a4.discount;

public class Membership {
    DiscountCalculationRule rule;

    public Membership(DiscountCalculationRule rule) {
        this.rule = rule;
    }

    protected DiscountCalculationRule getRule() {
        return this.rule;
    }
}

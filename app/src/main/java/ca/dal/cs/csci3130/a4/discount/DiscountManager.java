package ca.dal.cs.csci3130.a4.discount;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class DiscountManager {
    double deposit;
    String membershipType;

    public DiscountManager(double deposit, String membershipType) {
        this.deposit = deposit;
        this.membershipType = membershipType;
    }

    protected double getDiscountRate(String membershipType) {
        if (membershipType.equals(AppConstants.SILVER_MEMBERSHIP)) {
            return AppConstants.SILVER_RATE;
        } else if (membershipType.equals(AppConstants.GOLD_MEMBERSHIP)) {
            return AppConstants.GOLD_RATE;
        } else if (membershipType.equals(AppConstants.PLATINUM_MEMBERSHIP)) {
            return AppConstants.PLATINUM_RATE;
        } else return 0;
    }

    protected DiscountCalculationRule getDiscountCalculationRule() {
        double rate = getDiscountRate(this.membershipType);
        return new DiscountCalculator(rate);
    }

    protected Membership getMembership(DiscountCalculationRule rule) {
        return new Membership(rule);
    }

    protected IWallet getDalWallet() {
        return new DalWallet(this.deposit);
    }

    public double calculateDiscount() {
        StudentSRP student = new StudentSRP("First", "Last");
        student.setWallet(getDalWallet());
        student.setMembership(getMembership(getDiscountCalculationRule()));
        return student.calculateDiscount();
    }
}

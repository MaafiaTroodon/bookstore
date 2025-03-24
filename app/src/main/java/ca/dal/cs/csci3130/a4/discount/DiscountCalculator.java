package ca.dal.cs.csci3130.a4.discount;

public class DiscountCalculator implements DiscountCalculationRule {

    double discountRate;

    public DiscountCalculator(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculate(StudentSRP student) {
        return student.getWallet().getBalance() * discountRate;
    }
}

package ca.dal.cs.csci3130.a4.discount;

public class StudentSRP implements IStudent {

    String firstName;
    String lastName;
    IWallet wallet;
    Membership membership; // Added

    public StudentSRP(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void setWallet(IWallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public IWallet getWallet() {
        return this.wallet;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public double calculateDiscount() {
        return this.membership.getRule().calculate(this);
    }
}

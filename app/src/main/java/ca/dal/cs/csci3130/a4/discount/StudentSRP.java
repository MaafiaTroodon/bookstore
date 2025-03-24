package ca.dal.cs.csci3130.a4.discount;

public class StudentSRP implements IStudent {

    String firstName;
    String lastName;
    IWallet wallet;

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
        //Incomplete method, add the feature!
    }

    @Override
    public double calculateDiscount() {
        //buggy method, fix the bug!
        return 0;
    }
}

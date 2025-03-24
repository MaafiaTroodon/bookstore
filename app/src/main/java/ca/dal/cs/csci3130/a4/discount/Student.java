package ca.dal.cs.csci3130.a4.discount;

public class Student implements IStudent {
    String firstName;
    String lastName;
    IWallet wallet;
    final double DISCOUNT_RATE = 0.15;

    public Student(String firstName, String lastName) {
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

    @Override
    public double calculateDiscount() {
        double balance = this.wallet.getBalance();
        return balance * DISCOUNT_RATE;
    }
}

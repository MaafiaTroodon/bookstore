package ca.dal.cs.csci3130.a4.discount;

public class DalWallet implements IWallet {
    double balance;

    public DalWallet(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

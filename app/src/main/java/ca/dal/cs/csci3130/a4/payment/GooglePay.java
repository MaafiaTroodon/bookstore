package ca.dal.cs.csci3130.a4.payment;

public class GooglePay implements IGooglePay {
    private double balance;

    public GooglePay(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        //buggy method, fix the bug!
        return false;
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }
}

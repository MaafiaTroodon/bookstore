package ca.dal.cs.csci3130.a4.payment;

public class GooglePay implements IGooglePay {
    private double balance;

    public GooglePay(double balance) {
        this.balance = balance > 0 ? balance : 100.0; // Default credit if 0
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }
}

package ca.dal.cs.csci3130.a4.payment;

public class SmartPay implements IDalCard {
    public SmartPayAdapter adapter;
    double balance;
    double paidAmount;

    public SmartPay(SmartPayAdapter adapter) {
        this.adapter = adapter;
    }

    public void setDalBalance(double balance) {
        this.balance = balance;
    }

    public double getDalBalance() {
        return this.balance;
    }

    @Override
    public boolean pay(PaymentType paymentType, double amount) {
        //buggy method, fix the bug!
        return false;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }

}

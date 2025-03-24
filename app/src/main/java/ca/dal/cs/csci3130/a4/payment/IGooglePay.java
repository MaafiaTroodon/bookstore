package ca.dal.cs.csci3130.a4.payment;

public interface IGooglePay {
    public boolean pay(double amount);

    public double getCurrentBalance();
}

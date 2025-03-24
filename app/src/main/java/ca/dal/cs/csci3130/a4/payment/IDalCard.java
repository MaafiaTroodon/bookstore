package ca.dal.cs.csci3130.a4.payment;

public interface IDalCard {
    public boolean pay(PaymentType paymentType, double amount);

}

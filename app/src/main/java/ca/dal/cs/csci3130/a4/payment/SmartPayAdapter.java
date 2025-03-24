package ca.dal.cs.csci3130.a4.payment;

public class SmartPayAdapter implements IDalCard {
    public IGooglePay googlePay;

    public SmartPayAdapter(IGooglePay googlePay) {
        this.googlePay = googlePay;
    }

    @Override
    public boolean pay(PaymentType paymentType, double amount) {
        return this.googlePay.pay(amount); // Adapter translates DalCard pay call to GooglePay
    }
}

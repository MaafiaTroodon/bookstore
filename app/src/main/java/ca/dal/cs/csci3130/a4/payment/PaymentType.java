package ca.dal.cs.csci3130.a4.payment;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class PaymentType {
    String type;

    public final static PaymentType GooglePayment = new PaymentType(AppConstants.GOOGLE_PAY);
    public final static PaymentType DalPayment = new PaymentType(AppConstants.DAL_CARD);

    public PaymentType(String paymentType) {
        this.type = paymentType;
    }
}

package ca.dal.cs.csci3130.a4.payment;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class PaymentManager {
    double dalBalance;
    double googleCredit;
    String paymentType;

    public PaymentManager(double dalBalance, double googleCredit, String paymentType) {
        this.dalBalance = dalBalance;
        this.googleCredit = googleCredit;
        this.paymentType = paymentType;
    }

    protected IDalCard getDalCard() {
        SmartPay dalCard = new SmartPay(null);
        dalCard.setDalBalance(this.dalBalance);
        return dalCard;
    }

    protected double getDalBalance() {
        //buggy method, fix the bug!
        return 0;
    }

    protected IGooglePay getGooglePay() {
        IGooglePay googlePay = new GooglePay(this.googleCredit);
        return googlePay;
    }

    protected double getGoogleCredit() {
        IGooglePay googlePay = getGooglePay();
        return googlePay.getCurrentBalance();
    }

    protected SmartPay getSmartPay() {
        //buggy method, fix the bug!
        return null;
    }

    protected double getSmartPayBalance() {
        //buggy method, fix the bug!
        return 0;
    }

    public double getCurrentBalance() {
        if (this.paymentType.equals(AppConstants.DAL_CARD)) {
            return getDalBalance();
        } else if (this.paymentType.equals(AppConstants.GOOGLE_PAY)) {
            return getGoogleCredit();
        } else if (this.paymentType.equals(AppConstants.SMART_PAY)) {
            return getSmartPayBalance();
        }
        return 0;
    }

}

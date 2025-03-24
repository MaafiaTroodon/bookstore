package ca.dal.cs.csci3130.a4.payment;

import android.util.Log;

import ca.dal.cs.csci3130.a4.core.AppConstants;

public class PaymentManager {
    double dalBalance;
    double googleCredit;
    public String paymentType;
    private SmartPay smartPay;
    private IGooglePay googlePay;
    private static PaymentManager instance;


    public PaymentManager(double dalBalance, double googleCredit, String paymentType) {
        this.dalBalance = dalBalance;
        this.googleCredit = googleCredit;
        this.paymentType = paymentType;

        // Fix: only set SmartPay balance if SMART_PAY is selected
        if (paymentType.equals(AppConstants.SMART_PAY)) {
            SmartPayAdapter adapter = new SmartPayAdapter(getGooglePay());
            smartPay = new SmartPay(adapter);
            smartPay.setDalBalance(dalBalance); // Here, dalBalance is actually smartPayBalance
        }
    }

    public static PaymentManager getInstance(double dalBalance, double googleCredit, String paymentType) {
        if (instance == null) {
            instance = new PaymentManager(dalBalance, googleCredit, paymentType);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
    }

    public IDalCard getDalCard() {
        SmartPay dalCard = new SmartPay(null);
        dalCard.setDalBalance(this.dalBalance);
        return dalCard;
    }

    protected double getDalBalance() {
        return this.dalBalance;
    }

    public IGooglePay getGooglePay() {
        if (googlePay == null) {
            googlePay = new GooglePay(this.googleCredit);
        }
        return googlePay;
    }


    protected double getGoogleCredit() {
        return getGooglePay().getCurrentBalance();
    }

    public SmartPay getSmartPay() {
        if (smartPay == null) {
            SmartPayAdapter adapter = new SmartPayAdapter(getGooglePay());
            smartPay = new SmartPay(adapter);
            smartPay.setDalBalance(this.dalBalance);
        }
        return smartPay;
    }



    protected double getSmartPayBalance() {
        SmartPay smartPay = getSmartPay();
        if (this.paymentType.equals(AppConstants.DAL_CARD)) {
            return smartPay.getDalBalance();
        } else if (this.paymentType.equals(AppConstants.GOOGLE_PAY)) {
            return smartPay.adapter.googlePay.getCurrentBalance();
        } else if (this.paymentType.equals(AppConstants.SMART_PAY)) {
            return smartPay.getDalBalance();
        }
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

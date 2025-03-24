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

    public boolean pay(PaymentType paymentType, double amount) {
        boolean success = false;

        if (paymentType == PaymentType.DalPayment) {
            if (amount <= this.balance) {
                this.balance -= amount;
                this.paidAmount += amount;  // += instead of =
                success = true;
            }
        } else if (paymentType == PaymentType.GooglePayment) {
            success = adapter != null && adapter.pay(paymentType, amount);
            if (success) this.paidAmount += amount; // += instead of =
        }

        return success;
    }


    public double getPaidAmount() {
        return this.paidAmount;
    }
}

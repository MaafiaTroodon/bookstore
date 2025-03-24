package ca.dal.cs.csci3130.a4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ca.dal.cs.csci3130.a4.payment.GooglePay;
import ca.dal.cs.csci3130.a4.payment.IGooglePay;
import ca.dal.cs.csci3130.a4.payment.PaymentType;
import ca.dal.cs.csci3130.a4.payment.SmartPay;
import ca.dal.cs.csci3130.a4.payment.SmartPayAdapter;

public class SmartPayTest {

    @Test
    public void testSmartPayOperation() {
        IGooglePay googlePay = new GooglePay(1000);
        SmartPayAdapter adapter = new SmartPayAdapter(googlePay);
        SmartPay smartPay = new SmartPay(adapter);
        smartPay.setDalBalance(1000);

        assertTrue(smartPay.pay(PaymentType.GooglePayment, 250));
        assertTrue(smartPay.pay(PaymentType.DalPayment, 200));
        assertEquals(450, (int)smartPay.getPaidAmount());
    }

    @Test
    public void testGooglePaySuccessful() {
        IGooglePay googlePay = new GooglePay(5000);
        assertTrue(googlePay.pay(400));
        assertEquals(4600, (int)googlePay.getCurrentBalance());
    }

    @Test
    public void testGooglePayUnsuccessful() {
        IGooglePay googlePay = new GooglePay(1000);
        assertFalse(googlePay.pay(2000));
        assertEquals(1000, (int)googlePay.getCurrentBalance());
    }

    @Test
    public void testDalPaymentSuccessful() {
        SmartPay smartPay = new SmartPay(null);
        smartPay.setDalBalance(2000);
        assertTrue(smartPay.pay(PaymentType.DalPayment, 1000));
        assertEquals(1000, (int)smartPay.getDalBalance());
    }

    @Test
    public void testDalPaymentUnsuccessful() {
        SmartPay smartPay = new SmartPay(null);
        smartPay.setDalBalance(1000);
        assertFalse(smartPay.pay(PaymentType.DalPayment, 2000));
        assertEquals(1000, (int)smartPay.getDalBalance());
    }
}

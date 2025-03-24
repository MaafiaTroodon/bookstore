package ca.dal.cs.csci3130.a4.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ca.dal.cs.csci3130.a4.R;
import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.payment.GooglePay;
import ca.dal.cs.csci3130.a4.payment.IDalCard;
import ca.dal.cs.csci3130.a4.payment.IGooglePay;
import ca.dal.cs.csci3130.a4.payment.PaymentManager;
import ca.dal.cs.csci3130.a4.payment.SmartPay;
import ca.dal.cs.csci3130.a4.payment.SmartPayAdapter;
import ca.dal.cs.csci3130.a4.util.NumberUtility;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_payment);
        this.showProductPrice();
        this.loadPaymentSpinner();
        this.setupShowBalanceButton();
        this.setupPayNowButton();
    }

    protected void loadPaymentSpinner() {
        Spinner paymentSpinner = findViewById(R.id.paymentSpinner);
        List<String> paymentOptions = new ArrayList<>();
        paymentOptions.add("Select a method");
        paymentOptions.add(AppConstants.DAL_CARD);
        paymentOptions.add(AppConstants.GOOGLE_PAY);
        paymentOptions.add(AppConstants.SMART_PAY);
        ArrayAdapter<String> paymentAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, paymentOptions);
        paymentAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        paymentSpinner.setAdapter(paymentAdapter);
    }

    protected double getProductPriceFromIntent() {
        Intent productIntent = getIntent();
        return productIntent.getDoubleExtra("itemPrice", 0);
    }

    protected void showProductPrice() {
        double itemPrice = getProductPriceFromIntent();
        TextView priceLabel = findViewById(R.id.productPriceLabel);
        priceLabel.setText(NumberUtility.format2Currency(itemPrice));
    }

    protected double getProductPrice() {
        TextView priceLabel = findViewById(R.id.productPriceLabel);
        String priceText = priceLabel.getText().toString().trim();
        if (!priceText.isEmpty()) {
            return Double.parseDouble(priceText.substring(1));
        }
        return 0;
    }


    protected String getPaymentType() {
        Spinner paymentSpinner = findViewById(R.id.paymentSpinner);
        return paymentSpinner.getSelectedItem().toString();
    }

    protected double getDalCardBalanceFromSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.DAL_CARD, MODE_PRIVATE);
        return sharedPreferences.getFloat(AppConstants.DAL_CARD_BALANCE, 0);
    }

    protected double getCurrentBalance() {
        double dalBalance = getDalCardBalanceFromSharedPref();
        double googleCredit = AppConstants.GOOGLE_CREDIT;
        String paymentType = getPaymentType();
        PaymentManager manager = new PaymentManager(dalBalance, googleCredit, paymentType);
        return manager.getCurrentBalance();
    }

    protected void showBalance(double balance) {
        TextView balanceLabel = findViewById(R.id.currentBalance);
        balanceLabel.setText(NumberUtility.format2Currency(balance));
    }

    protected void setupShowBalanceButton() {
        Button showBalanceButton = findViewById(R.id.showBalanceButton);
        showBalanceButton.setOnClickListener(view -> {
            double balance = getCurrentBalance();
            showBalance(balance);
        });
    }

    protected boolean makePayment() {
        double productPrice = getProductPrice();
        double balance = getCurrentBalance();
        return productPrice <= balance;
    }

    protected void setupPayNowButton() {
        Button payNowButton = findViewById(R.id.payNowButton);
        payNowButton.setOnClickListener(view -> {
            if (makePayment()) {
                showPaymentMessage(payNowButton, AppConstants.PAYMENT_SUCCESSFUL);
            } else {
                showPaymentMessage(payNowButton, AppConstants.PAYMENT_FAILED);
            }
        });
    }

    protected void showPaymentMessage(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
package com.example.natha.tipcalculator;

import java.text.NumberFormat;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText billText;
    private EditText tipPercentageText;
    private TextView tipAmountText;
    private TextView totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billText = (EditText) findViewById(R.id.bill);
        tipPercentageText = (EditText) findViewById(R.id.percent);
        tipAmountText = (TextView) findViewById(R.id.tipAmount);
        totalText = (TextView) findViewById(R.id.total);
        billText.addTextChangedListener(calculateOnTextChange);
        tipPercentageText.addTextChangedListener(calculateOnTextChange);
    }

    private final TextWatcher calculateOnTextChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            try
            {
                NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

                Float bill = Float.parseFloat(billText.getText().toString());
                Float tipPercentage = Float.parseFloat(tipPercentageText.getText().toString());

                Float tipAmount = bill * (tipPercentage / 100);
                Float total = tipAmount + bill;

                String tipAmountMoney = moneyFormat.format(tipAmount);
                String totalMoney = moneyFormat.format(total);

                tipAmountText.setText(tipAmountMoney);
                totalText.setText(totalMoney);
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this, "Cannot calculate tip unless both fields are filled out.", Toast.LENGTH_SHORT).show();
                tipAmountText.setText("");
                totalText.setText("");
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    };
}

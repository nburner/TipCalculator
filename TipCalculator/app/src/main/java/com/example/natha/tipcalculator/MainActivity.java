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

    private EditText mBillText;
    private EditText mTipPercentageText;
    private TextView mTipAmountText;
    private TextView mTotalText;
    private TipCalculatorModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBillText = (EditText) findViewById(R.id.bill);
        mTipPercentageText = (EditText) findViewById(R.id.percent);
        mTipAmountText = (TextView) findViewById(R.id.tipAmount);
        mTotalText = (TextView) findViewById(R.id.total);
        mBillText.addTextChangedListener(calculateOnTextChange);
        mTipPercentageText.addTextChangedListener(calculateOnTextChange);
        mModel = new TipCalculatorModel();
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
                mModel.setBill(Float.parseFloat(mBillText.getText().toString()));
                mModel.setTipPercentage(Float.parseFloat(mTipPercentageText.getText().toString()));
                mModel.setTipAmount(mModel.getBill(), mModel.getTipPercentage());
                mModel.setTotal(mModel.getBill(), mModel.getTipAmount());
                mTipAmountText.setText(moneyFormat.format(mModel.getTipAmount()));
                mTotalText.setText(moneyFormat.format(mModel.getTotal()));
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this, "Cannot calculate tip unless both fields are filled out.", Toast.LENGTH_SHORT).show();
                mTipAmountText.setText("");
                mTotalText.setText("");
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };
}

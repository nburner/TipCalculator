package com.example.natha.tipcalculator;

/**
 * Created by natha on 9/4/2017.
 */

public class TipCalculatorModel {

    public Float getBill() {
        return mBill;
    }

    public void setBill(Float mBill) {
        this.mBill = mBill;
    }

    public Float getTipPercentage() {
        return mTipPercentage;
    }

    public void setTipPercentage(Float mTipPercentage) {
        this.mTipPercentage = mTipPercentage;
    }

    public Float getTipAmount() {
        return mTipAmount;
    }

    public void setTipAmount(Float bill, Float tipPercentage) {
        this.mTipAmount = bill * (tipPercentage / 100);
    }

    public Float getTotal() {
        return mTotal;
    }

    public void setTotal(Float bill, Float tipAmount) {
        this.mTotal = bill + tipAmount;
    }

    Float mBill;
    Float mTipPercentage;
    Float mTipAmount;
    Float mTotal;
}

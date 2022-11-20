package com.example.simplecalculator.ui.currencyConversion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrencyConversionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CurrencyConversionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
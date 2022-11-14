package com.example.simplecalculator.ui.Calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> numericExpressionText;


    public CalculatorViewModel() {
        numericExpressionText = new MutableLiveData<>();
        numericExpressionText.setValue("");
    }

    public LiveData<String> getText() {
        return numericExpressionText;
    }
    public void setText(char character) {
        numericExpressionText.setValue(numericExpressionText.getValue() + character);
    }
    public void ClearText(){
        numericExpressionText.setValue("");
    }
}
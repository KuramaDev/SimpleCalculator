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
    public void setText(String value){numericExpressionText.setValue(value);}
    public void setNumber(char character) {
        if(numericExpressionText.getValue().isEmpty() || numericExpressionText.getValue().equals("0"))
            numericExpressionText.setValue(String.valueOf(character));
        else
            numericExpressionText.setValue(numericExpressionText.getValue() + character);
    }
    public void ClearText(){
        numericExpressionText.setValue("");
    }
    public void SetToZero(){
        numericExpressionText.setValue("0");
    }
}
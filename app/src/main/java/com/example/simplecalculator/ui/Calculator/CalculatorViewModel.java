package com.example.simplecalculator.ui.Calculator;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private final MutableLiveData<String> numericExpressionText;


    public CalculatorViewModel() {
        numericExpressionText = new MutableLiveData<>();
        numericExpressionText.setValue("0");
    }

    public LiveData<String> getText() {
        return numericExpressionText;
    }
    public void setText(String value){numericExpressionText.setValue(value);}
    public void setNumber(char character) {
        if(numericExpressionText.getValue().isEmpty() || (numericExpressionText.getValue().equals("0") && character != '.'))
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
    public void DeleteLastCharacter(){
        String current = numericExpressionText.getValue();
        current = current.replaceAll(".$", "");
        if(current.isEmpty())
            numericExpressionText.setValue("0");
        else
            numericExpressionText.setValue(current);
    }

    public void addSign(){
        String current = numericExpressionText.getValue();
        if (current.contains("-")){
            Log.d("YOLO", "Found minus");
            current = current.replace("-","");
        }
        else{
            current = "-" + current;
        }
        numericExpressionText.setValue(current);
    }
}
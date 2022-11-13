package com.example.simplecalculator.ui.Calculator;


import com.example.simplecalculator.Models.Operator;

public class CalculatorPresenter<V extends CalculatorFragmentView> {

    private float operand=0;
    private float operand2=0;
    private float total=0;
    private Operator currentOperator;

    public void SetCurrentOperator(Operator operator){
        currentOperator = operator;
        //Better syntax button.enabled = (currentOperator != Operator.Divide)
        if(currentOperator == Operator.DIVIDE){
            //TODO: Disable 0 button
        }
        else{//TODO: Enable
             }

    }

    public float CalculateResult(float currentValue){
        if (currentOperator == Operator.ADD){
            total += currentValue;
        }
        else if (currentOperator == Operator.SUBSTRACT){
            total -= currentValue;
        }
        else if (currentOperator == Operator.MULTIPLY){
            total *= currentValue;
        }
        else if (currentOperator == Operator.DIVIDE){
            total /= currentValue;
        }
        return 0;
    }
}

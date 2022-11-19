package com.example.simplecalculator.ui.Calculator;


import android.util.Log;

import com.example.simplecalculator.Models.Operator;

public class CalculatorPresenter<V extends CalculatorFragmentView> {

    final String TAG = this.getClass().getSimpleName();
    CalculatorFragmentView view;
    private float total=0;
    private boolean calculateOnOperator ;
    private Operator currentOperator;
    private String Operand1 = "";
    private String Operand2 = "";

    public String getOperand1() {
        return Operand1;
    }

    public String getOperand2() {
        return Operand2;
    }

    public CalculatorPresenter(){
        Operand1 = "";
        Operand2 = "";
        currentOperator = Operator.NONE;
    }

    public void SetCurrentOperator(Operator operator){
        currentOperator = operator;
    }

    public String CalculateResult(String currentValueS){
        if(currentOperator == Operator.NONE) {
            Operand1= currentValueS;
            return currentValueS;
        }

        if(Operand1.isEmpty()){
            Operand1= currentValueS;
            return Operand1;
        }
        else{
            Operand2 = currentValueS;
        }
        float operand1Number = Float.parseFloat(Operand1);
        float operand2Number = Float.parseFloat(Operand2);
        if (currentOperator == Operator.ADD){
            total = operand1Number + operand2Number;
        }
        else if (currentOperator == Operator.SUBSTRACT){
            total = operand1Number - operand2Number;
        }
        else if (currentOperator == Operator.MULTIPLY){
            total = operand1Number * operand2Number;
        }
        else if (currentOperator == Operator.DIVIDE){
            total = operand1Number / operand2Number;
        }
        if(total == (int) total)
            Operand1 = String.valueOf((int)total);
        else
            Operand1 = String.valueOf(total);

        return Operand1;
    }

    public void ClearAll(){
        Operand1 = "";
        Operand2 = "";
        total = 0 ;
        currentOperator = Operator.NONE;
    }


}

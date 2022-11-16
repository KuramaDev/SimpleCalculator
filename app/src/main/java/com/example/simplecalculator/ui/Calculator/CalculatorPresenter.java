package com.example.simplecalculator.ui.Calculator;


import android.util.Log;

import com.example.simplecalculator.Models.Operator;

public class CalculatorPresenter<V extends CalculatorFragmentView> {

    final String TAG = this.getClass().getSimpleName();
    CalculatorFragmentView view;
    private double total=0;
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

    public void SetCurrentOperator(Operator operator, boolean operatorChange){
        currentOperator = operator;
        //Better syntax button.enabled = (currentOperator != Operator.Divide)

    }

    public String CalculateResult(String currentValueS){
        if(currentOperator == Operator.NONE) return currentValueS;
        double currentValue = Double.parseDouble(currentValueS);

        if(Operand1.isEmpty()){
            Operand1= currentValueS;
            return Operand1;
        }
        else{
            Operand2 = currentValueS;
        }
        double operand1Number = Double.parseDouble(Operand1);
        double operand2Number = Double.parseDouble(Operand2);
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
        Operand1 = String.valueOf(total);
        Log.d(TAG ,"Current result" + total );
        return String.valueOf(total);
    }

    public void ClearAll(){
        Operand1 = "";
        Operand2 = "";
        total = 0 ;
        currentOperator = Operator.NONE;
    }
}

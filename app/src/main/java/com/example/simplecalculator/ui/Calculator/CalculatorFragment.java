package com.example.simplecalculator.ui.Calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simplecalculator.Models.Operator;
import com.example.simplecalculator.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment implements  View.OnClickListener{

    private  final String TAG = this.getClass().getSimpleName();
    private FragmentCalculatorBinding binding;
    CalculatorViewModel calculatorViewModel;
    private boolean operatorOn ;
    TextView textView;
    private Button previousButton;
    private CalculatorPresenter<CalculatorFragmentView> presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);
        binding.btn0.setOnClickListener(this);
        binding.btnAC.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);
        binding.btnDelete.setOnClickListener(this);
        binding.btnDevide.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnPlus.setOnClickListener(this);
        binding.btnDot.setOnClickListener(this);
        binding.btnEquals.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
        binding.btnPositiveNegative.setOnClickListener(this);

        textView = binding.numericExpressionText;
        calculatorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        presenter = new CalculatorPresenter<>();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {

        if( operatorOn && view!=binding.btnPlus && view!=binding.btnMinus && view!=binding.btnMultiply && view!=binding.btnDevide && view!=binding.btnEquals && view!=binding.btnDelete && view!=binding.btnPositiveNegative) {
            calculatorViewModel.ClearText();
            if(previousButton != null)
                previousButton.setTextColor(Color.WHITE);
            operatorOn = false;
        }

        if(view == binding.btn0){
            calculatorViewModel.setNumber('0');
        }
        else if (view == binding.btn1) {
            calculatorViewModel.setNumber('1');
        }
        else if (view == binding.btn2){
            calculatorViewModel.setNumber('2');
        }
        else if (view == binding.btn3){
            calculatorViewModel.setNumber('3');
        }
        else if (view == binding.btn4){
            calculatorViewModel.setNumber('4');
        }
        else if (view == binding.btn5){
            calculatorViewModel.setNumber('5');
        }
        else if (view == binding.btn6){
            calculatorViewModel.setNumber('6');
        }
        else if (view == binding.btn7){
            calculatorViewModel.setNumber('7');
        }
        else if (view == binding.btn8){
            calculatorViewModel.setNumber('8');
        }
        else if (view == binding.btn9){
            calculatorViewModel.setNumber('9');
        }
        else if (view == binding.btnAC){
            presenter.ClearAll();
            calculatorViewModel.SetToZero();
            operatorOn = false;
        }
        else if (view == binding.btnClear){
            calculatorViewModel.SetToZero();
            operatorOn = true;
        }
        else if (view == binding.btnDelete){
            if(!operatorOn)
                calculatorViewModel.DeleteLastCharacter();
        }
        else if (view == binding.btnDevide){
            if(!operatorOn)  calculatorViewModel.setText(presenter.CalculateResult(calculatorViewModel.getText().getValue()));
            presenter.SetCurrentOperator(Operator.DIVIDE);
            if(previousButton != null)
            previousButton.setTextColor(Color.WHITE);
            previousButton = (Button)view;
            ((Button) view).setTextColor(Color.BLACK);
            operatorOn = true;
        }
        else if (view == binding.btnMultiply){
            if(!operatorOn) calculatorViewModel.setText(presenter.CalculateResult(calculatorViewModel.getText().getValue()));
            presenter.SetCurrentOperator(Operator.MULTIPLY);
            if(previousButton != null)
            previousButton.setTextColor(Color.WHITE);
            previousButton = (Button)view;
            ((Button) view).setTextColor(Color.BLACK);
            operatorOn = true;
        }
        else if (view == binding.btnMinus){
            if(!operatorOn) calculatorViewModel.setText(presenter.CalculateResult(calculatorViewModel.getText().getValue()));
            presenter.SetCurrentOperator(Operator.SUBSTRACT);
            if(previousButton != null)
            previousButton.setTextColor(Color.WHITE);
            previousButton = (Button)view;
            ((Button) view).setTextColor(Color.BLACK);
            operatorOn = true;
        }
        else if (view == binding.btnPlus){
            if(!operatorOn) calculatorViewModel.setText(presenter.CalculateResult(calculatorViewModel.getText().getValue()));
            presenter.SetCurrentOperator(Operator.ADD);
            if(previousButton != null)
            previousButton.setTextColor(Color.WHITE);
            previousButton = (Button)view;
            ((Button) view).setTextColor(Color.BLACK);
            operatorOn = true;
        }
        else if (view == binding.btnDot){
            calculatorViewModel.setNumber('.');
        }
        else if (view == binding.btnEquals) {
            String temp = calculatorViewModel.getText().getValue();
            calculatorViewModel.setText(presenter.CalculateResult(calculatorViewModel.getText().getValue()));
            presenter.SetCurrentOperator(Operator.NONE);
            operatorOn = true;
        }
        else if (view == binding.btnPositiveNegative){
            calculatorViewModel.addSign();
        }

    }
}
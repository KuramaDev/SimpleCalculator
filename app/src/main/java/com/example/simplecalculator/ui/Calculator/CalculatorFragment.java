package com.example.simplecalculator.ui.Calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        if( operatorOn && view!=binding.btnPlus && view!=binding.btnMinus && view!=binding.btnMultiply && view!=binding.btnDevide ) {
            //TODO: Clear Text
            calculatorViewModel.ClearText();
            operatorOn = false;
        }

        if(view == binding.btn1){
            Log.d(TAG, "Clicked n1");
            calculatorViewModel.setText('1');
        }
        else if (view == binding.btn2){
            Log.d(TAG, "Clicked n2");
            calculatorViewModel.setText('2');
        }
        else if (view == binding.btn3){
            Log.d(TAG, "Clicked n3");
            calculatorViewModel.setText('3');
        }
        else if (view == binding.btn4){
            Log.d(TAG, "Clicked n4");
            calculatorViewModel.setText('4');
        }
        else if (view == binding.btn5){
            Log.d(TAG, "Clicked n5");
            calculatorViewModel.setText('5');
        }
        else if (view == binding.btn6){
            Log.d(TAG, "Clicked n6");
            calculatorViewModel.setText('6');
        }
        else if (view == binding.btn7){
            Log.d(TAG, "Clicked n7");
            calculatorViewModel.setText('7');
        }
        else if (view == binding.btn8){
            Log.d(TAG, "Clicked n8");
            calculatorViewModel.setText('8');
        }
        else if (view == binding.btn9){
            Log.d(TAG, "Clicked n9");
            calculatorViewModel.setText('9');
        }
        else if (view == binding.btnAC){
            Log.d(TAG, "Clicked AC");
        }
        else if (view == binding.btnClear){
            Log.d(TAG, "Clicked C");
        }
        else if (view == binding.btnDelete){
            Log.d(TAG, "Clicked DEL");
        }
        else if (view == binding.btnDevide){
            Log.d(TAG, "Clicked /");

            operatorOn = true;
        }
        else if (view == binding.btnMultiply){
            Log.d(TAG, "Clicked X");
            operatorOn = true;
        }
        else if (view == binding.btnMinus){
            Log.d(TAG, "Clicked -");
            operatorOn = true;
        }
        else if (view == binding.btnPlus){
            Log.d(TAG, "Clicked +");
            presenter.SetCurrentOperator(Operator.ADD,operatorOn);
            if(!operatorOn) presenter.CalculateResult(calculatorViewModel.getText().getValue());
            operatorOn = true;
        }
        else if (view == binding.btnDot){
            Log.d(TAG, "Clicked .");
        }
        else if (view == binding.btnEquals) {
            Log.d(TAG, "Clicked =");
        }
        else if (view == binding.btn0) {
            Log.d(TAG, "Clicked 0");
            calculatorViewModel.setText('0');
        }



    }
}
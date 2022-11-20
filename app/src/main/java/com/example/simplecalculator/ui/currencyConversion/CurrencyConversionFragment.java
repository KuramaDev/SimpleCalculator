package com.example.simplecalculator.ui.currencyConversion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simplecalculator.R;
import com.example.simplecalculator.Utils.Utils;
import com.example.simplecalculator.databinding.FragmentCurrencyConversionBinding;
import com.example.simplecalculator.ui.Base.BaseActivity;

import java.util.Arrays;

public class CurrencyConversionFragment extends Fragment implements CurrencyConversionView {

    private FragmentCurrencyConversionBinding binding;
    private CurrencyConversionPresenterImp<CurrencyConversionView> presenter;
    private BaseActivity parentContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CurrencyConversionViewModel homeViewModel =
                new ViewModelProvider(this).get(CurrencyConversionViewModel.class);

        binding = FragmentCurrencyConversionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        presenter = new CurrencyConversionPresenterImp<>();
        presenter.onAttach(this);
        ShowLoading();
        presenter.FetchSymbols();
        binding.toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.currencyToSymbol.setText(adapterView.getSelectedItem().toString());
                binding.currencyDescriptionResult.setText(presenter.searchSymbolDescription(adapterView.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.currencyFromSymbol.setText(adapterView.getSelectedItem().toString());
                binding.currencyDescription.setText(presenter.searchSymbolDescription(adapterView.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.editTextNumberDecimal.getText().toString().isEmpty())
                    presenter.ConvertAmount(Float.parseFloat(binding.editTextNumberDecimal.getText().toString()),
                                                    binding.toSpinner.getSelectedItem().toString(),
                                                    binding.fromSpinner.getSelectedItem().toString());
                else {
                    Toast.makeText(getContext(),"No value to convert",Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void ShowLoading() {
        Utils.getInstance().showLoadingDialog((BaseActivity) getActivity());
    }

    @Override
    public void HideLoading() {
        Utils.getInstance().HideLoadingDialog();
    }

    @Override
    public boolean isNetworkConnected(Context context) {
        return false;
    }

    @Override
    public void SymbolsFetched(String[] symbols) {
        Arrays.sort(symbols);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_row_layout,symbols);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_row_layout);
        binding.fromSpinner.setAdapter(arrayAdapter);
        binding.toSpinner.setAdapter(arrayAdapter);
        HideLoading();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void ResultFetched(float result, float rate) {
        binding.conversioResultTV.setText(String.valueOf(result));
        String fromSymbol = binding.fromSpinner.getSelectedItem().toString();
        String toSymbol = binding.toSpinner.getSelectedItem().toString();
        binding.conversionRate.setText("1 " + fromSymbol + " = " + rate + " " + toSymbol);
    }
}
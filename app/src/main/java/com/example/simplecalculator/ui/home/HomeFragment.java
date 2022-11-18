package com.example.simplecalculator.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simplecalculator.R;
import com.example.simplecalculator.Utils.Utils;
import com.example.simplecalculator.databinding.FragmentHomeBinding;
import com.example.simplecalculator.ui.Base.BaseActivity;

public class HomeFragment extends Fragment implements CurrencyConversionView {

    private FragmentHomeBinding binding;
    private CurrencyConversionPresenterImp<CurrencyConversionView> presenter;
    private BaseActivity parentContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        presenter = new CurrencyConversionPresenterImp<>();
        presenter.onAttach(this);
        ShowLoading();
        presenter.FetchSymbols();
        binding.toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.currencyToSymbol.setText(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.currencyToSymbol.setText(adapterView.getSelectedItem().toString());
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
                    Log.e("","Ypoxrewtiko pedio");
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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_row_layout,symbols);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_row_layout);
        binding.fromSpinner.setAdapter(arrayAdapter);
        binding.toSpinner.setAdapter(arrayAdapter);
        HideLoading();
    }

    @Override
    public void ResultFetched(float result) {
        Log.d("Fragment","Result Fetched" + result);
        binding.conversioResultTV.setText(String.valueOf(result));
    }
}
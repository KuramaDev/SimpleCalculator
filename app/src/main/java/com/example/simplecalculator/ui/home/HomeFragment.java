package com.example.simplecalculator.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simplecalculator.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements CurrencyConversionView {

    private FragmentHomeBinding binding;
    private CurrencyConversionPresenterImp<CurrencyConversionView> presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        presenter = new CurrencyConversionPresenterImp<>();
        presenter.onAttach(this);
        presenter.FetchSymbols();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void ShowLoading() {

    }

    @Override
    public void HideLoading() {

    }

    @Override
    public boolean isNetworkConnected(Context context) {
        return false;
    }

    @Override
    public void SymbolsFetched(String[] symbols) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,symbols);

        binding.fromSpinner.setAdapter(arrayAdapter);
        binding.toSpinner.setAdapter(arrayAdapter);
    }
}
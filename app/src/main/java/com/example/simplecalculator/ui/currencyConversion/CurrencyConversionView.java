package com.example.simplecalculator.ui.currencyConversion;

import com.example.simplecalculator.ui.Base.BaseView;

public interface CurrencyConversionView extends BaseView {
    void SymbolsFetched(String[] symbols);
    void ResultFetched(float result, float rate);
}

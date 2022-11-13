package com.example.simplecalculator.ui.Base;

import android.content.Context;

public interface BaseView{
    void ShowLoading();
    void HideLoading();
    boolean isNetworkConnected(Context context);
}

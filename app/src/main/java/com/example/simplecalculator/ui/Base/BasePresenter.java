package com.example.simplecalculator.ui.Base;

public interface BasePresenter<V extends BaseView>  {
    void onAttach(V view);
    void onDetach();
}

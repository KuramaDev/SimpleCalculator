package com.example.simplecalculator.ui.Base;

public class BasePresenterImplementation<V extends BaseView> implements BasePresenter<V> {
    private V view ;

    @Override
    public void onAttach(V view){
        this.view = view;
    }

    @Override
    public void onDetach(){
        this.view = null;
    }

    public boolean isViewAttached(){
        return  this.view != null;
    }

    public V getView(){
        return view;

    }
}

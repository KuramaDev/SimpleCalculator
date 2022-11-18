package com.example.simplecalculator.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.simplecalculator.R;
import com.example.simplecalculator.ui.Base.BaseActivity;

public class Utils {

    AlertDialog dialog;
    static  Utils instance ;

    private   Utils(){

    }

    public static Utils getInstance(){
        if(instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public void showLoadingDialog(BaseActivity context) {
        //TODO: Initialize Progress Bar dynamically
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading_dialog, null));
        builder.setCancelable(false);
        dialog  = builder.create();
        dialog.show();
    }

    public  void HideLoadingDialog(){
        dialog.dismiss();
    }
}

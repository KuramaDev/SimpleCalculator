package com.example.simplecalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.simplecalculator.ui.Base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity implements CurrencyConversionView {

    private ActivityMainBinding binding;
    private CurrencyConversionPresenterImp<CurrencyConversionView> presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        presenter = new CurrencyConversionPresenterImp<>();
        presenter.onAttach(this);
//        presenter.FetchSymbols();
//        presenter.ConvertAmount(800,"GBP","EUR");

    }

    @Override
    public void ShowLoading() {
        super.ShowLoading();
    }

    @Override
    public void HideLoading() {
        super.HideLoading();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public boolean isNetworkConnected(Context context) {
        return super.isNetworkConnected(context);
    }

}
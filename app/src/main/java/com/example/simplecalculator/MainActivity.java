package com.example.simplecalculator;

import android.content.Context;
import android.os.Bundle;

import com.example.simplecalculator.databinding.ActivityMainBinding;
import com.example.simplecalculator.ui.Base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity  {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_currency, R.id.navigation_calculator)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

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
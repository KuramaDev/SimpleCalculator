package com.example.simplecalculator.ui.currencyConversion;

import android.util.Log;

import com.example.simplecalculator.BuildConfig;
import com.example.simplecalculator.Models.ConversionResult;
import com.example.simplecalculator.Models.Symbols;
import com.example.simplecalculator.Services.ApiClient;
import com.example.simplecalculator.Services.ConversionService;
import com.example.simplecalculator.ui.Base.BasePresenter;
import com.example.simplecalculator.ui.Base.BasePresenterImplementation;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CurrencyConversionPresenterImp<V extends CurrencyConversionView> extends BasePresenterImplementation<V> implements BasePresenter<V> {

    public final String TAG = this.getClass().getSimpleName();
    private Symbols symbolsFetched;
    public void FetchSymbols(){
        ConversionService conversionAPIService = ApiClient.getClient().create(ConversionService.class);

        conversionAPIService.getSymbols(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Symbols>(){
                    @Override
                    public void onSuccess(Symbols symbols){
                        symbolsFetched = symbols;
                        getView().SymbolsFetched(symbols.getSymbols().keySet().toArray(new String[0]));
                    }

                    @Override
                    public void onError(Throwable e){
                        Log.e(TAG , "An error occurred:", e);
                    }
                });
    }


    public void ConvertAmount(float amount, String from , String to){

        ConversionService conversionAPIService = ApiClient.getClient().create(ConversionService.class);

        conversionAPIService.Convert(BuildConfig.API_KEY,from,to,amount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<ConversionResult>() {
                    @Override
                    public void onSuccess(@NonNull ConversionResult result) {
                        getView().ResultFetched(result.getConversionResult(),result.getInformation().getRate());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    public String searchSymbolDescription(String symbol){
        String description;
        if(symbolsFetched != null)
           description = symbolsFetched.getSymbols().get(symbol);
        else
            description = "";
        return description;
    }
}

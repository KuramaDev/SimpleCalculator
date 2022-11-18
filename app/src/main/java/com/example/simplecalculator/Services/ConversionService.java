package com.example.simplecalculator.Services;

import com.example.simplecalculator.Models.ConversionResult;
import com.example.simplecalculator.Models.Symbols;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ConversionService {
    @GET("symbols")
    Single<Symbols> getSymbols(@Header("apikey") String key);

    @GET("convert")
    Single<ConversionResult> Convert(@Header("apikey") String key,
                                     @Query("to") String toCode,
                                     @Query("from") String fromCode,
                                     @Query("amount") float amountToConvert);

//    @GET("{timeseries}") //
//    Single<HashMap<String,String>> GetTimeseries(@Header("apikey") String key,
//                                     @Query("start_date") String toCode,
//                                     @Query("end_date") String fromCode);
}

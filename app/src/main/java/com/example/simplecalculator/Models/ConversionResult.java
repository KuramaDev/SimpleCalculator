package com.example.simplecalculator.Models;

import com.google.gson.annotations.SerializedName;

public class ConversionResult {
    @SerializedName("date")
    String currentDate;
    @SerializedName("info")
    Info information;
    @SerializedName("query")
    Query query;
    @SerializedName("result")
    float conversionResult;
    @SerializedName("success")
    boolean statusResponse;

    public float getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(float conversionResult) {
        this.conversionResult = conversionResult;
    }

    public Info getInformation(){
        return information;
    }

    public boolean isStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(boolean statusResponse) {
        this.statusResponse = statusResponse;
    }

    public class Info {
        @SerializedName("rate")
        float rate;
        @SerializedName("timestamp")
        long timestamp;

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }
    }


    public class Query {
        @SerializedName("amount")
        float amount;
        @SerializedName("from")
        String fromCode;
        @SerializedName("to")
        String toCode;
    }


}

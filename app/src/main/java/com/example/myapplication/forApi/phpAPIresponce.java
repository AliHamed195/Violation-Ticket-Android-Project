package com.example.myapplication.forApi;

import com.google.gson.annotations.SerializedName;

public class phpAPIresponce {

    @SerializedName("state")
    private String status;
    @SerializedName("result_code")
    private int resultCode;


    public String getStatus() {
        return status;
    }

    public int getResultCode() {
        return resultCode;
    }
}

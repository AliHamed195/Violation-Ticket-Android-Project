package com.example.myapplication.forApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyApi {
    @POST("/api/data")
    Call<ResponseBody> saveData(@Body MyData data);
}

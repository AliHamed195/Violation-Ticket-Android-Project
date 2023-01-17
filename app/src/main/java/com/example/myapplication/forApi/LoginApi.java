package com.example.myapplication.forApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApi {
    @Headers("Content-Type: application/json")
    @POST("api/Auth/login")
    Call<ResponseBody> saveData(@Body LoginClass data);
}

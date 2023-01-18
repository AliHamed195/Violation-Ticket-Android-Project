package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.forApi.LoginRequest;
import com.example.myapplication.forApi.LoginService;
import com.example.myapplication.forApi.Register;
import com.example.myapplication.forApi.RegisterData;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rigister extends AppCompatActivity {

    EditText email, password, repeatPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);

        email = findViewById(R.id.inputEmailRegister);
        password = findViewById(R.id.inputPasswordRegister);
        repeatPassword = findViewById(R.id.inputRepeatPasswordRegister);
        register = findViewById(R.id.Registerbutton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!password.getText().toString().equals(repeatPassword.getText().toString())){
                    repeatPassword.setError("password not match!");
                    return;
                }


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.111:8080/pro/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Create a request body object
                RegisterData request = new RegisterData(email.getText().toString(), password.getText().toString());

                // Create the service and make the request
                Register service = retrofit.create(Register.class);
                Call<ResponseBody> call = service.rigister(request);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String responseString = response.body().string();
                                    if(responseString.equalsIgnoreCase("Sign Up Success")){
                                    // Sign Up successful
                                    Toast.makeText(getApplicationContext(), responseString.toString(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Dashboard.class));
                                    finish();
                                }else  {
                                    // Sign Up failed
                                    Toast.makeText(getApplicationContext(), responseString.toString(), Toast.LENGTH_SHORT).show();

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Handle the failure here
                        Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageTwo extends AppCompatActivity {

    TextInputEditText inputStreet, inputVehicle, inputBrand, inputColor, inputNumber;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_two);

        nextPage = findViewById(R.id.nextPageTwoCreateViolation);
        inputStreet = findViewById(R.id.inputPageTwoStreet);
        inputVehicle = findViewById(R.id.inputPageTwoVehicle);
        inputBrand = findViewById(R.id.inputPageTwoBrand);
        inputColor = findViewById(R.id.inputPageTwoColors);
        inputNumber = findViewById(R.id.inputPageTwoNumber);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولاز";

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputStreet.getText().toString().isEmpty()){
                    inputStreet.setError(errorMessageForNullData);
                    return;
                }
                if(inputVehicle.getText().toString().isEmpty()){
                    inputVehicle.setError(errorMessageForNullData);
                    return;
                }
                if(inputBrand.getText().toString().isEmpty()){
                    inputBrand.setError(errorMessageForNullData);
                    return;
                }
                if(inputColor.getText().toString().isEmpty()){
                    inputColor.setError(errorMessageForNullData);
                    return;
                }
                if(inputNumber.getText().toString().isEmpty()){
                    inputNumber.setError(errorMessageForNullData);
                    return;
                }
                Intent intent = new Intent(CreateViolationPageTwo.this,CreateViolationPageThree.class);
                startActivity(intent);
            }
        });
    }
}
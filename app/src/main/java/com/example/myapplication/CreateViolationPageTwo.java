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

        if (savedInstanceState != null) {
            if(savedInstanceState.containsKey("inputStreet"))
                inputStreet.setText(savedInstanceState.getString("inputStreet"));
            if(savedInstanceState.containsKey("inputVehicle"))
                inputVehicle.setText(savedInstanceState.getString("inputVehicle"));
            if(savedInstanceState.containsKey("inputBrand"))
                inputBrand.setText(savedInstanceState.getString("inputBrand"));
            if(savedInstanceState.containsKey("inputColor"))
                inputColor.setText(savedInstanceState.getString("inputColor"));
            if(savedInstanceState.containsKey("inputNumber"))
                inputNumber.setText(Integer.toString(savedInstanceState.getInt("inputNumber")));
        }

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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if(!inputStreet.getText().toString().isEmpty())
            savedInstanceState.putString("inputStreet", inputStreet.getText().toString());
        if(!inputVehicle.getText().toString().isEmpty())
            savedInstanceState.putString("inputVehicle", inputVehicle.getText().toString());
        if(!inputBrand.getText().toString().isEmpty())
            savedInstanceState.putString("inputBrand", inputBrand.getText().toString());
        if(!inputColor.getText().toString().isEmpty())
            savedInstanceState.putString("inputColor", inputColor.getText().toString());
        if(!inputNumber.getText().toString().isEmpty())
            savedInstanceState.putInt("inputNumber", Integer.parseInt(inputNumber.getText().toString()));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
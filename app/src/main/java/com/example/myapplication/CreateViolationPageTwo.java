package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.TictViolationData.AllViolationData;
import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageTwo extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

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

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

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
                }else{
                    inputStreet.setError(null);
                }
                if(inputVehicle.getText().toString().isEmpty()){
                    inputVehicle.setError(errorMessageForNullData);
                    return;
                }else{
                    inputVehicle.setError(null);
                }
                if(inputBrand.getText().toString().isEmpty()){
                    inputBrand.setError(errorMessageForNullData);
                    return;
                }else{
                    inputBrand.setError(null);
                }
                if(inputColor.getText().toString().isEmpty()){
                    inputColor.setError(errorMessageForNullData);
                    return;
                }else{
                    inputColor.setError(null);
                }
                if(inputNumber.getText().toString().isEmpty()){
                    inputNumber.setError(errorMessageForNullData);
                    return;
                }else{
                    inputNumber.setError(null);
                }

                AllViolationData allViolationData = AllViolationData.getViolationData();
                allViolationData.setInputStreet(inputStreet.getText().toString());
                allViolationData.setInputVehicle(inputVehicle.getText().toString());
                allViolationData.setInputBrand(inputBrand.getText().toString());
                allViolationData.setInputColor(inputColor.getText().toString());
                allViolationData.setNumber(inputNumber.getText().toString());

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);
                Intent intent = new Intent(CreateViolationPageTwo.this,CreateViolationPageThree.class);
                String allData = previousData+","+inputStreet.getText().toString()+","+inputVehicle.getText().toString()+","+inputBrand.getText().toString()+
                        inputColor.getText().toString()+","+inputNumber.getText().toString();
                intent.putExtra(CreateViolationPageThree.ALL_DATA, allData);
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
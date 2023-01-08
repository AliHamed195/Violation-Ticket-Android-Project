package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationStartPage extends AppCompatActivity {

    Button nextPage;
    TextInputEditText numberOne, numberTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_start_page);

        nextPage = findViewById(R.id.nextFirstPageCreateViolation);
        numberOne = findViewById(R.id.number1);
        numberTwo = findViewById(R.id.number2);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        if (savedInstanceState != null) {
            if(savedInstanceState.containsKey("numberOne"))
                numberOne.setText(Integer.toString(savedInstanceState.getInt("numberOne")));
            if(savedInstanceState.containsKey("numberTwo"))
                numberTwo.setText(Integer.toString(savedInstanceState.getInt("numberTwo")));
        }

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOne.getText().toString().isEmpty()){
                    numberOne.setError(errorMessageForNullData);
                    return;
                }
                if(numberTwo.getText().toString().isEmpty()){
                    numberTwo.setError(errorMessageForNullData);
                    return;
                }
                Intent intent = new Intent(CreateViolationStartPage.this,CreateViolationPageTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if(!numberOne.getText().toString().isEmpty())
            savedInstanceState.putInt("numberOne", Integer.parseInt(numberOne.getText().toString()));
        if(!numberTwo.getText().toString().isEmpty())
            savedInstanceState.putInt("numberTwo", Integer.parseInt(numberTwo.getText().toString()));
    }

    @Override
    protected void onResume() {super.onResume();}

    @Override
    protected void onPause() {super.onPause();}

}
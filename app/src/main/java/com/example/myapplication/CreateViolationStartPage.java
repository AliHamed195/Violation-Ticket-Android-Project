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

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولاز";

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

}
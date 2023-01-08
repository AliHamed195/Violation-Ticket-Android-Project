package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageSix extends AppCompatActivity {

    TextInputEditText statementOfTheOffender;
    CheckBox ownTheCar, notOwnTheCar;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_six);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        nextBtn = findViewById(R.id.nextPageSixCreateViolation);
        statementOfTheOffender = findViewById(R.id.inputPageSixStatementOfTheOffender);
        ownTheCar = findViewById(R.id.checkboxPageSixOwnTheCar);
        notOwnTheCar = findViewById(R.id.checkboxPageSixDontOwnTheCar);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ownTheCar.isChecked() && !notOwnTheCar.isChecked()){
                    ownTheCar.setError(errorMessageForNullData);
                    notOwnTheCar.setError(errorMessageForNullData);
                    return;
                }
                if(ownTheCar.isChecked() && notOwnTheCar.isChecked()){
                    ownTheCar.setError("الرحاء اختيار خيار واحد فقظ");
                    notOwnTheCar.setError("الرحاء اختيار خيار واحد فقظ");
                    return;
                }
                if(statementOfTheOffender.getText().toString().isEmpty()){
                    statementOfTheOffender.setError(errorMessageForNullData);
                    return;
                }
                startActivity(new Intent(getApplicationContext(),CreateViolationPageSeven.class));
            }
        });
    }
}
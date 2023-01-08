package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageFive extends AppCompatActivity {

    TextInputEditText foreignerNationality, number;
    CheckBox foreigner, lebanese, publicc, privatee;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_five);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولاز";

        nextPage = findViewById(R.id.nextPageFiveCreateViolation);
        foreignerNationality = findViewById(R.id.inputPageFiveTypeOfForeignerNationality);
        number = findViewById(R.id.inputPageFiveNumber);
        foreigner = findViewById(R.id.checkboxPageFiveForeigner);
        lebanese = findViewById(R.id.checkboxPageFiveLebanese);
        publicc = findViewById(R.id.checkboxPageFivePublic);
        privatee = findViewById(R.id.checkboxPageFivePrivate);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lebanese.isChecked() && !foreigner.isChecked()){
                    lebanese.setError(errorMessageForNullData);
                    foreigner.setError(errorMessageForNullData);
                    return;
                }
                if(foreigner.isChecked() && foreignerNationality.getText().toString().isEmpty()){
                    foreignerNationality.setError(errorMessageForNullData);
                    return;
                }
                if(!publicc.isChecked() && !privatee.isChecked()){
                    publicc.setError(errorMessageForNullData);
                    privatee.setError(errorMessageForNullData);
                    return;
                }
                if(number.getText().toString().isEmpty()){
                    number.setError(errorMessageForNullData);
                    return;
                }
                startActivity(new Intent(getApplicationContext(),CreateViolationPageSix.class));
            }
        });
    }
}
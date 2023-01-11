package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageSix extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

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
                }else{
                    ownTheCar.setError(null);
                    notOwnTheCar.setError(null);
                }
                if(ownTheCar.isChecked() && notOwnTheCar.isChecked()){
                    ownTheCar.setError("الرحاء اختيار خيار واحد فقظ");
                    notOwnTheCar.setError("الرحاء اختيار خيار واحد فقظ");
                    return;
                }else{
                    ownTheCar.setError(null);
                    notOwnTheCar.setError(null);
                }
                if(statementOfTheOffender.getText().toString().isEmpty()){
                    statementOfTheOffender.setError(errorMessageForNullData);
                    return;
                }else{
                    statementOfTheOffender.setError(null);
                }

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);
                Intent intent = new Intent(CreateViolationPageSix.this,CreateViolationPageSeven.class);
                String allData = previousData+","+statementOfTheOffender.getText().toString()+","+ownTheCar.isChecked()+
                        ","+notOwnTheCar.isChecked();
                intent.putExtra(CreateViolationPageSeven.ALL_DATA, allData);
                startActivity(intent);
            }
        });
    }
}
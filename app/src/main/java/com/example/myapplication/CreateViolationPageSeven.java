package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CreateViolationPageSeven extends AppCompatActivity {

    TextView newCostValue;
    TextInputEditText originalCost, message, structureNo, counterNumber, garageName;
    CheckBox isWinched;
    Button pageSevenCreateViolation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_seven);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        newCostValue = findViewById(R.id.newviolationCostValuePageSeven);
        originalCost = findViewById(R.id.costPageSeven);
        message = findViewById(R.id.inputPageSevenMessage);
        structureNo = findViewById(R.id.inputPageSevenStructureNo);
        counterNumber = findViewById(R.id.inputPageSevenCounterNumber);
        garageName = findViewById(R.id.inputPageSevenGarageName);
        isWinched = findViewById(R.id.checkboxPageSevenIsWinched);

        if(originalCost.getText().toString().isEmpty()){
            newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
        }

        originalCost.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(originalCost.getText().toString().isEmpty()){
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
                }else{
                    int v = Integer.parseInt(originalCost.getText().toString());
                    v = v * 2;
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة " +v+" ثاني خمسة عشر يوما.");
                }
            }
        });


        pageSevenCreateViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(originalCost.getText().toString().isEmpty()){
                    originalCost.setError(errorMessageForNullData);
                    return;
                }
                if(message.getText().toString().isEmpty()){
                    message.setError(errorMessageForNullData);
                    return;
                }
                if(structureNo.getText().toString().isEmpty()){
                    structureNo.setError(errorMessageForNullData);
                    return;
                }
                if(counterNumber.getText().toString().isEmpty()){
                    counterNumber.setError(errorMessageForNullData);
                    return;
                }
                if(garageName.getText().toString().isEmpty()){
                    garageName.setError(errorMessageForNullData);
                    return;
                }
            }
        });

    }
}
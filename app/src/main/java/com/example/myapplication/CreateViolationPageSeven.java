package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CreateViolationPageSeven extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

    TextView newCostValue;
    TextInputLayout originalCost;
    TextInputEditText  message, structureNo, counterNumber, garageName;
    CheckBox isWinched;
    Button pageSevenCreateViolation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_seven);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        pageSevenCreateViolation = findViewById(R.id.PageSevenCreateViolation);

        newCostValue = findViewById(R.id.newviolationCostValuePageSeven);
        originalCost = findViewById(R.id.costPageSeven);
        message = findViewById(R.id.inputPageSevenMessage);
        structureNo = findViewById(R.id.inputPageSevenStructureNo);
        counterNumber = findViewById(R.id.inputPageSevenCounterNumber);
        garageName = findViewById(R.id.inputPageSevenGarageName);
        isWinched = findViewById(R.id.checkboxPageSevenIsWinched);

        if(originalCost.getEditText().getText().toString().isEmpty()){
            newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
        }

        originalCost.getEditText().addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(originalCost.getEditText().getText().toString().isEmpty()){
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
                }else{
                    int v = Integer.parseInt(originalCost.getEditText().getText().toString());
                    v = v * 2;
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة " +v+" ثاني خمسة عشر يوما.");
                }
            }
        });


        pageSevenCreateViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(originalCost.getEditText().getText().toString().isEmpty()){
                    originalCost.setError(errorMessageForNullData);
                    return;
                }else{
                    originalCost.setError(null);
                }
                if(message.getText().toString().isEmpty()){
                    message.setError(errorMessageForNullData);
                    return;
                }else{
                    message.setError(null);
                }
                if(structureNo.getText().toString().isEmpty()){
                    structureNo.setError(errorMessageForNullData);
                    return;
                }else{
                    structureNo.setError(null);
                }
                if(counterNumber.getText().toString().isEmpty()){
                    counterNumber.setError(errorMessageForNullData);
                    return;
                }else{
                    counterNumber.setError(null);
                }
                if(garageName.getText().toString().isEmpty()){
                    garageName.setError(errorMessageForNullData);
                    return;
                }else{
                    garageName.setError(null);
                }

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);

                // Do not forget to add the inputs of this page
                Toast.makeText(getApplicationContext(),previousData,Toast.LENGTH_LONG).show();

            }
        });
    }
}
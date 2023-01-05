package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class CreateViolationPageSeven extends AppCompatActivity {

    TextView newCostValue;
    TextInputLayout originalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_seven);


        newCostValue = findViewById(R.id.newviolationCostValuePageSeven);
        originalCost = findViewById(R.id.costPageSeven);

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



    }
}
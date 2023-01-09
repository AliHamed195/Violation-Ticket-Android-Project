package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageThree extends AppCompatActivity {

    TextInputEditText violationTypeText;
    Spinner violationTypes , subject;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_three);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        nextPage = findViewById(R.id.nextPageThreeCreateViolation);

        violationTypeText = findViewById(R.id.inputPageThreeViolationTypeText);
        violationTypes = findViewById(R.id.inputPageThreeViolationTypesSpinner);
        subject = findViewById(R.id.inputPageThreeViolationSubjectSpinner);

        ArrayAdapter<CharSequence> adapterListOne=ArrayAdapter.createFromResource(this, R.array.type_Violation, android.R.layout.simple_spinner_item);
        adapterListOne.setDropDownViewResource(android.R.layout.simple_spinner_item);

        violationTypes.setAdapter(adapterListOne);

        violationTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            ArrayAdapter<CharSequence> newAdapter;
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(violationTypes.getSelectedItem().toString().equals("فئة أولى")){
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.type_Violation1, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }else if(violationTypes.getSelectedItem().toString().equals("فئة ثانية")){
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.type_Violation2, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }else if(violationTypes.getSelectedItem().toString().equals("فئة ثالثة")){
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.type_Violation3, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }else if(violationTypes.getSelectedItem().toString().equals("فئة رابعة")){
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.type_Violation4, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }else if(violationTypes.getSelectedItem().toString().equals("فئة خامسة")){
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.type_Violation5, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }else{
                    newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.choseBefore, android.R.layout.simple_spinner_item);
                    subject.setAdapter(newAdapter);
                }
                if (savedInstanceState != null) {
                    if(savedInstanceState.containsKey("subject"))
                        subject.setSelection(savedInstanceState.getInt("subject"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                newAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.choseBefore, android.R.layout.simple_spinner_item);
                subject.setAdapter(newAdapter);
            }
        });

        if (savedInstanceState != null) {
            if(savedInstanceState.containsKey("violationTypeText"))
                violationTypeText.setText(savedInstanceState.getString("violationTypeText"));
            if(savedInstanceState.containsKey("violationTypes"))
                violationTypes.setSelection(savedInstanceState.getInt("violationTypes"));
            if(savedInstanceState.containsKey("subject"))
                subject.setSelection(savedInstanceState.getInt("subject"));
        }


        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(violationTypeText.getText().toString().isEmpty()){
                    violationTypeText.setError(errorMessageForNullData);
                    return;
                }else{
                    violationTypeText.setError(null);
                }
                startActivity(new Intent(getApplicationContext(),CreateViolationPageFour.class));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if(!violationTypeText.getText().toString().isEmpty())
            savedInstanceState.putString("violationTypeText", violationTypeText.getText().toString());
        if(!violationTypes.getSelectedItem().toString().isEmpty())
            savedInstanceState.putInt("violationTypes", violationTypes.getSelectedItemPosition());
        if(!subject.getSelectedItem().toString().isEmpty())
            savedInstanceState.putInt("subject", subject.getSelectedItemPosition());
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
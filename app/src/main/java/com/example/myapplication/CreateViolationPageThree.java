package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CreateViolationPageThree extends AppCompatActivity {

    Spinner violationTypes , subject;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_three);

        nextPage = findViewById(R.id.nextPageThreeCreateViolation);

        violationTypes = findViewById(R.id.violationTypes);
        subject = findViewById(R.id.violationSubject);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.type_Violation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        violationTypes.setAdapter(adapter);
        subject.setAdapter(adapter);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
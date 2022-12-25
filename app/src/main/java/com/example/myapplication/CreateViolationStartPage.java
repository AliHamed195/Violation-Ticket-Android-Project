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
    TextInputEditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_start_page);

        nextPage = findViewById(R.id.nextFirstPageCreateViolation);
        e = findViewById(R.id.number1);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateViolationStartPage.this,CreateViolationPageTwo.class);
                startActivity(intent);
            }
        });
    }
}
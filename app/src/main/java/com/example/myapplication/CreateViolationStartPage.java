package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationStartPage extends AppCompatActivity {

    Button nextFirstPage;
    TextInputEditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_start_page);

        nextFirstPage = findViewById(R.id.next);
        e = findViewById(R.id.number1);

        nextFirstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e.getText().toString().isEmpty()){
                    e.setError("Input requierd");
                    return;
                }
                Toast.makeText(CreateViolationStartPage.this,e.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
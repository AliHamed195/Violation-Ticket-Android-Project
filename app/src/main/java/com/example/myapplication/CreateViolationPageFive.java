package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateViolationPageFive extends AppCompatActivity {

    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_five);

        nextPage = findViewById(R.id.nextPageFiveCreateViolation);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CreateViolationPageSix.class));
            }
        });
    }
}